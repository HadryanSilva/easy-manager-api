package br.com.easy.api.mapper;

import br.com.easy.api.mapper.request.UserPostRequest;
import br.com.easy.api.mapper.response.UserPostResponse;
import br.com.easy.api.model.User;
import org.mapstruct.Mapper;

@Mapper
public interface UserMapper {

    User postToUser(UserPostRequest userPostRequest);

    UserPostResponse userToPostResponse(User user);

}
