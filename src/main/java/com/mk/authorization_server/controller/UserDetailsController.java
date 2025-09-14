package com.mk.authorization_server.controller;

import com.mk.authorization_server.model.UserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.stream.Collectors;

@RestController
public class UserDetailsController {

    private final UserDetailsService userDetailsService;

    public UserDetailsController(final UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @GetMapping(path = "/admin/users")
    public UserResponse getUser(@RequestParam(required = true) String username) {
        try {
            UserDetails userDetails = userDetailsService.loadUserByUsername(username);
            return new UserResponse(userDetails.getUsername(), userDetails.getAuthorities().stream().map(GrantedAuthority::getAuthority).collect(Collectors.toSet()));
        } catch (UsernameNotFoundException e) {
            return new UserResponse("unknown-user", Collections.emptySet());
        }
    }
}
