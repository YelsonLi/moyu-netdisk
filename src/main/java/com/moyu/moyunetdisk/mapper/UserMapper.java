package com.moyu.moyunetdisk.mapper;

import com.moyu.moyunetdisk.entity.User;
import com.moyu.moyunetdisk.entity.UserToShow;
import org.apache.ibatis.annotations.Param;

import java.util.List;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * (User)表数据库访问层
 *
 * @author makejava
 * @since 2021-10-20 18:54:18
 */
public interface UserMapper extends BaseMapper<User> {

    int insert(User user);

    int deleteById(Integer userId);

    User queryById(Integer userId);

    User getUserByEmail(String email);

    User queryByEmailAndPwd(String email, String password);

    List<User> queryAll();

    List<User> queryAll(User user);

    int update(User user);

    List<UserToShow> getUsers();

    Integer getUsersCount();
}

