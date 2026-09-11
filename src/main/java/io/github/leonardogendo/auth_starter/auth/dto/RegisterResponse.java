package io.github.leonardogendo.auth_starter.auth.dto;

import java.util.UUID;

public record RegisterResponse(
    UUID id,
    String email
) {}
