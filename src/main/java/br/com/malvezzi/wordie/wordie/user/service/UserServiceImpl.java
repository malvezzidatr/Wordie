package br.com.malvezzi.wordie.wordie.user.service;

import java.util.UUID;

import org.springframework.stereotype.Service;

import br.com.malvezzi.wordie.wordie.user.dto.UserRequest;
import br.com.malvezzi.wordie.wordie.user.model.User;
import br.com.malvezzi.wordie.wordie.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

  private final UserRepository userRepository;

  @Override
  public void createUser(UserRequest userRequest) {
    System.out.println(userRequest);
      User user = User.builder()
              .firebaseUid(userRequest.firebaseUid())
              .name(userRequest.name())
              .email(userRequest.email())
              .build();

      userRepository.save(user);
  }
}
