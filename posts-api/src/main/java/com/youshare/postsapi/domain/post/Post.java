package com.youshare.postsapi.domain.post;

import com.youshare.postsapi.domain.post.dto.PostContentDTO;
import com.youshare.postsapi.domain.user.User;
import com.youshare.postsapi.domain.user.service.UserService;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@Entity(name = "Post")
@Table(name = "posts")
public class Post {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    private String content;
    private Integer reactions;
    private Integer comments;
    private LocalDateTime postedDateTime;
    private Boolean visible;

    public Post(PostContentDTO postContent, User publisher) {
        this.user = publisher;
        this.content = postContent.content();
        this.reactions = 0;
        this.comments = 0;
        this.postedDateTime = LocalDateTime.now();
        this.visible = true;
    }
}

/* TODO: Include file attachment feature.
*  TODO: Add unique constraint validation in user field.*/