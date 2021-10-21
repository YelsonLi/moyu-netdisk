package com.moyu.moyunetdisk.entity;

import java.util.Date;
import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.EqualsAndHashCode;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * (FileFolder)实体类
 *
 * @author Li
 * @since 2021-10-20 15:10:45
 */

/**
 * (FileFolder)表数据库访问层
 *
 * @author makejava
 * @since 2021-10-20 15:10:45
 */
@Data
@TableName("t_file_folder")
public class FileFolder implements Serializable {
    private static final long serialVersionUID = -86702011791482009L;
    /**
     * 文件夹ID
     */
    @TableId(value = "file_folder_id", type = IdType.AUTO)
    private Integer fileFolderId;
    /**
     * 文件夹名称
     */
    @TableField("file_folder_name")
    private String fileFolderName;
    /**
     * 父文件夹ID
     */
    @TableField("parent_folder_id")
    private Integer parentFolderId;
    /**
     * 所属文件仓库ID
     */
    @TableField("file_store_id")
    private Integer fileStoreId;
    /**
     * 创建时间
     */
    @TableField("time")
    private Date time;

}
