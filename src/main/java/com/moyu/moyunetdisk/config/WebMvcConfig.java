package com.moyu.moyunetdisk.config;/*
 *    Create By Yelson Li on 2021/10/20.
 *
 */

import com.moyu.moyunetdisk.interceptor.NetDiskInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.server.ErrorPage;
import org.springframework.boot.web.server.ErrorPageRegistrar;
import org.springframework.boot.web.server.ErrorPageRegistry;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer, ErrorPageRegistrar {
    private final NetDiskInterceptor netDiskInterceptor;

    @Autowired
    public WebMvcConfig(NetDiskInterceptor netDiskInterceptor) {
        this.netDiskInterceptor = netDiskInterceptor;
    }


    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("index");
        registry.addViewController("/error400Page").setViewName("error/400");
        registry.addViewController("/error401Page").setViewName("error/401");
        registry.addViewController("/error404Page").setViewName("error/404");
        registry.addViewController("/error500Page").setViewName("error/500");
    }

    @Override
    public void registerErrorPages(ErrorPageRegistry registry) {
        ErrorPage error400Page = new ErrorPage(HttpStatus.BAD_REQUEST, "/error400Page");
        ErrorPage error401Page = new ErrorPage(HttpStatus.UNAUTHORIZED, "/error401Page");
        ErrorPage error404Page = new ErrorPage(HttpStatus.NOT_FOUND, "/error404Page");
        ErrorPage error500Page = new ErrorPage(HttpStatus.INTERNAL_SERVER_ERROR, "/error500Page");
        registry.addErrorPages(error400Page,error401Page,error500Page);
    }

    // 拦截器设置的路径是请求路径
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(netDiskInterceptor)
                .addPathPatterns("/**")
                .excludePathPatterns(
                        "/","/error400Page","/error401Page"
                        ,"/error404Page"
                        ,"/error500Page",
                        "/admin","/sendCode","/loginByQQ","/login","/register","/file/share","/connection", "/asserts/**",
                        "/**/*.css", "/**/*.js","/img/**/*","/plug-ins/**/*","/u-admin/**/*",
                        "/**/fonts/*");
    }

}
