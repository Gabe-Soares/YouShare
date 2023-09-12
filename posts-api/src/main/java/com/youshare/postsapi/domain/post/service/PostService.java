package com.youshare.postsapi.domain.post.service;

import com.youshare.postsapi.domain.post.Post;
import com.youshare.postsapi.domain.post.dto.PostDetailsDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PostService {
    public PostDetailsDTO getPostDetailsById(Long id);

    public Post getPostById(Long id);

    public Page<PostDetailsDTO> getPostFeed(Pageable pagination);

    void savePost(Post post);
}
