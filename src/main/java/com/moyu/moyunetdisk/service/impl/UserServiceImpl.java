package com.moyu.moyunetdisk.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.moyu.moyunetdisk.def.ExceptionCodeEnum;
import com.moyu.moyunetdisk.def.NetDiskException;
import com.moyu.moyunetdisk.def.ValidatorUtil;
import com.moyu.moyunetdisk.entity.User;
import com.moyu.moyunetdisk.entity.UserToShow;
import com.moyu.moyunetdisk.mapper.FileFolderMapper;
import com.moyu.moyunetdisk.mapper.FileStoreMapper;
import com.moyu.moyunetdisk.mapper.MyFileMapper;
import com.moyu.moyunetdisk.mapper.UserMapper;
import com.moyu.moyunetdisk.service.UserService;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import javax.annotation.Resource;
import java.util.List;
import java.util.Objects;

/**
 * (User)表服务实现类
 *
 * @author makejava
 * @since 2021-10-20 18:54:19
 */
@Slf4j
@Service("userService")
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    private final UserMapper userMapper;
    private final MyFileMapper myFileMapper;
    private final FileFolderMapper fileFolderMapper;
    private final FileStoreMapper fileStoreMapper;
    @Autowired
    public UserServiceImpl(UserMapper userMapper,
                                MyFileMapper myFileMapper,
                                FileFolderMapper fileFolderMapper,
                                FileStoreMapper fileStoreMapper) {
        this.userMapper = userMapper;
        this.myFileMapper = myFileMapper;
        this.fileFolderMapper = fileFolderMapper;
        this.fileStoreMapper = fileStoreMapper;
    }

    @Override
    public User login(String currentEmail, String currentPassword) {
        User currentUser = userMapper.selectOne(Wrappers.lambdaQuery(User.class)
                .eq(User::getEmail, currentEmail)
                .eq(User::getPassword, currentPassword));
        if (Objects.isNull(currentUser)) {
            log.info("用户名或密码错误");
            throw new NetDiskException(ExceptionCodeEnum.ERROR_ACCOUNT);
        }
        return currentUser;
    }

    @Override
    public boolean register(User user) {
        return false;
    }

    @Override
    public User getUserByOpenId(String openId) {
        return userMapper.selectOne(Wrappers.lambdaQuery(User.class).eq(User::getOpenId, openId));
    }

    @Override
    public boolean insert(User user) {
        if(userMapper.insert(user) == 1){
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteById(Integer userId) {
        if(userMapper.deleteById(userId) == 1){
            return true;
        }
        return false;
    }

    @Override
    public User queryById(Integer userId) {
        return userMapper.queryById(userId);
    }

    @Override
    public User getUserByEmail(String email) {
        return userMapper.getUserByEmail(email);
    }

    @Override
    public User queryByEmailAndPwd(String email, String password) {
        return userMapper.queryByEmailAndPwd(email,password);
    }

    @Override
    public List<User> queryAll() {
        return userMapper.queryAll();
    }

    @Override
    public List<User> queryAll(User user) {
        return userMapper.queryAll(user);
    }

    @Override
    public boolean update(User user) {
        if(userMapper.update(user) == 1){
            return true;
        }
        return false;
    }

    @Override
    public List<UserToShow> getUsers() {
        return userMapper.getUsers();
    }

    @Override
    public Integer getUsersCount() {
        return userMapper.getUsersCount();
    }
}
