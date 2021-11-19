
import dao.UserDaoImpl;
import entity.User;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
//        User klimek = new User(1L, "Klimek", "admin");
//        User kuba = new User(2L, "kuba", "gosc");

//        try {
//            UserDaoImpl userDao = new UserDaoImpl("colo.txt");
//            userDao.removeUserByLogin("kuba");
//            userDao.removeUserById(1L);
//            userDao.removeUserById(1L);
//            System.out.println(userDao.getAllUsers());
//        } catch (FileNotFoundException e) {
//            System.out.println("Nie ma takiego pliku, co ty se myslis");
//        }
        String name = "Klimek";
        try {
            System.out.println(name.length());
        } catch (NullPointerException e) {
            System.out.println("Null pointer exception");
        } finally {
            System.out.println("To wyświetlam i tak.");
        }
    }


}
