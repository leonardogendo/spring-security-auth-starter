package io.github.leonardogendo.auth_starter.auth.dto;

public record LoginRequest(
    String email,
    String password
) {
}
