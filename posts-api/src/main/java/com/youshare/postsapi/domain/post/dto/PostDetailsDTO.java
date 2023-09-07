package com.youshare.postsapi.domain.post.dto;

import com.youshare.postsapi.domain.post.Post;

import java.time.LocalDateTime;

public record PostDetailsDTO(String content, Integer reactions, Integer comments, LocalDateTime postedDateTime, Long userId) {
    public PostDetailsDTO(Post post){
        this(post.getContent(), post.getReactions(), post.getComments(), post.getPostedDateTime(), post.getUser().getId());
    }
}
