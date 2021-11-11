package com.moyu.moyunetdisk.utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.Date;

@Slf4j
@Component
public class MailUtils {

    private JavaMailSenderImpl mailSender;

    @Autowired
    public MailUtils(JavaMailSenderImpl mailSender){
        this.mailSender = mailSender;
    }

    /**
     * 发送简单邮件
     * @param title 邮件标题
     * @param text 邮件内容（简单邮件不支持HTML标签）
     * @param acceptEmail 接收方邮件
     */
    public void sendSimpleMailMessage(String title,String text,String acceptEmail){
        log.info("开始发送简单邮件...");
        log.info("mailSender对象为:"+mailSender);
        SimpleMailMessage message = new SimpleMailMessage();
        message.setSubject(title);
        message.setText(text);
        message.setFrom("yelsonli00122@163.com");
        message.setTo(acceptEmail);
        message.setCc("yelsonli00122@163.com");
        System.out.println(mailSender);
        log.info("message对象为:"+message);
        mailSender.send(message);
    }

    /**
     * 发送复杂邮件（支持邮件内容HTML解析）
     * @param title 邮件标题
     * @param text 邮件内容（简单邮件不支持HTML标签）
     * @param acceptEmail 接收方邮件
     * @throws MessagingException
     */
    public void sentComplexMailMessage(String title,String text,String acceptEmail){
        log.info("开始发送复杂邮件...");
        log.info("mailSender对象为:"+mailSender);
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage);
        try {
            helper.setSubject(title);
            helper.setText(text,true);
            helper.setFrom("yelsonli00122@163.com");
            helper.setTo(acceptEmail);
            helper.setCc("yelsonli00122@163.com");
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        log.info("mimeMessage对象为:"+mimeMessage);
        mailSender.send(mimeMessage);
    }

    public String sendCode(String email,String userName,String password){
        int code = (int) ((Math.random() * 9 + 1) * 100000);
        log.info("开始发送复杂邮件...");
        log.info("mailSender对象为:"+mailSender);
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage);
        try {
            helper.setSentDate(new Date());
            helper.setSubject("摸鱼网盘-邮箱验证");
            helper.setText(
                    "<h2 >摸鱼网盘-简洁、优雅</h2>" +
                    "<h3>用户邮箱验证<h3/>" +
                    "您现在正在验证摸鱼网盘账号<br>" +
                    "验证码: <span style='color : red'>"+code+"</span><br>" +
                    "用户名 :"+userName+
//                    "<br>密码 :"+password+
                    "<hr>"
//                    "<h5 style='color : red'>如果并非本人操作,请忽略本邮件</h5>"
                    ,true);
            helper.setFrom("yelsonli00122@163.com");
            helper.setTo(email);
            helper.setCc("yelsonli00122@163.com");
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        log.info("mimeMessage对象为:"+mimeMessage);
        mailSender.send(mimeMessage);
        return String.valueOf(code);
    }
}
