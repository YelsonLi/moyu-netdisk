package com.moyu.moyunetdisk.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.moyu.moyunetdisk.def.ExceptionCodeEnum;
import com.moyu.moyunetdisk.def.NetDiskException;
import com.moyu.moyunetdisk.def.ValidatorUtil;
import com.moyu.moyunetdisk.entity.User;
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
    public User login(String currentUsername, String currentPassword) {
        User currentUser = userMapper.selectOne(Wrappers.lambdaQuery(User.class)
                .eq(User::getUserName, currentUsername)
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
}
