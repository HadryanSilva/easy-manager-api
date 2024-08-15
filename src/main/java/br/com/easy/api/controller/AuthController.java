package br.com.easy.api.controller;

import br.com.easy.api.mapper.request.TokenRequest;
import br.com.easy.api.mapper.request.UserPostRequest;
import br.com.easy.api.mapper.response.AuthResponse;
import br.com.easy.api.mapper.response.RefreshTokenResponse;
import br.com.easy.api.mapper.response.UserPostResponse;
import br.com.easy.api.service.UserService;
import br.com.easy.api.service.auth.JwtService;
import br.com.easy.api.service.auth.UserDetailsServiceImpl;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {

    private final JwtService jwtService;

    private final UserService userService;

    private final UserDetailsServiceImpl userDetailsService;

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> authenticate(@NotNull Authentication authentication) {
        var token = jwtService.generateToken(authentication);
        var user = userService.findByUsername(authentication.getName());
        return ResponseEntity.ok(new AuthResponse(token, user));
    }

    @PostMapping("/register")
    public ResponseEntity<UserPostResponse> save(@RequestBody UserPostRequest request) {
        var response = userService.save(request);
        return ResponseEntity
                .created(URI.create("/api/v1/users/" + response.getId()))
                .body(response);
    }

    @PostMapping("/refresh")
    public ResponseEntity<?> refreshToken(@RequestBody TokenRequest request) {
        if (jwtService.validateToken(request.token())) {
            String username = jwtService.getUsernameFromToken(request.token());
            UserDetails userDetails = userDetailsService.loadUserByUsername(username);
            UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails,
                    null, userDetails.getAuthorities());

            String newAccessToken = jwtService.generateToken(authentication);
            return ResponseEntity.ok(new RefreshTokenResponse(newAccessToken));
        }

        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid refresh token");
    }

}
