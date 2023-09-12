package com.youshare.postsapi.domain.post.service.impl;

import com.youshare.postsapi.domain.post.Post;
import com.youshare.postsapi.domain.post.PostRepository;
import com.youshare.postsapi.domain.post.dto.PostDetailsDTO;
import com.youshare.postsapi.domain.post.service.PostService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {
    @Autowired
    PostRepository postRepository;

    @Override
    public PostDetailsDTO getPostDetailsById(Long id) {
        var post = postRepository.findById(id)
                .orElseThrow(EntityNotFoundException::new);
        return new PostDetailsDTO(post);
    }

    @Override
    public Post getPostById(Long id) {
        return postRepository.findById(id)
                .orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public Page<PostDetailsDTO> getPostFeed(Pageable pagination) {
        return postRepository.findAllByVisibleTrue(pagination).map(PostDetailsDTO::new);
    }

    @Override
    public void savePost(Post post) {
        postRepository.save(post);
    }
}
