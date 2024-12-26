package com.julianamanzieri.forum_hub.domain.topic;

import java.time.LocalDateTime;

public record DataListTopic(Long id, String title, String message, String nameAuthor, LocalDateTime dateCreation, Status status) {
    public DataListTopic(Topic topic) {
        this(topic.getId(), topic.getTitle(), topic.getMessage(), topic.getAuthor().getName(), topic.getDateCreation(), topic.getStatus());
    }
}
