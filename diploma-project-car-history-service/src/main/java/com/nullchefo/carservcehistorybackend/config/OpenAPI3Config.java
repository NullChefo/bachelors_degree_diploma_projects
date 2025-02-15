package com.nullchefo.carservcehistorybackend.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.annotations.servers.Server;

@OpenAPIDefinition(servers = {
		@Server(url = "https://backend.nullchefo.com/car-history"), @Server(url = "http://localhost:8000/car-history"),
		@Server(url = "http://localhost:8085") }, info = @Info(title = "Car History Service APIs", version = "v0.0.1", description = "Car History Service API", contact = @Contact(url = "https://nullchefo.com", name = "Stefan", email = "stefank.dev.acc@gmail.com")))
/*
@SecurityScheme(name = "OAuth2", type = SecuritySchemeType.OAUTH2,
				flows = @OAuthFlows(authorizationCode = @OAuthFlow(
						authorizationUrl = "http://localhost:9000",
						tokenUrl = "http://localhost:9000/oauth/token",
						scopes = {
								@OAuthScope(name = "openid", description = "Read Access"),
								@OAuthScope(name = "read", description = "Read Access"),
								@OAuthScope(name = "write", description = "Write Access")
						})))

@SecurityScheme(
		name = "security_auth",
		type = SecuritySchemeType.OAUTH2,
				in = SecuritySchemeIn.HEADER,
				bearerFormat = "jwt",
		flows = @OAuthFlows(
				authorizationCode = @OAuthFlow(
						authorizationUrl = "https://auth.nullchefo.com/oauth2/authorize",
						tokenUrl = "https://auth.nullchefo.com/oauth2/token",
						scopes = {
								@OAuthScope(name = "openid", description = "openid scope"),
								@OAuthScope(name = "car_history.read", description = "with this scope, the user can access every get request"),
								@OAuthScope(name = "car_history.write", description = "with this scope, the user can access every post, put and delete request")
						}
				)
		)
)

 */
@SecurityScheme(
		name = "Bearer Authentication",
		type = SecuritySchemeType.HTTP,
		bearerFormat = "JWT",
		scheme = "bearer"
)
public class OpenAPI3Config {
}
