package com.wallet.repository;

import com.wallet.entity.UserWallet;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserWalletRepository extends JpaRepository<UserWallet, UUID> {

}
