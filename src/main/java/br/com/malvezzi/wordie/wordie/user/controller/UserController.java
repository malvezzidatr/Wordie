package br.com.malvezzi.wordie.wordie.user.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.malvezzi.wordie.wordie.user.dto.UserRequest;
import br.com.malvezzi.wordie.wordie.user.service.UserService;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/user")
public class UserController {
  private final UserService userService;

  @PostMapping
  public void createUser(@RequestBody UserRequest request) {
    userService.createUser(request);
  }
}
