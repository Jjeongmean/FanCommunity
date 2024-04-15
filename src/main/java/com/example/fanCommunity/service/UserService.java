package com.example.fanCommunity.service;

import com.example.fanCommunity.dto.User;

public interface UserService {
    public User loginUser(User user) throws Exception;
    public void signUp(User user) throws Exception;

}
