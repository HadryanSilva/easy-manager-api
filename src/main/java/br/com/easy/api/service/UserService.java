package br.com.easy.api.service;

import br.com.easy.api.exception.NotFoundException;
import br.com.easy.api.mapper.UserMapper;
import br.com.easy.api.mapper.request.UserPostRequest;
import br.com.easy.api.mapper.request.UserPutRequest;
import br.com.easy.api.mapper.response.UserGetResponse;
import br.com.easy.api.mapper.response.UserPostResponse;
import br.com.easy.api.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Log4j2
@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;

    private final UserMapper userMapper;

    private final PasswordEncoder passwordEncoder;

    public List<UserGetResponse> findAll(Pageable pageable) {
        log.info("Listing all users");
        return userRepository.findAll(pageable)
                .map(userMapper::userToGetResponse)
                .stream()
                .toList();
    }

    public UserGetResponse findById(Long id) {
        log.info("Finding user by id: {}", id);
        return userRepository.findById(id)
                .map(userMapper::userToGetResponse)
                .orElseThrow(() -> new NotFoundException("User not found"));
    }

    public UserGetResponse findByUsername(String username) {
        log.info("Finding user by username: {}", username);
        return userRepository.findByUsername(username)
                .map(userMapper::userToGetResponse)
                .orElseThrow(() -> new NotFoundException("User not found"));
    }

    public UserPostResponse save(UserPostRequest request) {
        log.info("Saving user: {}", request.getUsername());
        var userToSave = userMapper.postToUser(request);
        userToSave.setPassword(passwordEncoder.encode(request.getPassword()));
        var userSaved = userRepository.save(userToSave);

        return userMapper.userToPostResponse(userSaved);
    }

    public void delete(Long id, UserPutRequest request) {
        log.info("Deleting user: {}", request.getUsername());
        var userFound = userRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("User not found"));
        userRepository.delete(userFound);
    }

}
