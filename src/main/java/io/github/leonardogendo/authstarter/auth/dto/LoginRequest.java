package io.github.leonardogendo.authstarter.auth.dto;

public record LoginRequest(
    String email,
    String password
) {
}
