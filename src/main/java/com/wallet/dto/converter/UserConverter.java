package com.wallet.dto.converter;

import com.wallet.dto.UserDTO;
import com.wallet.dto.UserDTOResponse;
import com.wallet.entity.Users;
import com.wallet.util.Bcrypt;
import com.wallet.interfaces.validators.UserValidator;
import org.springframework.stereotype.Component;

@Component
public class UserConverter {

  private final UserValidator userValidator;

  public UserConverter(UserValidator userValidator) {
    this.userValidator = userValidator;
  }

  public Users toUserDomain(UserDTO dto) {

    if (dto == null) {
      return null;
    }
    this.userValidator.validateValues(dto);

    Users users = new Users();

    if (dto.getName() != null) {
      users.setName(dto.getName());
    }

    if (dto.getEmail() != null) {
      users.setEmail(dto.getEmail());
    }

    if (dto.getPassword() != null) {
      users.setPassword(Bcrypt.getHash(dto.getPassword()));
    }

    return users;

  }

  public UserDTOResponse toUser(Users users) {
    if (users == null) {
      return null;
    }

    UserDTOResponse response = UserDTOResponse.builder().build();

    response.setId(users.getId());
    response.setName(users.getName());
    response.setEmail(users.getEmail());

    return response;


  }

}
