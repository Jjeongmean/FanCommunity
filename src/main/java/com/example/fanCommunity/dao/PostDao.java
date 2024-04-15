package com.example.fanCommunity.dao;

import com.example.fanCommunity.dto.Post;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface PostDao {
    //게시물 목록
    public List<Post> getPostList(Map map) throws Exception;

    //총 게시물 수
    public int getDataCount(Map map) throws Exception;

    //상세정보
    public Post getReadPost(int postId) throws Exception;

    //조회수를 증가
    public void updateHitCount(int postId) throws Exception;

    //게시물 작성
    public void insertPost(Post post) throws Exception;

    //게시물 수정
    public void updatePost(Post post) throws Exception;

    //게시물 삭제
    public void deletePost(int postId) throws Exception;
}
