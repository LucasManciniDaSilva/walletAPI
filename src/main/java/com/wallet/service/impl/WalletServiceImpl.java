package com.wallet.service.impl;

import com.wallet.dto.WalletDTO;
import com.wallet.entity.Wallet;
import com.wallet.repository.WalletRepository;
import com.wallet.service.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WalletServiceImpl implements WalletService {

  @Autowired
  private WalletRepository repository;

  @Override
  public Wallet save(Wallet w) {

    return repository.save(w);
  }

  @Override
  public Wallet convertEntityToDto(WalletDTO dto) {
    Wallet w = new Wallet();
    w.setName(dto.getName());
    w.setValue(dto.getValue());
    return w;
  }

  @Override
  public WalletDTO convertDtoToEntity(Wallet w){
    WalletDTO dto = new WalletDTO();
    dto.setId(w.getId());
    dto.setName(w.getName());
    dto.setValue(w.getValue());

    return dto;
  }
}
