package com.julianamanzieri.forum_hub.domain.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public User createNewUser(DataAuthentication dataAuthentication) {
        if (userRepository.existsByEmail(dataAuthentication.email())) {
            throw new ValidationException("User with same email found!");
        }

        User user = new User();
        user.setName(dataAuthentication.name());
        user.setEmail(dataAuthentication.email());
        user.setPassword(passwordEncoder.encode(dataAuthentication.password()));

        return userRepository.save(user);
    }

}
