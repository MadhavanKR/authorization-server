package com.mk.authorization_server.model;

import java.util.Set;

public record UserResponse(String username, Set<String> authorities) {
}
