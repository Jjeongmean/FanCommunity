package com.example.fanCommunity.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Profile {
    private int profileId;
    private String profileName;
    private String backNo;
    private String birthDate;
    private String regDate;
    private String updateDate;
    private int userId;

    private User user;
}
