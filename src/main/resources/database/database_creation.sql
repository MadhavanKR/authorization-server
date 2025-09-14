CREATE USER authorization_server_admin WITH PASSWORD 'authorization_server_admin';
create database authorization_server;
grant all privileges on database "authorization_server" to authorization_server_admin;
ALTER DATABASE "authorization_server" OWNER TO "authorization_server_admin";

insert into