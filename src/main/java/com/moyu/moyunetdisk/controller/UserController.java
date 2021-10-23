package com.moyu.moyunetdisk.controller;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.moyu.moyunetdisk.def.CosmoController;
import com.moyu.moyunetdisk.def.ExceptionCodeEnum;
import com.moyu.moyunetdisk.def.NetDiskException;
import com.moyu.moyunetdisk.def.ValidatorUtil;
import com.moyu.moyunetdisk.entity.User;
import com.moyu.moyunetdisk.entity.UserToShow;
import com.moyu.moyunetdisk.service.FileFolderService;
import com.moyu.moyunetdisk.service.FileStoreService;
import com.moyu.moyunetdisk.service.MyFileService;
import com.moyu.moyunetdisk.service.UserService;
import com.moyu.moyunetdisk.utils.MailUtils;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.web.bind.annotation.*;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;

import javax.annotation.Resource;

/**
 * (User)表控制层
 *
 * @author makejava
 * @since 2021-10-20 18:54:19
 */
@CosmoController
@Validated
@Slf4j
@RequestMapping("/user")
public class UserController extends BaseController {

    @PostMapping("/register")
    public Object register() {
        return null;
    }

    @PostMapping("/login")
    public Object login(@RequestBody User user) {
        // 判断用户名密码是否为空
        ValidatorUtil.checkNull(user.getUserName(), "username");
        ValidatorUtil.checkNull(user.getPassword(), "password");
        // 检索登录用户
        User currentUser = userService.login(user.getUserName(), user.getPassword());
        // 返回前端用户数据
        return currentUser;
    }

}
