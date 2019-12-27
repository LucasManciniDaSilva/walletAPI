package wallet.repositoryTest;


import com.wallet.WalletApplication;
import com.wallet.entity.Users;
import com.wallet.repository.UserRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = WalletApplication.class)
@ContextConfiguration(classes = WalletApplication.class)
@ActiveProfiles("test")
public class UserRepositoryTest {

    private static final String EMAIL = "ike@gmail.com";

    @Autowired
    UserRepository repository;

    @Before
    public void setUp() {
        Users u = new Users();
        u.setName("Ike");
        u.setPassword("123456789");
        u.setEmail(EMAIL);

        repository.save(u);
    }

    @After
    public void tearDown() {
        repository.deleteAll();

    }

    @Test
    public void testSave() {
        Users u = new Users();
        u.setName("teste");
        u.setPassword("123456");
        u.setEmail("teste@gmail.com");

        Users response = repository.save(u);

        assertNotNull(response);
    }

    public void testFindByEmail() {
        Optional<Users> response = repository.findByEmailEquals(EMAIL);

        assertTrue(response.isPresent());
        assertEquals(response.get().getEmail(), EMAIL);
    }
}
