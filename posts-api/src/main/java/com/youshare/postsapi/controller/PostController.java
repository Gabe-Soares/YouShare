package com.youshare.postsapi.controller;

import com.youshare.postsapi.domain.post.dto.PostDetailsDTO;
import com.youshare.postsapi.domain.post.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("post")
public class PostController {
    @Autowired
    PostService postService;

    @GetMapping("/{id}")
    public ResponseEntity<PostDetailsDTO> getPostById(@PathVariable Long id){
        var post = postService.getPostById(id);
        return ResponseEntity.ok(post);
    }
}
