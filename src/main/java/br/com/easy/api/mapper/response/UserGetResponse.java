package br.com.easy.api.mapper.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserGetResponse {

    private Long id;

    private String username;

    private String email;

}
