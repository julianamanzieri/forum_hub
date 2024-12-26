package com.julianamanzieri.forum_hub.domain.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public User createNewUser(UserDetails dataAuthentocation) {
        if (userRepository.existsByEmail(dataAuthentocation.email())) {
            throw new ValidationException("User with same email found!");
        }

        User user = new User();
        user.setName(dataAuthentocation.name());
        user.setEmail(dataAuthentocation.email());
        user.setPassword(passwordEncoder.encode(dataAuthentocation.password()));

        return userRepository.save(user);
    }
}
