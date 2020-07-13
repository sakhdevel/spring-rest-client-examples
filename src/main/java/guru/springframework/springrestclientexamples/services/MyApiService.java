package guru.springframework.springrestclientexamples.services;

import guru.springframework.api.domain.my.User;

import java.util.List;

/**
 * Created by jt on 9/21/17.
 */
public interface MyApiService {

    User getUser();

    List<User> getUsers();
}
