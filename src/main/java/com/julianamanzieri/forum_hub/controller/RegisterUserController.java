package com.julianamanzieri.forum_hub.controller;

import com.julianamanzieri.forum_hub.domain.user.DataAuthentication;
import com.julianamanzieri.forum_hub.domain.user.DataRegistration;
import com.julianamanzieri.forum_hub.domain.user.User;
import com.julianamanzieri.forum_hub.domain.user.UserService;
import jakarta.validation.Valid;
import jakarta.validation.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/register")
public class RegisterUserController {

    @Autowired
    private UserService service;

    @PostMapping
    public ResponseEntity registerNewUser(@RequestBody @Valid DataAuthentication data) {
        try {
            User newUser = service.createNewUser(data);
            return ResponseEntity.status(HttpStatus.CREATED).body(new DataRegistration(newUser));
        } catch (ValidationException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
