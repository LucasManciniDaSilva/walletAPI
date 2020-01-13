package com.wallet.interfaces.controller;

import com.wallet.dto.UserWalletDTO;
import com.wallet.entity.UserWallet;
import com.wallet.response.Response;
import com.wallet.service.UserWalletService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("userWallet")
public class UserWalletController {


  @Autowired
  private UserWalletService service;

  @PostMapping
  public ResponseEntity<Response<UserWalletDTO>> create(@Valid @RequestBody UserWalletDTO dto, BindingResult result) {

    Response<UserWalletDTO> response = new Response<UserWalletDTO>();


    if (result.hasErrors()) {
      result.getAllErrors().forEach(e -> response.getErros().add(e.getDefaultMessage()));
      return ResponseEntity.badRequest().body(response);
    }

    UserWallet uw = service.save(service.convertEntityToDto(dto));

    response.setData(service.convertDtoToEntity(uw));

    return ResponseEntity.status(HttpStatus.CREATED).body(response);
  }
}
