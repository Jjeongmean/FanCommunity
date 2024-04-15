package com.example.fanCommunity.dao;

import com.example.fanCommunity.dto.Profile;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface ProfileDao {
    public Profile getProfile(int userId) throws Exception;

    public void updateProfile(Profile profile) throws Exception;

    public void deleteProfile(int userId) throws Exception;
}
