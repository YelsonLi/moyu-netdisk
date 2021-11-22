package com.moyu.moyunetdisk.mapper;

import com.moyu.moyunetdisk.entity.FileFolder;
import com.moyu.moyunetdisk.entity.MyFile;
import org.apache.ibatis.annotations.Param;

import java.util.List;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * (FileFolder)表数据库访问层
 *
 * @author makejava
 * @since 2021-10-20 15:10:45
 */
public interface FileFolderMapper extends BaseMapper<FileFolder> {

    /**
     * @Description 根据仓库Id获得仓库根目录下的所有文件夹
     * @Author xw
     * @Date 23:49 2020/2/9
     * @Param [fileStoreId]
     * @return java.util.List<com.molihub.entity.FileFolder>
     **/
    List<FileFolder> getRootFoldersByFileStoreId(Integer fileStoreId);

    Integer getFileFolderCountByFileStoreId(Integer fileStoreId);

    Integer deleteFileFolderById(Integer fileFolderId);

    Integer addFileFolder(FileFolder fileFolder);

    List<MyFile> getFileByFileFolder(Integer fileFolderId);

    Integer updateFileFolderById(FileFolder fileFolder);

    List<FileFolder> getFileFolderByParentFolderId(Integer parentFolderId);

    FileFolder getFileFolderById(Integer fileFolderId);

    List<FileFolder> getFileFolderByFileStoreId(Integer fileStoreId);

    Integer deleteFileFolderByParentFolderId(Integer parentFolderId);

    Integer deleteFileFolderByFileStoreId(Integer fileStoreId);
}

