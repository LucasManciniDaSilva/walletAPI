package com.wallet.service;

import com.wallet.dto.UserDTO;
import com.wallet.entity.User;

import java.util.Optional;

public interface UserService {

    User save(User u);

    Optional<User> findByEmail(String email);

    User convertDtoToEntity(UserDTO dto);

    UserDTO convertEntityToDto(User u);


}