package com.wallet.service.impl;

import com.google.common.collect.Lists;
import com.wallet.dto.UserDTO;
import com.wallet.dto.UserDTOResponse;
import com.wallet.dto.converter.UserConverter;
import com.wallet.entity.Users;
import com.wallet.exception.MessageError;
import com.wallet.exception.PreconditionFailedException;
import com.wallet.exception.UnprocessableEntityException;
import com.wallet.interfaces.Messages;
import com.wallet.interfaces.validators.UserValidator;
import com.wallet.repository.UserRepository;
import com.wallet.service.UserService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class UserServiceImpl implements UserService {

  private final UserValidator userValidator;
  private final UserConverter userConverter;
  private final MessageError messageError;


  @Autowired
  UserRepository repository;

  public UserServiceImpl(UserValidator userValidator,
      UserConverter userConverter, MessageError messageError,
      MessageError messageError1) {
    this.userValidator = userValidator;
    this.userConverter = userConverter;
    this.messageError = messageError1;
  }

  @Override
  public Users save(Users u) {

    return repository.save(u);
  }

  @Override
  public Optional<Users> findByEmail(String email) {
    return repository.findByEmailEquals(email);
  }

  @Override
  public Users postUsers(UserDTO dto, UriComponentsBuilder uri) {

    List<MessageError.ApiError> errors = this.userValidator.validateValues(dto);
    if (errors != null && !errors.isEmpty()) {
      throw new PreconditionFailedException(errors);
    }

    Users users = this.userConverter.toUserDomain(dto);

    final Optional<Users> user = repository.findByEmailEquals(users.getEmail());

    if (user.isPresent()) {
      throw new UnprocessableEntityException(
          Lists.newArrayList(this.messageError.create(Messages.EXIST_EMAIL)));
    }

    return this.repository.save(users);
  }


  @Override
  public UserDTOResponse postUserService(UserDTO dto, UriComponentsBuilder uri){

    final Users users = postUsers(dto, uri);

    return UserDTOResponse.builder()
        .id(users.getId())
        .email(users.getEmail())
        .name(users.getName())
        .build();


  }


}
