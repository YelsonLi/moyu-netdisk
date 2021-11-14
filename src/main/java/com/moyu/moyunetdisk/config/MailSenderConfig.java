package com.moyu.moyunetdisk.config;/*
 *    Create By Yelson Li on 2021/10/21.
 *
 */

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSenderImpl;

//@Configuration
public class MailSenderConfig {
    @Bean
    public JavaMailSenderImpl getMailSender() {
        return new JavaMailSenderImpl();
    }
}
