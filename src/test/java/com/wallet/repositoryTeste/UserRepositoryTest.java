package com.wallet.repositoryTeste;


import com.wallet.repository.UserRepository;
import com.wallet.entity.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class UserRepositoryTest {

    private static final String EMAIL = "ike@gmail.com";

    @Autowired
    UserRepository repository;

    @Before
    public void setUp(){
        User u = new User();
        u.setName("Ike");
        u.setPassword("123456789");
        u.setEmail(EMAIL);

        repository.save(u);
    }

    @After
    public void tearDown(){
        repository.deleteAll();

    }

    @Test
    public void testSave() {
        User u = new User();
        u.setName("teste");
        u.setPassword("123456");
        u.setEmail("teste@gmail.com");

        User response = repository.save(u);

        assertNotNull(response);
    }

    public void testFindByEmail() {
        Optional<User> response = repository.findByEmailEquals(EMAIL);

        assertTrue(response.isPresent());
        assertEquals(response.get().getEmail(), EMAIL);
    }
}
