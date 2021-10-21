package com.moyu.moyunetdisk.config;/*
 *    Create By Yelson Li on 2021/10/20.
 *
 */

import com.moyu.moyunetdisk.interceptor.NetDiskInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    private final NetDiskInterceptor netDiskInterceptor;

    @Autowired
    public WebMvcConfig(NetDiskInterceptor netDiskInterceptor) {
        this.netDiskInterceptor = netDiskInterceptor;
    }
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(netDiskInterceptor)
                .addPathPatterns("/**")
                .excludePathPatterns(
                "/","/temp-file","/error400Page","/error401Page","/error404Page","/error500Page","/uploadTempFile","/admin","/sendCode","/loginByQQ","/login","/register","/file/share","/connection",
                "/asserts/**","/**/*.css", "/**/*.js", "/**/*.png ", "/**/*.jpg"
                ,"/**/*.jpeg","/**/*.gif", "/**/fonts/*", "/**/*.svg");

    }
}
