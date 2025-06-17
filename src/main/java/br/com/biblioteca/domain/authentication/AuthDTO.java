package br.com.biblioteca.domain.authentication;

public record AuthDTO(
        String token,
        String message
) {
}