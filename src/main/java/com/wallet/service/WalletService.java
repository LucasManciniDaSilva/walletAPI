package com.wallet.service;

import com.wallet.dto.UserDTO;
import com.wallet.dto.WalletDTO;
import com.wallet.entity.Users;
import com.wallet.entity.Wallet;

public interface WalletService {

    Wallet save(Wallet w);

    Wallet convertEntityToDto(WalletDTO dto);

    WalletDTO convertDtoToEntity(Wallet w);
}
