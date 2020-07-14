package guru.springframework.springrestclientexamples.services;

import guru.springframework.api.domain.my.User;
import guru.springframework.api.domain.my.UserList;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by jt on 9/21/17.
 */
@Service
public class MyApiServiceImpl implements  MyApiService {

    private RestTemplate restTemplate;

    private final String api_url;

    public MyApiServiceImpl(RestTemplate restTemplate, @Value("${api.url}") String api_url) {
        this.restTemplate = restTemplate;
        this.api_url = api_url;
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
        UriComponentsBuilder uriComponentsBuilder
            = UriComponentsBuilder.fromUriString(api_url)
//            .query("limit", limit)
            ;

        ResponseEntity<User[]> response = restTemplate.getForEntity(uriComponentsBuilder.toUriString(), User[].class);
        User[] users = response.getBody();

        return new ArrayList<User>(Arrays.asList(users));
    }
}
