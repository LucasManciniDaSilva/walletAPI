package com.wallet.repository;

import com.wallet.entity.Wallet;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WalletRepository extends JpaRepository<Wallet, UUID> {

}
