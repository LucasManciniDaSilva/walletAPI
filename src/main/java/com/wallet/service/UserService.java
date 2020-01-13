package com.wallet.service;

import com.wallet.dto.UserDTO;
import com.wallet.dto.UserDTOResponse;
import com.wallet.entity.Users;

import java.util.Optional;
import org.springframework.web.util.UriComponentsBuilder;

public interface UserService {

    Users save(Users u);

    Optional<Users> findByEmail(String email);

    Users postUsers(UserDTO dto, UriComponentsBuilder uri);

    UserDTOResponse postUserService(UserDTO dto, UriComponentsBuilder uri);

}
