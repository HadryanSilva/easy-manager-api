package br.com.easy.api.service.auth;

import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.jwt.*;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Objects;
import java.util.stream.Collectors;

@Log4j2
@RequiredArgsConstructor
@Service
public class JwtService {

    private final JwtEncoder encoder;

    private final JwtDecoder decoder;

    public String generateToken(Authentication authentication) {
       log.info("Generating token for user: {}", authentication.getName());
       var now = Instant.now();
       var expiration = now.plusSeconds(360);

       String scopes = authentication.getAuthorities().stream()
               .map(GrantedAuthority::getAuthority)
               .collect(Collectors.joining(""));


       var claims = JwtClaimsSet.builder()
               .issuer("nord-crm-api")
               .subject(authentication.getName())
               .issuedAt(now)
               .expiresAt(expiration)
               .claim("scope", scopes)
               .build();

       return encoder.encode(JwtEncoderParameters.from(claims)).getTokenValue();
    }

    public boolean validateToken(String token) {
        try {
            var tokenDecoded = decoder.decode(token);
            return true;
        } catch (JwtException e) {
            return false;
        }
    }

    public String getUsernameFromToken(String token) {
        Jwt jwt = decoder.decode(token);
        return jwt.getSubject();
    }

}
