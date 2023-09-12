package com.youshare.postsapi.controller;

import com.youshare.postsapi.domain.post.Post;
import com.youshare.postsapi.domain.post.dto.PostContentDTO;
import com.youshare.postsapi.domain.post.dto.PostDetailsDTO;
import com.youshare.postsapi.domain.post.dto.UpdatedContentDTO;
import com.youshare.postsapi.domain.post.service.PostService;
import com.youshare.postsapi.domain.user.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("post")
public class PostController {
    @Autowired
    PostService postService;

    @Autowired
    UserService userService;

    @GetMapping
    public ResponseEntity<Page<PostDetailsDTO>> getPostFeed(@PageableDefault(size=5, sort={"id"}) Pageable pagination){
        var page = postService.getPostFeed(pagination);
        return ResponseEntity.ok(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PostDetailsDTO> getPostById(@PathVariable Long id){
        var post = postService.getPostDetailsById(id);
        return ResponseEntity.ok(post);
    }

    // TODO: Adapt method to get UserId from JWT.
    @PostMapping()
    @Transactional
    public ResponseEntity postContent(@RequestBody @Valid PostContentDTO postContent, UriComponentsBuilder uriBuilder){
        var publisher = userService.getUserById(postContent.userId());
        var newPost = new Post(postContent, publisher);
        postService.savePost(newPost);
        var uri = uriBuilder.path("/post/{id}").buildAndExpand(newPost.getId()).toUri();
        return ResponseEntity.created(uri).body(new PostDetailsDTO(newPost));
    }

    @PutMapping
    @Transactional
    public ResponseEntity editContent(@RequestBody @Valid UpdatedContentDTO newContentDto){
        var post = postService.getPostById(newContentDto.contentId());
        post.updateContent(newContentDto.newContent());
        return ResponseEntity.ok(new PostDetailsDTO(post));
    }

    @GetMapping("/{id}/react")
    @Transactional
    public ResponseEntity reactToContent(@PathVariable Long id){
        var post = postService.getPostById(id);
        post.addReaction();
        return ResponseEntity.ok(new PostDetailsDTO(post));
    }
}
