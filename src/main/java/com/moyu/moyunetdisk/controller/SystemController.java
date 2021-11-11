package com.moyu.moyunetdisk.controller;/*
 *    Create By Yelson Li on 2021/10/21.
 *    @Description: 系统页面跳转控制器
 */

import com.moyu.moyunetdisk.def.LoginRequired;
import com.moyu.moyunetdisk.entity.FileStoreStatistics;
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
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
@Slf4j
@Validated
@RequestMapping("/system")
public class SystemController extends BaseController {

    @LoginRequired
    @GetMapping("/index")
    public String index(Map<String, Object> map) {
        //获得统计信息
        FileStoreStatistics statistics = myFileService.getCountStatistics(loginUser.getFileStoreId());
        statistics.setFileStore(fileStoreService.getFileStoreById(loginUser.getFileStoreId()));
        map.put("statistics", statistics);
        return "u-admin/index";
    }
}
