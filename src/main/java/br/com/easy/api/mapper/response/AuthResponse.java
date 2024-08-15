package br.com.easy.api.mapper.response;

public record AuthResponse(String token, UserGetResponse user) {
}
