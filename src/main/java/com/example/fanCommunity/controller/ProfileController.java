package com.example.fanCommunity.controller;

import com.example.fanCommunity.dto.Profile;
import com.example.fanCommunity.service.ProfileService;
import com.example.fanCommunity.util.PagingUtil;
import com.example.fanCommunity.util.PhotoUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class ProfileController {
    @Autowired
    ProfileService profileService;

    @GetMapping(value = "/profile")
    public String profile() {
        return "post/profile";
    }

    // ProfileService를 주입받는 생성자
    public ProfileController(ProfileService profileService) {
        this.profileService = profileService;
    }

    // 프로필 조회
    @GetMapping("/{profileId}")
    public ResponseEntity<Profile> getProfile(@PathVariable int userId) throws Exception {
        Profile profile = profileService.getProfile(userId);
        if (profile != null) {
            return ResponseEntity.ok(profile);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // 프로필 수정
    @PutMapping("/{profileId}")
    public ResponseEntity<Void> updateProfile(@PathVariable int userId, @RequestBody Profile newProfile) throws Exception {
        Profile existingProfile = profileService.getProfile(userId);
        if (existingProfile != null) {
            profileService.updateProfile(userId, newProfile);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // 프로필 삭제
    @DeleteMapping("/{profileId}")
    public ResponseEntity<Void> deleteProfile(@PathVariable int userId) throws Exception {
        Profile existingProfile = profileService.getProfile(userId);
        if (existingProfile != null) {
            profileService.deleteProfile(userId);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
