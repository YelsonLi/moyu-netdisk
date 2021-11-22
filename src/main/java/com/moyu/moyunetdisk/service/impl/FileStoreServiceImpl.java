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

    @Override
    public FileStore getFileStoreByUserId(Integer userId) {
        return fileStoreMapper.getFileStoreByUserId(userId);
    }

    @Override
    public Integer addSize(Integer id, Integer size) {
        return fileStoreMapper.addSize(id,size);
    }

    /**
     * @Description 修改仓库当前已使用的容量
     * @Author xw
     * @Date 21:18 2020/2/10
     * @Param [id,size]
     * @return java.lang.Integer
     **/
    @Override
    public Integer subSize(Integer id, Integer size) {
        return fileStoreMapper.subSize(id,size);
    }

    /**
     * @Description 更新仓库权限
     * @Author xw
     * @Date 16:29 2020/3/10
     * @Param [id, permission]
     * @return java.lang.Integer
     **/
    @Override
    public Integer updatePermission(Integer id, Integer permission,Integer size){
        return fileStoreMapper.updatePermission(id, permission, size);
    }

    /**
     * @Description 通过主键删除仓库
     * @Author xw
     * @Date 20:32 2020/3/10
     * @Param [id]
     * @return java.lang.Integer
     **/
    @Override
    public Integer deleteById(Integer id) {
        return fileStoreMapper.deleteById(id);
    }

}
