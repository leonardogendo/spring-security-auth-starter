package io.github.leonardogendo.authstarter.auth.dto;

import java.util.UUID;

public record RegisterResponse(
    UUID id,
    String email
) {}
