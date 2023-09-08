package com.youshare.postsapi.domain.post.service.impl;

import com.youshare.postsapi.domain.post.PostRepository;
import com.youshare.postsapi.domain.post.dto.PostDetailsDTO;
import com.youshare.postsapi.domain.post.service.PostService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class PostServiceImpl implements PostService {
    @Autowired
    PostRepository postRepository;

    @Override
    public PostDetailsDTO getPostById(Long id) {
        var post = postRepository.findById(id)
                .orElseThrow(EntityNotFoundException::new);
        return new PostDetailsDTO(post);
    }
}
