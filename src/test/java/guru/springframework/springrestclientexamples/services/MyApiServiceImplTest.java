package guru.springframework.springrestclientexamples.services;

import guru.springframework.api.domain.my.User;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MyApiServiceImplTest {

    @Autowired
    MyApiService myApiService;

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void testGetUser() throws Exception {
        User user = myApiService.getUser();

        assertEquals("Leanne Graham", user.getName());
    }

    @Test
    public void testGetUsers() {
        List<User> users = myApiService.getUsers();

        assertEquals(10, users.size());
    }
}