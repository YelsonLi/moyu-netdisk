package com.moyu.moyunetdisk.def;/*
 *    Create By Yelson Li on 2021/10/20.
 *
 */

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public enum Role {
    // 普通用户
    USER(1),
    // 管理员
    ADMIN(0);

    private final Integer roleCode;

    Role(Integer roleCode) {
        this.roleCode = roleCode;
    }

}
