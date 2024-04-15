package com.example.fanCommunity.service;

import com.example.fanCommunity.dao.UserDao;
import com.example.fanCommunity.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserDao userDao;


    @Override
    public User loginUser(User user) throws Exception {
        return userDao.loginUser(user);
    }

    @Override
    public void signUp(User user) throws Exception {
        userDao.signUp(user);
    }


}
