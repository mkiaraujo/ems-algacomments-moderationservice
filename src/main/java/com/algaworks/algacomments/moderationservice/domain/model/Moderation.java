package com.algaworks.algacomments.moderationservice.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Moderation {

    private String text;
    private CommentId id;
    private Boolean approved = Boolean.TRUE;
}
