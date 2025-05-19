package com.algaworks.algacomments.moderationservice.domain.model;

import io.hypersistence.tsid.TSID;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Objects;

@Getter
@NoArgsConstructor
@EqualsAndHashCode
public class CommentId implements Serializable {

    private TSID value;

    public CommentId(TSID value) {
        Objects.requireNonNull(value);
        this.value = value;
    }

    public CommentId(Long value) {
        Objects.requireNonNull(value);
        this.value = TSID.from(value);
    }

    public CommentId(String value) {
        Objects.requireNonNull(value);
        this.value = TSID.from(value);
    }

    @Override
    public String toString() {
        return this.value.toString();
    }
}
