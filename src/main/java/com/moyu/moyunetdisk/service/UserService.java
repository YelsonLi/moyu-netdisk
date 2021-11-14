package com.moyu.moyunetdisk.service;

import com.moyu.moyunetdisk.entity.User;

import java.util.List;

import com.baomidou.mybatisplus.extension.service.IService;

/**
 * (User)表服务接口
 *
 * @author makejava
 * @since 2021-10-20 18:54:19
 */
public interface UserService extends IService<User> {

    public User login (String currentEmail, String currentPassword);

    public boolean register(User user);

    /**
     * @Description  通过openID查询单条数据
     * @Author xw
     * @Date 18:29 2020/2/25
     * @Param [userId]
     * @return com.moti.entity.User
     **/
    User getUserByOpenId(String openId);
}
