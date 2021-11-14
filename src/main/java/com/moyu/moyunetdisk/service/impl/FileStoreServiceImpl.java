package com.moyu.moyunetdisk.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.moyu.moyunetdisk.entity.FileStore;
import com.moyu.moyunetdisk.mapper.FileFolderMapper;
import com.moyu.moyunetdisk.mapper.FileStoreMapper;
import com.moyu.moyunetdisk.mapper.MyFileMapper;
import com.moyu.moyunetdisk.mapper.UserMapper;
import com.moyu.moyunetdisk.service.FileStoreService;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import javax.annotation.Resource;
import java.util.List;

/**
 * (FileStore)表服务实现类
 *
 * @author makejava
 * @since 2021-10-20 18:52:35
 */
@Service("fileStoreService")
public class FileStoreServiceImpl extends ServiceImpl<FileStoreMapper, FileStore> implements FileStoreService {
    private final UserMapper userMapper;
    private final MyFileMapper myFileMapper;
    private final FileFolderMapper fileFolderMapper;
    private final FileStoreMapper fileStoreMapper;
    @Autowired
    public FileStoreServiceImpl(UserMapper userMapper,
                                 MyFileMapper myFileMapper,
                                 FileFolderMapper fileFolderMapper,
                                 FileStoreMapper fileStoreMapper) {
        this.userMapper = userMapper;
        this.myFileMapper = myFileMapper;
        this.fileFolderMapper = fileFolderMapper;
        this.fileStoreMapper = fileStoreMapper;
    }

    @Override
    public Integer addFileStore(FileStore fileStore) {
        return fileStoreMapper.addFileStore(fileStore);
    }

    /**
     * @Description 根据文件仓库id获得文件仓库
     * @Author xw
     * @Date 22:01 2020/1/26
     * @Param [fileStoreId]
     * @return com.molihub.entity.FileStore
     **/
    @Override
    public FileStore getFileStoreById(Integer fileStoreId) {
        return fileStoreMapper.selectOne(Wrappers.lambdaQuery(FileStore.class)
        .eq(FileStore::getFileStoreId, fileStoreId));
    }
}
