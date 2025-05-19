package com.algaworks.algacomments.moderationservice.api.model;

import com.algaworks.algacomments.moderationservice.domain.model.CommentId;
import lombok.Data;

@Data
public class ModerationInput {
    private String text;
    private CommentId commentId;
}
