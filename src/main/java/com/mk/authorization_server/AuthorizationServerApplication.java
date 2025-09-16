package com.mk.authorization_server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.oauth2.server.authorization.settings.ClientSettings;

@SpringBootApplication
public class AuthorizationServerApplication {

	public static void main(String[] args) {
        System.out.println(ClientSettings.builder()
                .requireProofKey(false)
                .build().toString());
        SpringApplication.run(AuthorizationServerApplication.class, args);
	}

}
