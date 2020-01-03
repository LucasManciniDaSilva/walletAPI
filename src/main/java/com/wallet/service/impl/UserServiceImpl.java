package com.wallet.service.impl;

import com.wallet.dto.UserDTO;
import com.wallet.entity.Users;
import com.wallet.interfaces.converters.UserConverter;
import com.wallet.repository.UserRepository;
import com.wallet.service.UserService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class UserServiceImpl implements UserService {

  private final UserConverter userConverter;



  @Autowired
  UserRepository repository;

  public UserServiceImpl(UserConverter userConverter) {
    this.userConverter = userConverter;
  }


  @Override
  public UserDTO postUser(Users users, UriComponentsBuilder uri) {

    UserDTO dto = new UserDTO();

   userConverter.toDomain(dto);

    repository.save(users);

    return UserDTO.builder()
  }

  @Override
  public Optional<Users> findByEmail(String email) {
    return repository.findByEmailEquals(email);
  }

}
