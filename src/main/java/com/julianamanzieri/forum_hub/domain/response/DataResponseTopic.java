package com.julianamanzieri.forum_hub.domain.response;

import java.time.LocalDateTime;

public record DataResponseTopic(Long id, String message, String nameAuthor, LocalDateTime dateCreation) {
    public DataResponseTopic(Response response) {
        this(response.getId(), response.getMessage(), response.getAuthor().getName(), response.getCreationDate());
    }
}
