package com.wallet.repository;

import com.wallet.entity.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WalletItemsRepository extends JpaRepository<WalletItems, Long> {

}
