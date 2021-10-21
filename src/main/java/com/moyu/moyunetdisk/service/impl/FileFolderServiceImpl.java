package com.moyu.moyunetdisk.service.impl;

import com.moyu.moyunetdisk.entity.FileFolder;
import com.moyu.moyunetdisk.mapper.FileFolderMapper;
import com.moyu.moyunetdisk.mapper.FileStoreMapper;
import com.moyu.moyunetdisk.mapper.MyFileMapper;
import com.moyu.moyunetdisk.mapper.UserMapper;
import com.moyu.moyunetdisk.service.FileFolderService;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

/**
 * (FileFolder)表服务实现类
 *
 * @author makejava
 * @since 2021-10-20 15:10:45
 */
@Service("fileFolderService")
public class FileFolderServiceImpl extends ServiceImpl<FileFolderMapper, FileFolder> implements FileFolderService {

    private final UserMapper userMapper;
    private final MyFileMapper myFileMapper;
    private final FileFolderMapper fileFolderMapper;
    private final FileStoreMapper fileStoreMapper;
    @Autowired
    public FileFolderServiceImpl(UserMapper userMapper,
                                 MyFileMapper myFileMapper,
                                 FileFolderMapper fileFolderMapper,
                                 FileStoreMapper fileStoreMapper) {
        this.userMapper = userMapper;
        this.myFileMapper = myFileMapper;
        this.fileFolderMapper = fileFolderMapper;
        this.fileStoreMapper = fileStoreMapper;
    }

}
