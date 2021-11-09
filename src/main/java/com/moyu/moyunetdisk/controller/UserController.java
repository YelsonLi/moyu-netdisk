package com.moyu.moyunetdisk.controller;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.moyu.moyunetdisk.def.CosmoController;
import com.moyu.moyunetdisk.def.ExceptionCodeEnum;
import com.moyu.moyunetdisk.def.NetDiskException;
import com.moyu.moyunetdisk.def.ValidatorUtil;
import com.moyu.moyunetdisk.entity.FileStore;
import com.moyu.moyunetdisk.entity.User;
import com.moyu.moyunetdisk.utils.MailUtils;
import com.qq.connect.QQConnectException;
import com.qq.connect.api.OpenID;
import com.qq.connect.api.qzone.UserInfo;
import com.qq.connect.javabeans.AccessToken;
import com.qq.connect.javabeans.qzone.UserInfoBean;
import com.qq.connect.oauth.Oauth;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.Date;
import java.util.Map;
import java.util.Objects;

/**
 * (User)表控制层
 *
 * @author makejava
 * @since 2021-10-20 18:54:19
 */
@Controller
@Validated
@Slf4j
@RequestMapping("/user")
public class UserController extends BaseController {

    @PostMapping("/register")
    public String register(User user, String code, Map<String, Object>map) {
        String uCode = (String) session.getAttribute(user.getEmail() + "_code");
        if (!code.equals(uCode)) {
            map.put("errorMsg", "验证码错误");
            return "index";
        }
        // 用户名去空格
        user.setUserName(user.getUserName().trim());
        // todo
        user.setImagePath("http://moyu.yelson.top/userheadimg/" + user.getEmail() + ".png");
        user.setRegisterTime(new Date());
        user.setRole(1);
        if (userService.getBaseMapper().insert(user) > 0) {
            FileStore store = FileStore.builder().userId(user.getUserId()).currentSize(0).build();
            fileStoreService.addFileStore(store);
            user.setFileStoreId(store.getFileStoreId());
            userService.getBaseMapper().update(null, Wrappers.<User>lambdaUpdate()
                                                            .set(User::getFileStoreId, user.getFileStoreId())
                                                            .eq(User::getUserId, user.getUserId()));
            log.info("注册用户成功！当前注册用户" + user);
            log.info("注册仓库成功！当前注册仓库" + store);
        } else {
            map.put("errorMsg", "服务器发生错误，注册失败");
            return "index";
        }
        session.removeAttribute(user.getEmail() + "_code");
        session.setAttribute(user.getEmail(), user);
        return "redirect:/index";
    }

    // todo 返回值要改成视图对应
    @PostMapping("/login")
    public String login(User user, Map<String, Object> map) {
        // 判断用户名密码是否为空
        ValidatorUtil.checkNull(user.getEmail(), "email");
        ValidatorUtil.checkNull(user.getPassword(), "password");
        // 检索登录用户
        User currentUser = userService.login(user.getEmail(), user.getPassword());
        if (!Objects.isNull(currentUser)) {
            session.setAttribute(currentUser.getEmail(), currentUser);
            log.info("登录成功：" + currentUser);
            return "redirect:/index";
        } else {
            String errorMsg = currentUser == null ? "该邮箱尚未注册" : "密码错误";
            log.info("登录失败！请确认邮箱和密码是否正确！");
            //登录失败，将失败信息返回前端渲染
            map.put("errorMsg", errorMsg);
            return "index";
        }
    }

    @ResponseBody
    @RequestMapping("/sendCode")
    public String sendCode(String userName, String email, String password) {
        User userByEmail = userService.getBaseMapper().selectOne(Wrappers.<User>lambdaQuery()
                                                                    .eq(User::getEmail, email));
        if (userByEmail != null) {
            log.error("发送验证码失败！邮箱已被注册！");
            return "exitEmail";
        }
        log.info("开始发送邮件.../n" + "获取的到邮件发送对象为:" + mailSender);
        mailUtils = new MailUtils(mailSender);
        String code = mailUtils.sendCode(email, userName, password);
        session.setAttribute(email + "_code", code);
        return "success";
    }

