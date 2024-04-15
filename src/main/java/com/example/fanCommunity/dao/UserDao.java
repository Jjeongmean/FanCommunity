package com.example.fanCommunity.dao;

import com.example.fanCommunity.dto.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserDao {
    public User loginUser(User user) throws Exception;

    public void signUp(User user) throws Exception;

}
