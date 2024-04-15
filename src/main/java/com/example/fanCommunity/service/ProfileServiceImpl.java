package com.example.fanCommunity.service;

import com.example.fanCommunity.dao.ProfileDao;
import com.example.fanCommunity.dto.Profile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class ProfileServiceImpl implements ProfileService {
    @Autowired
    private ProfileDao profileDao;

    // 실제 프로필 정보는 데이터베이스에서 가져오거나 저장하는 등의 로직을 수행해야 합니다.
    // 여기서는 간단한 예시를 들기 위해 더미 데이터를 사용하겠습니다.
    private Map<Integer, Profile> profiles = new HashMap<>();


    @Override
    public Profile getProfile(int profileId) throws Exception {
        return profileDao.getProfile(profileId);
    }

    @Override
    public void updateProfile(int profileId, Profile newProfile) throws Exception {
        profileDao.updateProfile(newProfile);
    }

    @Override
    public void updateProfile(Profile profile) throws Exception {
        return;
    }


    @Override
    public void deleteProfile(int profileId) throws Exception {
        profileDao.deleteProfile(profileId);
    }
}
