package com.mk.authorization_server.controller;

import com.mk.authorization_server.model.AddUserRequest;
import com.mk.authorization_server.model.UserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.web.bind.annotation.*;

import javax.sql.DataSource;
import java.util.Collections;
import java.util.stream.Collectors;

@RestController
public class UserDetailsController {

    private final UserDetailsManager userDetailsManager;
    private final PasswordEncoder passwordEncoder;

    public UserDetailsController(final DataSource dataSource, final PasswordEncoder passwordEncoder) {
        this.userDetailsManager = new JdbcUserDetailsManager(dataSource);
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping(path = "/admin/users")
    public UserResponse getUser(@RequestParam(required = true) String username) {
        try {
            UserDetails userDetails = userDetailsManager.loadUserByUsername(username);
            return new UserResponse(userDetails.getUsername(), userDetails.getAuthorities().stream().map(GrantedAuthority::getAuthority).collect(Collectors.toSet()));
        } catch (UsernameNotFoundException e) {
            return new UserResponse("unknown-user", Collections.emptySet());
        }
    }

    @PostMapping(path = "/admin/adduser")
    public UserResponse addUser(@RequestBody AddUserRequest addUserRequest) {
        try {
            userDetailsManager.createUser(User.builder().username(addUserRequest.getUsername()).password(passwordEncoder.encode(addUserRequest.getPassword())).build());
            return new UserResponse(addUserRequest.getUsername(), Collections.emptySet());
        } catch (Exception e) {
            return new UserResponse("unknown-user", Collections.emptySet());
        }
    }
}
