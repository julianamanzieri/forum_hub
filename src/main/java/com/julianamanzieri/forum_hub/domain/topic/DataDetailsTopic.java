package com.julianamanzieri.forum_hub.domain.topic;

import java.time.LocalDateTime;

public record DataDetailsTopic(Long id, String title, String message, LocalDateTime dateCreation) {
    public DataDetailsTopic(Topic topic) {
        this(topic.getId(), topic.getTitle(), topic.getMessage(), topic.getCreationDate());
    }
}
