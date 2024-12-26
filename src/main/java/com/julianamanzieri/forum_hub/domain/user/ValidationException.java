package com.julianamanzieri.forum_hub.domain.user;

public class ValidationException extends RuntimeException {
    public ValidationException(String message) {
        super(message);
    }
}
