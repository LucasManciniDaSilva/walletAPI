package com.wallet.interfaces.controller;

import com.wallet.dto.UserDTO;
import com.wallet.dto.UserDTOResponse;
import com.wallet.response.Response;
import com.wallet.service.UserService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

;

@RestController
@RequestMapping("user")
public class UserController {

  @Autowired
  private UserService service;

  @PostMapping
  public ResponseEntity<Response<UserDTO>> create(@Valid @RequestBody UserDTO dto,
      UriComponentsBuilder uri) {

    UserDTOResponse userResponse = service.postUserService(dto, uri);

    return ResponseEntity.created(uri
        .buildAndExpand(userResponse.getId())
        .toUri())
        .build();

  }

}