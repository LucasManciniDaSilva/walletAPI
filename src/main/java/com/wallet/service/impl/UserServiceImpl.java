package com.wallet.service.impl;

import com.wallet.dto.UserDTO;
import com.wallet.entity.Users;
import com.wallet.repository.UserRepository;
import com.wallet.service.UserService;
import com.wallet.util.Bcrypt;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

  @Autowired UserRepository repository;

  @Override
  public Users save(Users u) {

    return repository.save(u);
  }

  @Override
  public Optional<Users> findByEmail(String email) {
    return repository.findByEmailEquals(email);
  }

  @Override
  public Users convertEntityToDto(UserDTO dto) {
    Users u = new Users();
    u.setEmail(dto.getEmail());
    u.setName(dto.getName());
    u.setPassword(Bcrypt.getHash(dto.getPassword()));

    return u;
  }

  @Override
  public UserDTO convertDtoToEntity(Users u) {
    UserDTO dto = new UserDTO();
    dto.setId(u.getId());
    dto.setEmail(u.getEmail());
    dto.setName(u.getName());

    return dto;
  }
}
