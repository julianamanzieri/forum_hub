package com.julianamanzieri.forum_hub.domain.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record DataAuthentication(
        @NotBlank
        @Email
        String email,

        @NotBlank
        String password
) {
}
