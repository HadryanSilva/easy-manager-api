package br.com.easy.api.mapper.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserPostRequest {

    private String username;

    private String password;

    private String email;

}
