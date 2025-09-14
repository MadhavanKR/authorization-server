insert into oauth2_registered_client (
    id,
    client_id,
    client_id_issued_at,
    client_secret,
    client_name,
    client_authentication_methods,
    authorization_grant_types,
    redirect_uris,
    scopes,
    client_settings,
    token_settings
) values (
             'admin', -- Postgres function from pgcrypto extension, or replace with a static UUID
             'admin',
             now(),
             '{bcrypt}$2a$12$e842Eb4WnZTUGG/VJOum1u8l271/R8N0IDZE42Am8u5kYmm1XnO6u', -- bcrypt hash of secret
             'Admin API client',
             'client_secret_basic',
             'client_credentials',
             '',
             '["clients.read","clients.write","users.read","users.write"]',
             '{"@class":"java.util.LinkedHashMap","requireProofKey":false,"requireAuthorizationConsent":false}',
             '{"@class":"java.util.LinkedHashMap","accessTokenTimeToLive":"PT5M","reuseRefreshTokens":true,"idTokenSignatureAlgorithm":"RS256"}'
         );
