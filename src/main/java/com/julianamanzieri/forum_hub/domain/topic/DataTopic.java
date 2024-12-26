package com.julianamanzieri.forum_hub.domain.topic;

import com.julianamanzieri.forum_hub.domain.response.DataResponseTopic;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public record DataTopic (Long id, String title,
                         String message,
                         LocalDateTime dateCreation,
                         String nameAuthor,
                         Status status,
                         List<DataResponseTopic> responses) {

    public DataTopic(Topic topic){
        this(topic.getId(), topic.getTitle(), topic.getMessage(), topic.getCreationDate(), topic.getAuthor().getName(), topic.getStatus(),
                topic.getResponses()
                        .stream()
                        .map(DataResponseTopic::new).collect(Collectors.toList()));
    }

}
