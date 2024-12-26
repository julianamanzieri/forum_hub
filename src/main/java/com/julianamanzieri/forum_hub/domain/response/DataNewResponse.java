package com.julianamanzieri.forum_hub.domain.response;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DataNewResponse(
        @NotBlank
        String message,

        @NotNull
        @Valid
        Long topic
) {
}
