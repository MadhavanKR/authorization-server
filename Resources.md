## References

Sprint authorization server + Database : https://medium.com/@sudarshan100mote/spring-authorization-server-with-jdbc-08bfd0b8d6df
Springboot + Flyway : https://neon.com/guides/spring-boot-flyway
Springboot resource server: https://www.baeldung.com/spring-security-oauth-resource-server


### Client details for Authorization code grant flow

id: blinkai-client
client_id: blinkai-client
client_id_issued_at:2025-09-16 00:41:42.418487
client_secret:blink-ai-client-secret
client_secret_expires_at: (empty/null) 
client_name: blinkai-client
client_authentication_methods: none (this is literal value "none", one of the client authentication methods)
authorization_grant_types: refresh_token,authorization_code
redirect_uris: http://localhost:4200/callback
post_logout_redirect_uris: (empty/null)
scopes: openid,blinkai
client_settings: {"@class":"java.util.Collections$UnmodifiableMap","settings.client.require-proof-key":false,"settings.client.require-authorization-consent":false}"
token_settings: {"@class":"java.util.Collections$UnmodifiableMap","settings.token.reuse-refresh-tokens":true,"settings.token.x509-certificate-bound-access-tokens":false,"settings.token.id-token-signature-algorithm":["org.springframework.security.oauth2.jose.jws.SignatureAlgorithm","RS256"],"settings.token.access-token-time-to-live":["java.time.Duration",21600.000000000],"settings.token.access-token-format":{"@class":"org.springframework.security.oauth2.server.authorization.settings.OAuth2TokenFormat","value":"self-contained"},"settings.token.refresh-token-time-to-live":["java.time.Duration",3600.000000000],"settings.token.authorization-code-time-to-live":["java.time.Duration",300.000000000],"settings.token.device-code-time-to-live":["java.time.Duration",300.000000000]}
