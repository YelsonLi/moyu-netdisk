package com.moyu.moyunetdisk.def;/*
 *    Create By Yelson Li on 2021/10/20.
 *
 */

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public enum StorePermission {
    uploadAndDownload(0),
    onlyDownload(1),
    notUploadAndNotDownload(2);

    private final Integer storePermissionCode;

    StorePermission(Integer storePermissionCode) {
        this.storePermissionCode = storePermissionCode;
    }

}
