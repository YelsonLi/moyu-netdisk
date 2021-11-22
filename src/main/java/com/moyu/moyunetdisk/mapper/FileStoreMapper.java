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
    Integer addFileStore(FileStore fileStore);

    FileStore getFileStoreByUserId(Integer userId);

    Integer addSize(Integer id, Integer size);

    Integer subSize(Integer id, Integer size);

    Integer updatePermission(Integer id, Integer permission, Integer size);

    FileStore getFileStoreById(Integer fileStoreId);

    Integer deleteById(Integer id);
}

