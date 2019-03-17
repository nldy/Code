package com.dc.sec_kill.service.impl;

import com.dc.sec_kill.dao.UserMapper;
import com.dc.sec_kill.entity.User;
import com.dc.sec_kill.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public User list() {
            return userMapper.selectByPrimaryKey(1);
    }
}
