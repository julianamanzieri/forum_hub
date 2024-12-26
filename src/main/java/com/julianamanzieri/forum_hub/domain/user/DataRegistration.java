package com.julianamanzieri.forum_hub.domain.user;

public record DataRegistration(String email) {
    public DataRegistration(User user) {
        this(user.getEmail());
    }
}
