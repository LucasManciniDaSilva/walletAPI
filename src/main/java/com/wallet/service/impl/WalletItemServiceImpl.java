package com.wallet.service.impl;

import com.wallet.entity.WalletItem;
import com.wallet.interfaces.enums.TypeEnum;
import com.wallet.repository.WalletItemsRepository;
import com.wallet.service.WalletItemService;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

public class WalletItemServiceImpl implements WalletItemService {

  @Autowired
  WalletItemsRepository repository;

  @Value("${pagination.items_per_page}")
  private int ItemsPerPage;

  @Override
  public WalletItem save(WalletItem i){
    return repository.save(i);
  }

  @Override
  public Page<WalletItem> findBetweenDates(UUID wallet, Date start, Date end, int page){
    @SuppressWarnings("deprecation")
    PageRequest pg = new PageRequest(page, ItemsPerPage);

    return repository.findByWalletIdDate(wallet, start, end, pg);
  }

  @Override
  public List<WalletItem> findByWalletAndType(UUID wallet, TypeEnum type) {
    return repository.findByWalletIdAndType(wallet, type);
  }

  @Override
  public BigDecimal sumByWalletId(UUID wallet) {
    return repository.sumByWalletId(wallet);
  }

}
