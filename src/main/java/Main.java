
import dao.UserDaoImpl;
import entity.User;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
//        User klimek = new User(1L, "Klimek", "admin");
//        User kuba = new User(2L, "kuba", "gosc");

        UserDaoImpl userDao = new UserDaoImpl("users.txt");
        System.out.println(userDao.getUserById(2L));
        userDao.removeUserByLogin("kuba");
        System.out.println(userDao.getAllUsers());


    }


}
