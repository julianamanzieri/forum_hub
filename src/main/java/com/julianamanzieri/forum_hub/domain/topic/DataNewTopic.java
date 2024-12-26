package com.julianamanzieri.forum_hub.domain.topic;

import jakarta.validation.constraints.NotBlank;

public record DataNewTopic(
        @NotBlank(message = "")
        String title,

        @NotBlank (message = "")
        String message,

        @NotBlank
        String course
) {
}
