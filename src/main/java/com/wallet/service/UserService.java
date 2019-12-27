package com.wallet.service;

import com.wallet.dto.UserDTO;
import com.wallet.entity.Users;

import java.util.Optional;

public interface UserService {

    Users save(Users u);

    Optional<Users> findByEmail(String email);

    Users convertEntityToDto(UserDTO dto);

    UserDTO convertDtoToEntity(Users u);


}
