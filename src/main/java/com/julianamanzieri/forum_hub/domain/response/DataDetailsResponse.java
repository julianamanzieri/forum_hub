package com.julianamanzieri.forum_hub.domain.response;

import java.time.LocalDateTime;

public record DataDetailsResponse(Long id, String message, LocalDateTime dateCreation) {

    public DataDetailsResponse(Response response) {
        this(response.getId(), response.getMessage(), response.getCreationDate());
    }
}
