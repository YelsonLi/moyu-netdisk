package com.moyu.moyunetdisk.mapper;

import com.moyu.moyunetdisk.entity.FileStore;
import org.apache.ibatis.annotations.Param;

import java.util.List;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * (FileStore)表数据库访问层
 *
 * @author makejava
 * @since 2021-10-20 18:52:34
 */
public interface FileStoreMapper extends BaseMapper<FileStore> {

    /**
     * @Description 添加文件仓库（用户注册时调用）
     * @Author xw
     * @Date 21:56 2020/1/26
     * @Param [fileStore]
     * @return java.lang.Integer 返回影响数据库的行数，新增文件仓库id封装在实体类的id属性
     **/
    public Integer addFileStore(FileStore fileStore);

    /**
     * @Description 获得仓库的文件夹数量
     * @Author xw
     * @Date 21:56 2020/2/10
     * @Param [fileStoreId]
     * @return java.lang.Integer
     **/
    public Integer getFileFolderCountByFileStoreId(Integer fileStoreId);

}

