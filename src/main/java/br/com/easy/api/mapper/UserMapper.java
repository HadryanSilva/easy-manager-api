package br.com.easy.api.mapper;

import br.com.easy.api.mapper.request.UserPostRequest;
import br.com.easy.api.mapper.response.UserGetResponse;
import br.com.easy.api.mapper.response.UserPostResponse;
import br.com.easy.api.model.User;
import org.mapstruct.Mapper;
import org.springframework.security.core.userdetails.UserDetails;

@Mapper
public interface UserMapper {

    User postToUser(UserPostRequest userPostRequest);

    UserPostResponse userToPostResponse(User user);

    UserGetResponse userToGetResponse(User user);

    UserGetResponse userDetailToGetResponse(UserDetails user);

}
