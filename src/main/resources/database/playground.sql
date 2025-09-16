select * from oauth2_registered_client;

update oauth2_registered_client set client_secret='$2a$12$e842Eb4WnZTUGG/VJOum1u8l271/R8N0IDZE42Am8u5kYmm1XnO6u' where client_id='admin';

update oauth2_registered_client
set redirect_uris='http://localhost:4200/callback', scopes='blinkai,openid',
    client_settings='{"@class":"java.util.Collections$UnmodifiableMap","settings.client.require-proof-key":false,"settings.client.require-authorization-consent":false}',
    token_settings='{"@class":"java.util.Collections$UnmodifiableMap","settings.token.reuse-refresh-tokens":true,"settings.token.x509-certificate-bound-access-tokens":false,"settings.token.id-token-signature-algorithm":["org.springframework.security.oauth2.jose.jws.SignatureAlgorithm","RS256"],"settings.token.access-token-time-to-live":["java.time.Duration",300.000000000],"settings.token.access-token-format":{"@class":"org.springframework.security.oauth2.server.authorization.settings.OAuth2TokenFormat","value":"self-contained"},"settings.token.refresh-token-time-to-live":["java.time.Duration",3600.000000000],"settings.token.authorization-code-time-to-live":["java.time.Duration",300.000000000],"settings.token.device-code-time-to-live":["java.time.Duration",300.000000000]}'
where client_id='blinkai-client';

update oauth2_registered_client
set client_authentication_methods='none'
where client_id='blinkai-client';


delete from oauth2_registered_client where client_id='blinkai-client';