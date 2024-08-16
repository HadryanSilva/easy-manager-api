package br.com.easy.api.mapper;

import br.com.easy.api.mapper.request.UserPostRequest;
import br.com.easy.api.mapper.request.UserPutRequest;
import br.com.easy.api.mapper.response.UserGetResponse;
import br.com.easy.api.mapper.response.UserPostResponse;
import br.com.easy.api.model.User;
import org.mapstruct.Mapper;
import org.springframework.security.core.userdetails.UserDetails;

@Mapper(componentModel = "spring")
public interface UserMapper {

    User postToUser(UserPostRequest userPostRequest);

    User putToUser(UserPutRequest userPutRequest);

    UserPostResponse userToPostResponse(User user);

    UserGetResponse userToGetResponse(User user);

    UserGetResponse userDetailToGetResponse(UserDetails user);

}
