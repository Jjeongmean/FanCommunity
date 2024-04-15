package com.example.fanCommunity.dao;

import com.example.fanCommunity.dto.Hashtag;

public interface HashtagDao {
    Hashtag getHashtagById(String hashtagId);
    void addHashtag(Hashtag hashtag);
    void updateHashtag(Hashtag hashtag);
    void deleteHashtag(String hashtagId);
}
