package com.youshare.postsapi.domain.post.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record UpdatedContentDTO(@NotNull Long contentId, @NotBlank String newContent) {
}
