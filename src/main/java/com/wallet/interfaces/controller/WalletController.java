package com.wallet.interfaces.controller;

import com.wallet.dto.WalletDTO;
import com.wallet.entity.Wallet;
import com.wallet.response.Response;
import com.wallet.service.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("new")
public class WalletController {

  @Autowired private WalletService service;


  @PostMapping
  public ResponseEntity<Response<WalletDTO>> create(
      @Valid @RequestBody WalletDTO dto, BindingResult result) {

    Response<WalletDTO> response = new Response<WalletDTO>();

    if (result.hasErrors()) {
      result.getAllErrors().forEach(r -> response.getErros().add(r.getDefaultMessage()));

      return ResponseEntity.badRequest().body(response);
    }

    Wallet wallet = service.save(service.convertEntityToDto(dto));

    response.setData(service.convertDtoToEntity(wallet));

    return ResponseEntity.status(HttpStatus.CREATED).body(response);
  }
}
