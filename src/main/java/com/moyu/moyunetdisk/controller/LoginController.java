package com.moyu.moyunetdisk.controller;/*
 *    Create By Yelson Li on 2021/10/21.
 *    @Description 登录控制器
 */

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.moyu.moyunetdisk.def.CosmoController;
import com.moyu.moyunetdisk.entity.User;
import com.moyu.moyunetdisk.service.FileFolderService;
import com.moyu.moyunetdisk.service.FileStoreService;
import com.moyu.moyunetdisk.service.MyFileService;
import com.moyu.moyunetdisk.service.UserService;
import com.moyu.moyunetdisk.utils.MailUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@CosmoController
@Slf4j
@Validated
@RequestMapping("/login")
public class LoginController extends BaseController {

}
