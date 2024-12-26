package com.julianamanzieri.forum_hub.domain.user;

public record UserDetails(Long id, String name, String password, String email) {
    public UserDetails(User user) {
        this(user.getId(), user.getName(), user.getPassword(), user.getEmail());
    }
}
