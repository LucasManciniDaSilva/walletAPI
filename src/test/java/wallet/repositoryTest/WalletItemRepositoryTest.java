package wallet.repositoryTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import com.wallet.WalletApplication;
import com.wallet.entity.Wallet;
import com.wallet.entity.WalletItem;
import com.wallet.repository.WalletItemsRepository;
import com.wallet.repository.WalletRepository;
import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = WalletApplication.class)
@ContextConfiguration(classes = WalletApplication.class)
@ActiveProfiles("test")
public class WalletItemRepositoryTest {

  private static final UUID ID = UUID.fromString("a761f3ec-6371-4e76-9e8f-1deafefe15d4");
  private static final Date DATE = new Date();
  private static final String TYPE = "EN";
  private static final String DESCRIPTION = "Conta de luz";
  private static final BigDecimal VALUE = BigDecimal.valueOf(65);

  @Autowired
  WalletItemsRepository repository;

  @Autowired
  WalletRepository walletRepository;


  @Test
  public void testSave(){
    Wallet w = new Wallet();
    w.setName("Test");
    w.setValue(BigDecimal.valueOf(500));
    walletRepository.save(w);



    WalletItem wi;
    wi = new WalletItem(ID, w, DATE, TYPE, DESCRIPTION, VALUE);

    WalletItem response = repository.save(wi);

    assertNotNull(response);
    assertEquals(response.getDescription(), DESCRIPTION);
    assertEquals(response.getType(), TYPE);
    assertEquals(response.getValue(), VALUE);
    assertEquals(response.getWallet().getId(), w.getId());
  }



}
