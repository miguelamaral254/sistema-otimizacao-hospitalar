package br.com.biblioteca.infrastructure.conf;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;

@Configuration
public class RoutesConfig {
    public static final String[] PUBLIC_ROUTES = {
            "swagger-ui/index.html",
            "/auth/**",
            "/users/**",
    };
    public static final String[] USER_ROUTES = {
            "/influenza-nordeste/**"
    };
    public static final String[] RESEARCHER = {
            "/influenza-nordeste/**"
    };

    public static final String[] ADMIN_ROUTES = {
            "/influenza-nordeste/**"
    };
    public static final HttpMethod[] PUBLIC_HTTP_METHODS = {
            HttpMethod.GET, HttpMethod.POST
    };
}