package com.youshare.postsapi.domain.post.service;

import com.youshare.postsapi.domain.post.dto.PostDetailsDTO;

public interface PostService {
    public PostDetailsDTO getPostById(Long id);
}
