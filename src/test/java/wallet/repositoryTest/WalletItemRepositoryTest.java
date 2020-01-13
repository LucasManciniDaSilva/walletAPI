package wallet.repositoryTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import com.wallet.WalletApplication;
import com.wallet.entity.Wallet;
import com.wallet.entity.WalletItem;
import com.wallet.interfaces.enums.TypeEnum;
import com.wallet.repository.WalletItemsRepository;
import com.wallet.repository.WalletRepository;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.TransactionSystemException;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = WalletApplication.class)
@ContextConfiguration(classes = WalletApplication.class)
@ActiveProfiles("test")
public class WalletItemRepositoryTest {

  private static final UUID ID = UUID.fromString("a761f3ec-6371-4e76-9e8f-1deafefe15d4");
  private static final Date DATE = new Date();
  private static final TypeEnum TYPE = TypeEnum.EN;
  private static final String DESCRIPTION = "Conta de luz";
  private static final BigDecimal VALUE = BigDecimal.valueOf(65);
  private UUID savedWalletItemID = null;
  private UUID savedWalletId = null;

  @Autowired
  WalletItemsRepository repository;

  @Autowired
  WalletRepository walletRepository;

  @Before
  public void setUp(){
    Wallet w = new Wallet();
    w.setName("Carteira teste");
    w.setValue(BigDecimal.valueOf(250));
    walletRepository.save(w);

    WalletItem wi = new WalletItem(null, w, DATE, TYPE, DESCRIPTION, VALUE);
    repository.save(wi);

    savedWalletItemID = wi.getId();
    savedWalletId = w.getId();
  }

  @After
  public void tearDown(){
    repository.deleteAll();
    walletRepository.deleteAll();
  }


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

  @Test(expected = TransactionSystemException.class)
  public void testSveInvalidWalletItem(){
    WalletItem wi = new WalletItem(null, null, DATE, null, DESCRIPTION, null);
    repository.save(wi);
  }

  @Test
  public void testUpdate(){
    Optional<WalletItem> wi = repository.findById(savedWalletItemID);

    String description = "Descrição alterada";

    WalletItem changed = wi.get();
    changed.setDescription(description);

    repository.save(changed);

    Optional<WalletItem> newWalletItem = repository.findById(savedWalletItemID);

    assertEquals(description, newWalletItem.get().getDescription());
  }

  @Test
  public void deleteWalletItem(){
    Optional<Wallet> wallet = walletRepository.findById(savedWalletId);
    WalletItem wi = new WalletItem(null, wallet.get(), DATE, TYPE, DESCRIPTION, VALUE);

    repository.save(wi);
    repository.deleteById(wi.getId());

    Optional<WalletItem> response = repository.findById(wi.getId());

    assertFalse(response.isPresent());

  }

  @Test
  public void testFindBetweenDates(){
    Optional<Wallet> w = walletRepository.findById(savedWalletId);

    LocalDateTime date = DATE.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();

    Date currentDatePlusFiveDays = Date.from(date.plusDays(5).atZone(ZoneId.systemDefault()).toInstant());
    Date currentDatePlusSevenDays = Date.from(date.plusDays(7).atZone(ZoneId.systemDefault()).toInstant());

    repository.save(new WalletItem(null, w.get(), currentDatePlusFiveDays, TYPE, DESCRIPTION, VALUE));
    repository.save(new WalletItem(null, w.get(), currentDatePlusSevenDays, TYPE, DESCRIPTION, VALUE));

    PageRequest pg = new PageRequest(0, 10);
    Page<WalletItem> response = repository.findByWalletIdDate(savedWalletId, DATE, currentDatePlusFiveDays, pg);

    assertEquals(response.getContent().size(), 2);
    assertEquals(response.getTotalElements(), 2);
    assertEquals(response.getContent().get(0).getWallet().getId(), savedWalletId);
  }

  @Test
  public void testFindByType(){
    List<WalletItem> response = repository.findByWalletIdAndType(savedWalletId, TYPE);

    assertEquals(response.size(), 1);
    assertEquals(response.get(0).getType(), TYPE);
  }

  @Test
  public void testFIndByTypeSd(){
    Optional<Wallet> w = walletRepository.findById(savedWalletId);

    repository.save(new WalletItem(null,w.get(), DATE, TypeEnum.SD, DESCRIPTION, VALUE));
    List<WalletItem> response = repository.findByWalletIdAndType(savedWalletId, TypeEnum.SD);

    assertEquals(response.size(), 1);
    assertEquals(response.get(0).getType(), TypeEnum.SD);

  }

  @Test
  public void testSumByWallet(){
    Optional<Wallet> w = walletRepository.findById(savedWalletId);

    repository.save(new WalletItem(null, w.get(), DATE, TYPE, DESCRIPTION, BigDecimal.valueOf(150.80)));

    BigDecimal response = repository.sumByWalletId(savedWalletItemID);

    assertEquals(response.compareTo(BigDecimal.valueOf(215.8)), 0);
  }


}
