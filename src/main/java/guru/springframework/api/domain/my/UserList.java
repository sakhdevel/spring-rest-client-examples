package guru.springframework.api.domain.my;

import java.util.ArrayList;
import java.util.List;

public class UserList {

    private List<User> users;

    public UserList() {
        this.users = new ArrayList<>();
    }

    public List<User> getUsers() {
        return users;
    }
}
