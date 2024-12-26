package com.julianamanzieri.forum_hub.domain.user;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;

public record UserDTO(
        @NotBlank
        @Valid
        String name,

        @NotBlank
        @Valid
        String email,

        @NotBlank
        @Valid
        String password
) {
}
