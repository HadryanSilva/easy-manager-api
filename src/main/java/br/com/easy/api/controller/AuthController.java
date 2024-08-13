package br.com.easy.api.controller;

import br.com.easy.api.mapper.request.UserPostRequest;
import br.com.easy.api.mapper.response.UserPostResponse;
import br.com.easy.api.service.UserService;
import br.com.easy.api.service.auth.JwtService;
import br.com.easy.api.service.auth.UserDetailsServiceImpl;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RequiredArgsConstructor
@RestController("/api/v1/auth")
public class AuthController {

    private final JwtService jwtService;

    private final UserService userService;

    private final UserDetailsServiceImpl userDetailsService;

    @PostMapping("/login")
    public ResponseEntity<String> authenticate(@NotNull Authentication authentication) {
        return ResponseEntity.ok(jwtService.generateToken(authentication));
    }

    @PostMapping("/register")
    public ResponseEntity<UserPostResponse> save(@RequestBody UserPostRequest request) {
        var response = userService.save(request);
        return ResponseEntity
                .created(URI.create("/api/v1/users/" + response.getId()))
                .body(response);
    }

}
