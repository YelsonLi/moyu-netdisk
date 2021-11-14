package com.moyu.moyunetdisk.service;

import com.moyu.moyunetdisk.entity.FileStoreStatistics;
import com.moyu.moyunetdisk.entity.MyFile;

import java.util.List;

import com.baomidou.mybatisplus.extension.service.IService;

/**
 * (MyFile)表服务接口
 *
 * @author makejava
 * @since 2021-10-20 18:52:47
 */
public interface MyFileService extends IService<MyFile> {

    /**
     * @Description 获取仓库的统计信息
     * @Author xw
     * @Date 21:47 2020/2/10
     * @Param [id]
     * @return com.molihub.entity.FileStoreStatistics
     **/
    FileStoreStatistics getCountStatistics(Integer id);
}
