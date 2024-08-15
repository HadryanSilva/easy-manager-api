package br.com.easy.api.controller;

import br.com.easy.api.mapper.UserMapper;
import br.com.easy.api.mapper.response.UserGetResponse;
import br.com.easy.api.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    private final UserService userService;

    @GetMapping
    public ResponseEntity<List<UserGetResponse>> findAll(@RequestParam("page") int page,
                                                         @RequestParam("size") int size) {
        return ResponseEntity.ok(userService.findAll(PageRequest.of(page, size)));
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserGetResponse> findById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(userService.findById(id));
    }

}
