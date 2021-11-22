package com.moyu.moyunetdisk.service.impl;

import com.moyu.moyunetdisk.entity.FileFolder;
import com.moyu.moyunetdisk.entity.MyFile;
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

import java.util.List;

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

    @Override
    public List<FileFolder> getRootFoldersByFileStoreId(Integer fileStoreId) {
        return fileFolderMapper.getRootFoldersByFileStoreId(fileStoreId);
    }

    /**
     * @Description 根据文件夹的id删除文件夹
     * @Author xw
     * @Date 2020/2/9 16:38
     * @Param [fileFolderId] 文件夹的id
     * @Return java.lang.Integer
     */
    @Override
    public Integer deleteFileFolderById(Integer fileFolderId) {
        return fileFolderMapper.deleteFileFolderById(fileFolderId);
    }

    /**
     * @Description 增加文件夹
     * @Author xw
     * @Date 2020/2/9 16:37
     * @Param [fileFolder] 文件夹对象
     * @Return java.lang.Integer
     */
    @Override
    public Integer addFileFolder(FileFolder fileFolder) {
        return fileFolderMapper.addFileFolder(fileFolder);
    }

    /**
     * @Description 根据文件夹的id获取文件下的文件
     * @Author xw
     * @Date 2020/2/9 16:34
     * @Param [fileFolderId] 文件夹id
     * @Return com.molihub.entity.FileFolder
     */
    @Override
    public List<MyFile> getFileFolderById(Integer fileFolderId) {
        return fileFolderMapper.getFileByFileFolder(fileFolderId);
    }

    /**
     * @Description 根据父文件夹获得所有的文件夹
     * @Author xw
     * @Date 2020/2/9 22:07
     * @Param [parentFolderId]
     * @Return java.util.List<com.molihub.entity.FileFolder>
     */
    @Override
    public Integer updateFileFolderById(FileFolder fileFolder) {
        return fileFolderMapper.updateFileFolderById(fileFolder);
    }

    /**
     * @Description 根据文件夹的id获取文件夹
     * @Author xw
     * @Date 2020/2/9 22:23
     * @Param [fileFolderId]
     * @Return com.molihub.entity.FileFolder
     */
    @Override
    public List<FileFolder> getFileFolderByParentFolderId(Integer parentFolderId) {
        return fileFolderMapper.getFileFolderByParentFolderId(parentFolderId);
    }

    /**
     * @Description 根据仓库Id获得仓库根目录下的所有文件夹
     * @Author xw
     * @Date 23:46 2020/2/9
     * @Param [fileStoreId]
     * @return java.util.List<com.molihub.entity.FileFolder>
     **/
    @Override
    public FileFolder getFileFolderByFileFolderId(Integer fileFolderId) {
        return fileFolderMapper.getFileFolderById(fileFolderId);
    }
}
