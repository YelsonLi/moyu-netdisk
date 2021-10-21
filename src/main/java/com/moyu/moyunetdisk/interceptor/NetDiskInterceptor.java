package com.moyu.moyunetdisk.interceptor;/*
 *    Create By Yelson Li on 2021/10/20.
 *
 */

import com.fasterxml.jackson.core.JsonProcessingException;
import com.moyu.moyunetdisk.def.*;
import com.moyu.moyunetdisk.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.lang.reflect.Method;

import java.util.Objects;

@Slf4j
@Component
public class NetDiskInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object handler) throws Exception {
        // true则放行
        // 不拦截跨域相关请求
        if ("OPTIONS".equalsIgnoreCase(request.getMethod())) {
            return true;
        }

        if (isLoginFree(handler)) {
            return true;
        }

        // 登录成功把用户信息存入NetDiskContext
        User userInfo = handleLogin(request,response);
        NetDiskContext.put(WebConstant.CURRENT_USER_IN_SESSION, userInfo);

        return true;
    }

    private User handleLogin(HttpServletRequest request, HttpServletResponse response) throws JsonProcessingException {
        HttpSession session = request.getSession(true);
        User currentUser = (User) session.getAttribute(WebConstant.CURRENT_USER_IN_SESSION);
        if (Objects.isNull(currentUser)) {
            throw new NetDiskException(ExceptionCodeEnum.NEED_LOGIN);
        }
        return currentUser;
    }

    /**
     * 接口是否免登录
     * @param handler
     * @return
     */
    private boolean isLoginFree(Object handler) {
        // 判断接口是否免登录
        if(handler instanceof HandlerMethod) {
            HandlerMethod handlerMethod = (HandlerMethod) handler;
            Method method = handlerMethod.getMethod();
            // AnnotationUtils是Spring提供的注解工具类
            LoginRequired loginRequiredAnnotation = AnnotationUtils.getAnnotation(method,LoginRequired.class);
            LoginRequired beanRequiredAnnotation = AnnotationUtils.getAnnotation(handlerMethod.getBeanType(),LoginRequired.class);
            // 没有加@LoginRequired，不需要登录
            return loginRequiredAnnotation == null && beanRequiredAnnotation == null;
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request,
                                HttpServletResponse response,
                                Object handler,
                                Exception ex) throws Exception {
        // 及时移除，避免JoinContext内存泄漏
        if (!Objects.isNull(NetDiskContext.get(WebConstant.CURRENT_USER_IN_SESSION)))
            NetDiskContext.remove(WebConstant.CURRENT_USER_IN_SESSION);

    }
}
