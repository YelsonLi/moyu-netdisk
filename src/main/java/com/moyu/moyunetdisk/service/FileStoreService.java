package com.moyu.moyunetdisk.service;

import com.moyu.moyunetdisk.entity.FileStore;

import java.util.List;

import com.baomidou.mybatisplus.extension.service.IService;

/**
 * (FileStore)表服务接口
 *
 * @author makejava
 * @since 2021-10-20 18:52:35
 */
public interface FileStoreService extends IService<FileStore> {

    /**
     * @Description 添加文件仓库（用户注册时调用）
     * @Author xw
     * @Date 21:56 2020/1/26
     * @Param [fileStore]
     * @return java.lang.Integer 返回影响数据库的行数，新增文件仓库id封装在实体类的id属性
     **/
    public Integer addFileStore(FileStore fileStore);

    /**
     * @Description 根据文件仓库id获得文件仓库
     * @Author xw
     * @Date 22:01 2020/1/26
     * @Param [fileStoreId]
     * @return com.molihub.entity.FileStore
     **/
    public FileStore getFileStoreById(Integer fileStoreId);
}
