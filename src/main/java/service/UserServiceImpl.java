package service;

import entity.User;

import java.util.ArrayList;
import java.util.List;

public class UserServiceImpl {

    List<User> users;

    public UserServiceImpl(List<User> users) {
        this.users = users;
    }

    public UserServiceImpl() {
        this.users = new ArrayList<User>();
    }


    public List<User> getAllUsers() {
        return users;
    }

    public void addUser(User user) {
        users.add(user);
    }

    public void removeUserById(Long userId) {
        for (int i = 0; i < users.size(); i++) {

            User userFromList = users.get(i);

            if (userFromList.getId() == userId) {
                users.remove(i);
                break;
            }
        }
    }
}
