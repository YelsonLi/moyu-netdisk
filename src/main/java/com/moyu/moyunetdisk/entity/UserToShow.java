package com.moyu.moyunetdisk.entity;/*
 *    Create By Yelson Li on 2021/10/20.
 *
 */

import lombok.Data;

import java.util.Date;

@Data
public class UserToShow {
    /**
     * 用户ID
     */
    private Integer userId;
    /**
     * 用户名
     */
    private String userName;
    /**
     * 用户邮箱
     */
    private String email;
    /**
     * 注册时间
     */
    private Date registerTime;
    /**
     * 头像地址
     */
    private String imagePath;
    /**
     * 当前已使用百分比
     */
    private Integer current;
    /**
     * 仓库最大容量（单位KB）
     */
    private Integer maxSize;
    /**
     * 仓库权限：0可上传下载、1只允许下载、2禁止上传下载
     */
    private Integer permission;
}
