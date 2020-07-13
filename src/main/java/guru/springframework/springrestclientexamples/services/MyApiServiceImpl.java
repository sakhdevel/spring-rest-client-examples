package guru.springframework.springrestclientexamples.services;

import guru.springframework.api.domain.my.User;
import guru.springframework.api.domain.my.UserList;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by jt on 9/21/17.
 */
@Service
public class MyApiServiceImpl implements  MyApiService {

    private RestTemplate restTemplate;

    public MyApiServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public User getUser() {
        User user = restTemplate.getForObject("https://jsonplaceholder.typicode.com/users/1", User.class);

        return user;
    }

//    @Override
//    public List<User> getUsers() {
//        UserList userList = restTemplate.getForObject("https://jsonplaceholder.typicode.com/users", UserList.class);
//        return userList.getUsers();
//    }

    @Override
    public List<User> getUsers() {
        ResponseEntity<User[]> response =
            restTemplate.getForEntity(
                "https://jsonplaceholder.typicode.com/users",
                User[].class);
        User[] users = response.getBody();

        return new ArrayList<User>(Arrays.asList(users));
    }
}
