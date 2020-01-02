package com.wallet.service.impl;

import com.wallet.dto.UserDTO;
import com.wallet.dto.UserWalletDTO;
import com.wallet.entity.UserWallet;
import com.wallet.entity.Users;
import com.wallet.entity.Wallet;
import com.wallet.repository.UserWalletRepository;
import com.wallet.service.UserWalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserWalletImpl implements UserWalletService {

  @Autowired UserWalletRepository repository;

  @Override
  public UserWallet save(UserWallet uw) {
    return repository.save(uw);
  }

  @Override
  public UserWallet convertEntityToDto(UserWalletDTO dto) {
    UserWallet uw = new UserWallet();
    Users u = new Users();
    u.setId(dto.getUsers());
    Wallet w = new Wallet();
    w.setId(dto.getWallet());

    uw.setId(dto.getId());
    uw.setUsers(u);
    uw.setWallet(w);

    return uw;
  }

  @Override
  public UserWalletDTO convertDtoToEntity(UserWallet uw) {
    UserWalletDTO dto = new UserWalletDTO();
    dto.setId(uw.getId());
    dto.setUsers(uw.getUsers().getId());
    dto.setWallet(uw.getWallet().getId());

    return dto;
  }
}
