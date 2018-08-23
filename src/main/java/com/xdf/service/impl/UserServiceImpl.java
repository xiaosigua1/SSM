package com.xdf.service.impl;

import com.xdf.dao.UserMapper;
import com.xdf.pojo.Users;
import com.xdf.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service//("myUserService")
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public Users login(Users user) {
        return userMapper.login(user);
    }

    @Override
    public long getTotalCounts() {
        return userMapper.getTotalCounts();
    }

    @Override
    public List<Users> findAllUsersByPage(int i, int pageSize) {
        return userMapper.findAllUsersByPage(i,pageSize);
    }
}
