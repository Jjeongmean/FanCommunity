package com.example.fanCommunity.service;

import com.example.fanCommunity.dto.Profile;
import org.springframework.stereotype.Service;


public interface ProfileService {
    Profile getProfile(int userId) throws Exception;

    void updateProfile(int userId, Profile newProfile) throws Exception;

    void updateProfile(Profile profile) throws Exception;

    void deleteProfile(int userId) throws Exception;
}
