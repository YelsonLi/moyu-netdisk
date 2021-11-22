package com.moyu.moyunetdisk.service;

import com.moyu.moyunetdisk.entity.FileFolder;

import java.util.List;

import com.baomidou.mybatisplus.extension.service.IService;
import com.moyu.moyunetdisk.entity.MyFile;

/**
 * (FileFolder)表服务接口
 *
 * @author makejava
 * @since 2021-10-20 15:10:45
 */
public interface FileFolderService extends IService<FileFolder> {

    /**
     * @Description 根据仓库Id获得仓库根目录下的所有文件夹
     * @Author xw
     * @Date 23:46 2020/2/9
     * @Param [fileStoreId]
     * @return java.util.List<com.molihub.entity.FileFolder>
     **/
    List<FileFolder> getRootFoldersByFileStoreId(Integer fileStoreId);

    Integer deleteFileFolderById(Integer fileFolderId);

    Integer addFileFolder(FileFolder fileFolder);

    List<MyFile> getFileFolderById(Integer fileFolderId);

    Integer updateFileFolderById(FileFolder fileFolder);

    List<FileFolder> getFileFolderByParentFolderId(Integer parentFolderId);

    FileFolder getFileFolderByFileFolderId(Integer fileFolderId);
}
