package com.wallet.service;

import com.wallet.entity.WalletItem;
import com.wallet.interfaces.enums.TypeEnum;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import org.springframework.data.domain.Page;

public interface WalletItemService {

  WalletItem save(WalletItem i);

  Page<WalletItem> findBetweenDates(UUID wallet, Date start, Date end, int page);

  List<WalletItem> findByWalletAndType(UUID wallet, TypeEnum type);

  BigDecimal sumByWalletId(UUID wallet);

}
