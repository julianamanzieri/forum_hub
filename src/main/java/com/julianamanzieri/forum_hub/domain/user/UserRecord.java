package com.julianamanzieri.forum_hub.domain.user;

public record UserRecord(Long id, String name, String password, String email) {
    public UserRecord(User user) {
        this(user.getId(), user.getName(), user.getPassword(), user.getEmail());
    }
}
