package io.github.leonardogendo.auth_starter.auth.controller;

import io.github.leonardogendo.auth_starter.auth.dto.LoginRequest;
import io.github.leonardogendo.auth_starter.auth.dto.LoginResponse;
import io.github.leonardogendo.auth_starter.auth.service.AuthService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor 
public class AuthController {

    private final AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(
            @Valid @RequestBody LoginRequest request
    ) {

        return ResponseEntity.ok(
                authService.login(request)
        );
    }
}

