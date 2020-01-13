package com.wallet.service.impl;

import com.google.common.collect.Lists;
import com.wallet.dto.UserDTO;
import com.wallet.dto.UserDTOResponse;
import com.wallet.dto.converter.UserConverter;
import com.wallet.entity.Users;
<<<<<<< HEAD
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
=======
import com.wallet.interfaces.converters.UserConverter;
import com.wallet.repository.UserRepository;
import com.wallet.service.UserService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;
>>>>>>> 57702a3ec372b62c56e5297ec04a33ce63f4191c
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class UserServiceImpl implements UserService {

<<<<<<< HEAD
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
=======
  private final UserConverter userConverter;
>>>>>>> 57702a3ec372b62c56e5297ec04a33ce63f4191c



  @Autowired
  UserRepository repository;

  public UserServiceImpl(UserConverter userConverter) {
    this.userConverter = userConverter;
  }


  @Override
<<<<<<< HEAD
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
=======
  public UserDTO postUser(Users users, UriComponentsBuilder uri) {

    UserDTO dto = new UserDTO();

   userConverter.toDomain(dto);

    repository.save(users);

    return UserDTO.builder()
>>>>>>> 57702a3ec372b62c56e5297ec04a33ce63f4191c
  }


  @Override
<<<<<<< HEAD
  public UserDTOResponse postUserService(UserDTO dto, UriComponentsBuilder uri){

    final Users users = postUsers(dto, uri);

    return UserDTOResponse.builder()
        .id(users.getId())
        .email(users.getEmail())
        .name(users.getName())
        .build();


  }


=======
  public Optional<Users> findByEmail(String email) {
    return repository.findByEmailEquals(email);
  }

>>>>>>> 57702a3ec372b62c56e5297ec04a33ce63f4191c
}
