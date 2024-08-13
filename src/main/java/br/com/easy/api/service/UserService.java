package br.com.easy.api.service;

import br.com.easy.api.mapper.UserMapper;
import br.com.easy.api.mapper.request.UserPostRequest;
import br.com.easy.api.mapper.response.UserPostResponse;
import br.com.easy.api.model.User;
import br.com.easy.api.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Log4j2
@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;

    private final UserMapper userMapper;

    public UserPostResponse save(UserPostRequest request) {
        log.info("Saving user: {}", request.getUsername());
        var userToSave = userMapper.postToUser(request);
        var userSaved = userRepository.save(userToSave);

        return userMapper.userToPostResponse(userSaved);
    }

}
