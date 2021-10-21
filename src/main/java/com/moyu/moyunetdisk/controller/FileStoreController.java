package com.moyu.moyunetdisk.controller;

import com.moyu.moyunetdisk.def.CosmoController;
import com.moyu.moyunetdisk.entity.FileStore;
import com.moyu.moyunetdisk.service.FileFolderService;
import com.moyu.moyunetdisk.service.FileStoreService;
import com.moyu.moyunetdisk.service.MyFileService;
import com.moyu.moyunetdisk.service.UserService;
import com.moyu.moyunetdisk.utils.MailUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.web.bind.annotation.*;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;

import javax.annotation.Resource;

/**
 * (FileStore)表控制层
 * @Desciption
 * @author makejava
 * @since 2021-10-20 18:52:35
 */
@CosmoController
@Validated
@Slf4j
@RequestMapping("fileStore")
public class FileStoreController extends BaseController {

}
