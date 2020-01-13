package com.wallet.service;

import com.wallet.dto.UserDTO;
import com.wallet.dto.UserDTOResponse;
import com.wallet.entity.Users;

import java.util.Optional;
<<<<<<< HEAD
=======
import org.apache.catalina.User;
import org.springframework.http.ResponseEntity;
>>>>>>> 57702a3ec372b62c56e5297ec04a33ce63f4191c
import org.springframework.web.util.UriComponentsBuilder;

public interface UserService {

    ResponseEntity postUser(Users users, UriComponentsBuilder uri);

    Optional<Users> findByEmail(String email);

<<<<<<< HEAD
    Users postUsers(UserDTO dto, UriComponentsBuilder uri);
=======
>>>>>>> 57702a3ec372b62c56e5297ec04a33ce63f4191c

    UserDTOResponse postUserService(UserDTO dto, UriComponentsBuilder uri);

}
