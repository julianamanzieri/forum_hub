package com.julianamanzieri.forum_hub.domain.course;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CourseDTO(

        @NotBlank
        String name,

        @NotNull
        @Valid
        Category category
) {
}
