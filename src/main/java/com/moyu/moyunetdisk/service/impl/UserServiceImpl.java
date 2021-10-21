package com.moyu.moyunetdisk.service.impl;

import com.moyu.moyunetdisk.entity.User;
import com.moyu.moyunetdisk.mapper.FileFolderMapper;
import com.moyu.moyunetdisk.mapper.FileStoreMapper;
import com.moyu.moyunetdisk.mapper.MyFileMapper;
import com.moyu.moyunetdisk.mapper.UserMapper;
import com.moyu.moyunetdisk.service.UserService;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import javax.annotation.Resource;
import java.util.List;

/**
 * (User)表服务实现类
 *
 * @author makejava
 * @since 2021-10-20 18:54:19
 */
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
}
