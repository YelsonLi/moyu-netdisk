package com.moyu.moyunetdisk.entity;

import java.util.Date;
import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.*;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * (User)实体类
 *
 * @author Li
 * @since 2021-10-20 18:54:18
 */

/**
 * (User)表数据库访问层
 *
 * @author makejava
 * @since 2021-10-20 18:54:18
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("t_user")
@Builder
public class User implements Serializable {
    private static final long serialVersionUID = -21850424224017203L;
    /**
     * 用户ID
     */
    @TableId(value = "user_id", type = IdType.AUTO)
    private Integer userId;
    /**
     * 用户的openid
     */
    @TableField("open_id")
    private String openId;
    /**
     * 文件仓库ID
     */
    @TableField("file_store_id")
    private Integer fileStoreId;
    /**
     * 用户名
     */
    @TableField("user_name")
    private String userName;
    /**
     * 用户邮箱
     */
    @TableField("email")
    private String email;
    /**
     * 密码
     */
    @TableField("password")
    private String password;
    /**
     * 注册时间
     */
    @TableField("register_time")
    private Date registerTime;
    /**
     * 头像地址
     */
    @TableField("image_path")
    private String imagePath;
    /**
     * 用户角色,0管理员，1普通用户
     */
    @TableField("role")
    private Integer role;

}
