package com.moyu.moyunetdisk.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.moyu.moyunetdisk.entity.FileFolder;
import com.moyu.moyunetdisk.entity.FileStoreStatistics;
import com.moyu.moyunetdisk.entity.MyFile;
import com.moyu.moyunetdisk.mapper.FileFolderMapper;
import com.moyu.moyunetdisk.mapper.FileStoreMapper;
import com.moyu.moyunetdisk.mapper.MyFileMapper;
import com.moyu.moyunetdisk.mapper.UserMapper;
import com.moyu.moyunetdisk.service.MyFileService;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import javax.annotation.Resource;
import java.util.List;
import java.util.Objects;

/**
 * (MyFile)表服务实现类
 *
 * @author makejava
 * @since 2021-10-20 18:52:47
 */
@Service("myFileService")
public class MyFileServiceImpl extends ServiceImpl<MyFileMapper, MyFile> implements MyFileService {
    private final UserMapper userMapper;
    private final MyFileMapper myFileMapper;
    private final FileFolderMapper fileFolderMapper;
    private final FileStoreMapper fileStoreMapper;
    @Autowired
    public MyFileServiceImpl(UserMapper userMapper,
                                MyFileMapper myFileMapper,
                                FileFolderMapper fileFolderMapper,
                                FileStoreMapper fileStoreMapper) {
        this.userMapper = userMapper;
        this.myFileMapper = myFileMapper;
        this.fileFolderMapper = fileFolderMapper;
        this.fileStoreMapper = fileStoreMapper;
    }

    @Override
    public FileStoreStatistics getCountStatistics(Integer id) {
        FileStoreStatistics statistics = myFileMapper.getCountStatistics(id);
        if (Objects.isNull(statistics.getDoc())) {
            statistics.setDoc(0);
        }
        if (Objects.isNull(statistics.getImage())) {
            statistics.setImage(0);
        }
        if (Objects.isNull(statistics.getMusic())) {
            statistics.setMusic(0);
        }
        if (Objects.isNull(statistics.getVideo())) {
            statistics.setVideo(0);
        }
        if (Objects.isNull(statistics.getOther())) {
            statistics.setOther(0);
        }
        statistics.setFolderCount(fileFolderMapper.getFileFolderCountByFileStoreId(id));
        return statistics;
    }
}
