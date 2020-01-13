package com.wallet.repository;

import com.wallet.entity.Wallet;
import com.wallet.entity.WalletItem;
import com.wallet.interfaces.enums.TypeEnum;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.query.Param;


@NoRepositoryBean
public interface WalletItemsRepository extends JpaRepository<WalletItem, UUID> {

  Page<WalletItem> findByWalletIdDate(UUID wallet, Date init, Date end, Pageable page);

  List<WalletItem> findByWalletIdAndType(UUID wallet, TypeEnum type);

  @Query(value = "select sum(value) from wallet_items wi where wi.wallet.id = :wallet")
  BigDecimal sumByWalletId(@Param("wallet") UUID wallet);
}
