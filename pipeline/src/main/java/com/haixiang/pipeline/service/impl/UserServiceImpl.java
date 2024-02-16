package com.haixiang.pipeline.service.impl;

import com.haixiang.pipeline.mapper.UserMapper;
import com.haixiang.pipeline.model.User;
import com.haixiang.pipeline.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    UserMapper userMapper;

    @Override
    public List<User> find() {
        return userMapper.getUserList();
    }

    @Override
    public String anonymousInnerClasses() {
        return null;
    }
}
