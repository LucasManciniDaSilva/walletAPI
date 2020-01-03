package com.wallet.interfaces.converters;

import com.wallet.dto.UserDTO;
import com.wallet.interfaces.validators.UserValidator;
import com.wallet.util.Bcrypt;
import com.wallet.entity.Users;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

@Component
public class UserConverter{

  private final UserValidator validator;

  public UserConverter(UserValidator validator) {
    this.validator = validator;
  }


  public Users toDomain(UserDTO dto) {
    Users u = new Users();
      u.setEmail(dto.getEmail());
      u.setName(dto.getName());
      u.setPassword(Bcrypt.getHash(dto.getPassword()));
    return u;
  }

  public UserDTO toDTO(Users u) {
    UserDTO dto = new UserDTO();
    this.validator.validateValues(dto);
      dto.setId(u.getId());
      dto.setEmail(u.getEmail());
      dto.setName(u.getName());
    return dto;
  }
}
