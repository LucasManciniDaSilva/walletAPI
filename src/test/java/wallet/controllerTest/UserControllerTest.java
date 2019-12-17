package wallet.controllerTest;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.wallet.WalletApplication;
import com.wallet.entity.User;
import com.wallet.service.UserService;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = WalletApplication.class)
@ContextConfiguration(classes = WalletApplication.class)
@ActiveProfiles("test")
public class UserControllerTest {

    private static final String EMAIL = "ike@gmail.com";
    private static final String PASSWORD = "123456789";
    private static final String NAME = "Ike";
    private static final String URL = "/user";

    @MockBean
    UserService service;

    @Autowired
    MockMvc mvc;

    public void testSave() throws Exception {

        mvc.perform(MockMvcRequestBuilders.post(URL).content(getJsonPayload())
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());


    }

    public User getMockUser() {
        User u = new User();
        u.setEmail(EMAIL);
        u.setPassword(PASSWORD);
        u.setName(NAME);

        return u;
    }

    public String getJsonPayload() {
        UserDTO dto = new UserDTO();
        dto.setEmail(EMAIL);
        dto.setPassword(PASSWORD);
        dto.setName(NAME);

        ObjectMapper mapper = new ObjectMapper();

        mapper.writeValueAsString(dto);


    }

}
