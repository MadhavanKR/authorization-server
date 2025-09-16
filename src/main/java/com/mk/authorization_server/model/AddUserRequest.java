package com.mk.authorization_server.model;

import org.springframework.web.bind.annotation.RequestBody;

public class AddUserRequest {
    private String username;
    private String password;
    private String email;

    public AddUserRequest() {}

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }
}
