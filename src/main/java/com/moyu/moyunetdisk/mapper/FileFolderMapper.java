package com.moyu.moyunetdisk.mapper;

import com.moyu.moyunetdisk.entity.FileFolder;
import org.apache.ibatis.annotations.Param;

import java.util.List;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * (FileFolder)表数据库访问层
 *
 * @author makejava
 * @since 2021-10-20 15:10:45
 */
public interface FileFolderMapper extends BaseMapper<FileFolder> {
    /**
     * @Description 获得仓库的文件夹数量
     * @Author xw
     * @Date 21:56 2020/2/10
     * @Param [fileStoreId]
     * @return java.lang.Integer
     **/
    Integer getFileFolderCountByFileStoreId(Integer fileStoreId);
}

