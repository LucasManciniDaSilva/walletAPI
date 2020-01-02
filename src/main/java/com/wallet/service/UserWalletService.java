package com.wallet.service;

import com.wallet.dto.UserDTO;
import com.wallet.dto.UserWalletDTO;
import com.wallet.entity.UserWallet;

public interface UserWalletService {

  UserWallet save(UserWallet uw);

  UserWallet convertEntityToDto(UserWalletDTO dto);

  UserWalletDTO convertDtoToEntity(UserWallet uw);


}
