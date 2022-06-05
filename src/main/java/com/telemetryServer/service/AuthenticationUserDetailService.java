package com.telemetryServer.service;

import com.telemetryServer.model.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;

@Component
public class AuthenticationUserDetailService extends ServiceImpl implements UserDetailsService {

    @Override public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        // Get the user by username
        User apiUser = userRepository.findByUsername(username);

        // Verify the user exists
        if (apiUser == null) {
            throw new UsernameNotFoundException(username);
        }


        // Return user
        return new org.springframework.security.core.userdetails.User(apiUser.getUsername(),
                apiUser.getPassword(), getAuthorities(apiUser.getRole()));

    }

    private Collection<? extends GrantedAuthority> getAuthorities(String role) {
        return List.of(new SimpleGrantedAuthority(role));
    }
}
