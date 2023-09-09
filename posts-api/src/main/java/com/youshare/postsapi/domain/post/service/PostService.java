package com.youshare.postsapi.domain.post.service;

import com.youshare.postsapi.domain.post.Post;
import com.youshare.postsapi.domain.post.dto.PostDetailsDTO;

public interface PostService {
    public PostDetailsDTO getPostDetailsById(Long id);

    void savePost(Post post);
}
