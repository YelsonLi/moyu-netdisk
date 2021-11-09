package com.moyu.moyunetdisk.mapper;

import com.moyu.moyunetdisk.entity.FileStoreStatistics;
import com.moyu.moyunetdisk.entity.MyFile;
import org.apache.ibatis.annotations.Param;

import java.util.List;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * (MyFile)表数据库访问层
 *
 * @author makejava
 * @since 2021-10-20 18:52:47
 */
public interface MyFileMapper extends BaseMapper<MyFile> {
    /**
     * @Description 获取仓库的统计信息
     * @Author xw
     * @Date 21:47 2020/2/10
     * @Param [id]
     * @return com.molihub.entity.FileStoreStatistics
     **/
    FileStoreStatistics getCountStatistics(Integer id);
}

