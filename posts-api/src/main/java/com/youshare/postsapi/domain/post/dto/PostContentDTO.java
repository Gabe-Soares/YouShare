package com.youshare.postsapi.domain.post.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record PostContentDTO(@NotNull Long userId, @NotBlank String content) {}
