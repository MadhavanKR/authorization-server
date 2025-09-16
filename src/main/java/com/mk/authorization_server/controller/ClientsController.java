package com.mk.authorization_server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.core.AuthorizationGrantType;
import org.springframework.security.oauth2.core.ClientAuthenticationMethod;
import org.springframework.security.oauth2.server.authorization.client.RegisteredClient;
import org.springframework.security.oauth2.server.authorization.client.RegisteredClientRepository;
import org.springframework.security.oauth2.server.authorization.settings.ClientSettings;
import org.springframework.security.oauth2.server.authorization.settings.TokenSettings;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Duration;
import java.util.Collections;
import java.util.Map;
import java.util.UUID;

@RestController
public class ClientsController {

    @Autowired
    RegisteredClientRepository registeredClientRepository;

    @GetMapping(path = "/admin/clients")
    public Map<String, String> createClient() {
        RegisteredClient registeredClient = RegisteredClient.withId(String.valueOf(UUID.randomUUID()))
                .clientId("blinkai-client")
                .clientSecret("blink-ai-client-secret")
                .clientAuthenticationMethod(ClientAuthenticationMethod.CLIENT_SECRET_BASIC)
                .authorizationGrantType(AuthorizationGrantType.AUTHORIZATION_CODE)
                .authorizationGrantType(AuthorizationGrantType.REFRESH_TOKEN)
                .redirectUri("http://localhost:4200/callback")
                .scope("openid")
                .scope("blinkai")
                .tokenSettings(
                        TokenSettings.builder()
                                .accessTokenTimeToLive(Duration.ofHours(6))
                                .build()
                )
                .clientSettings(
                        ClientSettings.builder()
                                .requireProofKey(false)
                                .build()
                )
                .build();
        registeredClientRepository.save(registeredClient);
        return Collections.emptyMap();
    }

}
