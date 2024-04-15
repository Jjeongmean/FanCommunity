package com.example.fanCommunity.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Post {
    private String postId;
    private String profileName;
    private String title;
    private String content;
    private int userId;
    private String writeDate;
    private String updateDate;
    private int likes;

    private String hashtagId;


    private User user;
    private Profile profile;
    private Hashtag hashtag;
}
