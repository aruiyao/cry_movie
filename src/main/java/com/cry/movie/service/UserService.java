package com.cry.movie.service;

import com.cry.movie.data.LoginRequset;
import com.cry.movie.entity.User;

public interface UserService {

    User getAllUsers(LoginRequset req);

    void AddUser(User user);

    int checkUser(User user);
}