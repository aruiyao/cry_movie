package com.cry.movie.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cry.movie.data.LoginRequset;
import com.cry.movie.entity.User;
import com.cry.movie.mapper.UserMapper;
import com.cry.movie.service.UserService;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public User getAllUsers(LoginRequset req) {
        return userMapper.getAllUsers(req);
    }

    @Override
    public void AddUser(User user) {
        userMapper.AddUser(user);
    }

    @Override
    public int checkUser(User user) {
        return userMapper.checkUser(user);
    }
}
