package com.example.fanCommunity.service;

import com.example.fanCommunity.dto.Post;

import java.util.List;
import java.util.Map;

public interface PostService {

    public List<Post> getPostList(Map map) throws Exception;

    public int getDataCount(Map map) throws Exception;

    Post getReadPost(int postId) throws Exception;

    void updateHitCount(int postId) throws Exception;

    public void insertPost(Post post) throws Exception;

    public void updatePost(Post post) throws Exception;

    public void deletePost(int postId) throws Exception;
}
