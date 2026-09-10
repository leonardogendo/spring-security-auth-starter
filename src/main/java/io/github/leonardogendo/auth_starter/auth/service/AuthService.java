package io.github.leonardogendo.auth_starter.auth.service;

import io.github.leonardogendo.auth_starter.auth.dto.LoginRequest;
import io.github.leonardogendo.auth_starter.auth.dto.LoginResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class AuthService {

    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

    public LoginResponse login(LoginRequest request) {

        Authentication authentication =
                authenticationManager.authenticate(
                        new UsernamePasswordAuthenticationToken(
                                request.email(),
                                request.password()
                        )
                );

        String accessToken = jwtService.generateAccessToken(authentication);

        return new LoginResponse(accessToken);
    }
}
