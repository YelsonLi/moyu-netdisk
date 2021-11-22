package com.moyu.moyunetdisk.entity;

import java.util.Date;
import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * (MyFile)实体类
 *
 * @author Li
 * @since 2021-10-20 18:52:46
 */

/**
 * (MyFile)表数据库访问层
 *
 * @author makejava
 * @since 2021-10-20 18:52:46
 */
@Data
@Builder
@TableName("t_my_file")
public class MyFile implements Serializable {
    private static final long serialVersionUID = 760985340898954335L;
    /**
     * 文件ID
     */
    @TableId(value = "my_file_id", type = IdType.AUTO)
    private Integer myFileId;
    /**
     * 文件名
     */
    @TableField("my_file_name")
    private String myFileName;
    /**
     * 文件仓库ID
     */
    @TableField("file_store_id")
    private Integer fileStoreId;
    /**
     * 文件存储路径
     */
    @TableField("my_file_path")
    private String myFilePath;
    /**
     * 下载次数
     */
    @TableField("download_time")
    private Integer downloadTime;
    /**
     * 上传时间
     */
    @TableField("upload_time")
    private Date uploadTime;
    /**
     * 父文件夹ID
     */
    @TableField("parent_folder_id")
    private Integer parentFolderId;
    /**
     * 文件大小
     */
    @TableField("size")
    private Integer size;
    /**
     * 文件类型
     */
    @TableField("type")
    private Integer type;
    /**
     * 文件后缀
     */
    @TableField("postfix")
    private String postfix;

}
