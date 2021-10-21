package com.moyu.moyunetdisk.entity;/*
 *    Create By Yelson Li on 2021/10/21.
 *
 */

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FileStoreStatistics implements Serializable {
    /**
     * 文件仓库
     */
    private FileStore fileStore;
    /**
     * 文档数
     */
    private int doc;
    /**
     * 音乐数
     */
    private int music;
    /**
     * 视频数
     */
    private int video;
    /**
     * 图像数
     */
    private int image;
    /**
     * 其他
     */
    private int other;
    /**
     * 文件数
     */
    private int fileCount;
    /**
     * 文件夹数
     */
    private int folderCount;
}
