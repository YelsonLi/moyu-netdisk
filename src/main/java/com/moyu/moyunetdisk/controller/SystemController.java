package com.moyu.moyunetdisk.controller;/*
 *    Create By Yelson Li on 2021/10/21.
 *    @Description: 系统页面跳转控制器
 */

import com.moyu.moyunetdisk.service.FileFolderService;
import com.moyu.moyunetdisk.service.FileStoreService;
import com.moyu.moyunetdisk.service.MyFileService;
import com.moyu.moyunetdisk.service.UserService;
import com.moyu.moyunetdisk.utils.MailUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
@Validated
@RequestMapping("")
public class SystemController extends BaseController {

}
