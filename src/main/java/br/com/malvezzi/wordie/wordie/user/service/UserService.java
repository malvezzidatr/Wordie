package br.com.malvezzi.wordie.wordie.user.service;

import br.com.malvezzi.wordie.wordie.user.dto.UserRequest;
import br.com.malvezzi.wordie.wordie.user.model.User;

public interface UserService {
  void createUser(UserRequest userRequest);
}
