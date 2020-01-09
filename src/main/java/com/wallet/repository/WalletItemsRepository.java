package com.wallet.repository;

import com.wallet.entity.Wallet;
import com.wallet.entity.WalletItem;
import com.wallet.interfaces.enums.TypeEnum;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;


@NoRepositoryBean
public interface WalletItemsRepository extends JpaRepository<WalletItem, UUID> {

  Page<WalletItem> findByWalletIdDate(UUID wallet, Date init, Date end, Pageable page);

  List<WalletItem> findByWalletIdAndType(UUID wallet, TypeEnum type);
}
