package com.wallet.service;

import com.wallet.dto.UserDTO;
import com.wallet.entity.Users;

import java.util.Optional;
import org.apache.catalina.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.util.UriComponentsBuilder;

public interface UserService {

    ResponseEntity postUser(Users users, UriComponentsBuilder uri);

    Optional<Users> findByEmail(String email);



}
