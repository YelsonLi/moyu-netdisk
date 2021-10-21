package com.moyu.moyunetdisk.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.EqualsAndHashCode;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * (FileStore)实体类
 *
 * @author Li
 * @since 2021-10-20 18:52:34
 */

/**
 * (FileStore)表数据库访问层
 *
 * @author makejava
 * @since 2021-10-20 18:52:34
 */
@Data
@TableName("t_file_store")
public class FileStore implements Serializable {
    private static final long serialVersionUID = 678050282216351588L;
    /**
     * 文件仓库ID
     */
    @TableId(value = "file_store_id", type = IdType.AUTO)
    private Integer fileStoreId;
    /**
     * 主人ID
     */
    @TableField("user_id")
    private Integer userId;
    /**
     * 当前容量（单位KB）
     */
    @TableField("current_size")
    private Integer currentSize;
    /**
     * 最大容量（单位KB）
     */
    @TableField("max_size")
    private Integer maxSize;
    /**
     * 仓库权限，0可上传下载、1不允许上传可以下载、2不可以上传下载
     */
    @TableField("permission")
    private Integer permission;

}
