package com.telemetryServer.config.filter;

public class AuthenticationConfigConstants {
    public static final String SECRET = "TelemetryServerSecret";
    public static final long EXPIRATION_TIME = 604800000; // 7 days
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String HEADER_STRING = "Authorization";
    public static final String SIGN_UP_URL = "/users/register";
}