    @GetMapping("/loginbyqq")
    public void login() {
        response.setContentType("text/html;charset=utf-8");
        try {
            response.sendRedirect(new Oauth().getAuthorizeURL(request));
            log.info("请求QQ登录，开始跳转...");
        } catch (QQConnectException | IOException e) {
            e.printStackTrace();
        }
    }

    @GetMapping("/qqconnection")
    public String qqConnection() {
        try {
            AccessToken accessTokenObj = (new Oauth()).getAccessTokenByRequest(request);
            String accessToken = null, openID = null;
            long tokenExpireIn = 0L;
            if ("".equals(accessTokenObj.getAccessToken())) {
                log.error("登录失败:没有获取到响应参数");
                return "accessTokenObj=>" + accessTokenObj + "; accessToken" + accessTokenObj.getAccessToken();
            } else {
                accessToken = accessTokenObj.getAccessToken();
                tokenExpireIn = accessTokenObj.getExpireIn();
                log.error("accessToken" + accessToken);
                // todo
                request.getSession().setAttribute("demo_access_token", accessToken);
                request.getSession().setAttribute("demo_token_expirein", String.valueOf(tokenExpireIn));
                // 利用获取到的accessToken 去获取当前用的openid -------- start
                OpenID openIDObj = new OpenID(accessToken);
                openID = openIDObj.getUserOpenID();
                UserInfo qzoneUserInfo = new UserInfo(accessToken, openID);
                UserInfoBean userInfoBean = qzoneUserInfo.getUserInfo();
                if (userInfoBean.getRet() == 0) {
                    log.info("用户的OPEN_ID: " + openID);
                    log.info("用户的昵称: " + removeNonBmpUnicode(userInfoBean.getNickname()));
                    log.info("用户的头像URI: " + userInfoBean.getAvatar().getAvatarURL100());
                    // 设置用户信息
                    User user = userService.getUserByOpenId(openID);
                    if (user == null){
                        user = User.builder()
                                .openId(openID).userName(removeNonBmpUnicode(userInfoBean.getNickname()))
                                .imagePath(userInfoBean.getAvatar().getAvatarURL100()).
                                        registerTime(new Date()).build();
                        if (userService.getBaseMapper().insert(user) > 0){
                            log.info("注册用户成功！当前注册用户" + user);
                            FileStore store = FileStore.builder().userId(user.getUserId()).build();
                            if (fileStoreService.addFileStore(store) == 1){
                                user.setFileStoreId(store.getFileStoreId());
                                userService.getBaseMapper().update(null, Wrappers.<User>lambdaUpdate()
                                                                                .set(User::getFileStoreId, user.getFileStoreId())
                                                                                .eq(User::getUserId, user.getUserId()));
                                log.info("注册仓库成功！当前注册仓库" + store);
                            }
                        } else {
                            log.error("注册用户失败！");
                        }
                    }else {
                        user.setUserName(removeNonBmpUnicode(userInfoBean.getNickname()));
                        user.setImagePath(userInfoBean.getAvatar().getAvatarURL100());
                        userService.getBaseMapper().update(null, Wrappers.<User>lambdaUpdate()
                                                                        .set(User::getUserName, user.getUserName())
                                                                        .set(User::getImagePath, user.getImagePath())
                                                                        .eq(User::getUserId, user.getUserId()));
                    }
                    log.info("QQ用户登录成功！"+user);
                    session.setAttribute("loginUser", user);
                    return "redirect:/index";
                } else {
                    log.error("很抱歉，我们没能正确获取到您的信息，原因是： " + userInfoBean.getMsg());
                }
            }
        } catch (QQConnectException e) {
        } finally {
            log.error("登录成功!");
        }
        return "登录失败!请查看日志信息...";
    }

    /**
     * @Description 处理掉QQ网名中的特殊表情
     * @Author xw
     * @Date 18:26 2020/2/25
     * @Param [str]
     * @return java.lang.String 返回处理之后的网名
     **/
    public String removeNonBmpUnicode(String str) {
        if (str == null) {
            return null;
        }
        str = str.replaceAll("[^\\u0000-\\uFFFF]", "");
        if ("".equals(str)) {
            str = "($ _ $)";
        }
        return str;
    }

}
