package com.telemetryServer.service;

import com.telemetryServer.model.User;
import com.telemetryServer.model.UserRepository;
import com.telemetryServer.model.UserTransfer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/users")
@Component(value="userService")
public class UserService {

    @Autowired
    protected UserRepository userRepository;

    @Autowired
    protected BCryptPasswordEncoder bCryptPasswordEncoder;

    @PostMapping(value = "register")
    public ResponseEntity<User> register(@RequestBody UserTransfer userTransfer) {

        // Create a new user
        User user = new User();

        // If there is no role in the request body, set the role to USER
        if (userTransfer.getRole() == null || userTransfer.getRole().trim().equals("")) {
            userTransfer.setRole("USER");
        }

        // Verify that the user doesn't already exist
        User userByUsername = this.userRepository.findByUsername(userTransfer.getUsername());

        if (userByUsername != null) {
            throw new RuntimeException("User already registered.  Please use a different username");
        }

        // Save the new user
        user.setUsername(userTransfer.getUsername());
        user.setPassword(this.bCryptPasswordEncoder.encode(userTransfer.getPassword()));
        user.setRole(userTransfer.getRole());

        this.userRepository.save(user);

        // Return an OK response
        return ResponseEntity.ok().build();
    }
}
