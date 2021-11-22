package dao;

import api.UserDao;
import entity.Product;
import entity.User;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao {
    private final String fileName;

    public UserDaoImpl(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void saveUser(User user) throws IOException {
        List<User> users = getAllUsers();
        users.add(user);
        saveUsers(users);
    }

    @Override
    public void saveUsers(List<User> users) throws FileNotFoundException {
        FileOutputStream fileOutputStream = new FileOutputStream(fileName, false);
        PrintWriter printWriter = new PrintWriter(fileOutputStream);
        for (User user : users) {
            printWriter.write(user.toString() + "\n");
        }
        printWriter.close();
    }

    @Override
    public List<User> getAllUsers() throws IOException {
        List<User> users = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        String read = reader.readLine();

        while(read != null) {
            String[] array = read.split("#");
            long id = Long.parseLong(array[0]);
            String login = array[1];
            String password = array[2];
            read = reader.readLine();
            users.add(new User(id, login, password));
        }
        return users;
    }

    @Override
    public User getUserByLogin(String login) throws IOException {
        List<User> users = getAllUsers();
        for (User user : users) {
            if (user.getLogin().equals(login)) {
                return user;
            }
        }
        return null;
    }
    @Override
    public boolean isUserByLoginExist(String login) throws IOException {
        return getUserByLogin(login) != null;
    }

    @Override
    public User getUserById(Long userId) throws IOException {
        List<User> users = getAllUsers();
        for (User user : users) {
            if (user.getId() == userId) {
                return user;
            }
        }
        return null;
    }

    @Override
    public void removeUserByLogin(String login) throws IOException {
        List<User> users = getAllUsers();
        users.removeIf(user -> user.getLogin().equals(login));
        saveUsers(users);
    }

    @Override
    public void removeUserById(Long id) throws IOException {
        List<User> users = getAllUsers();
        users.removeIf(user -> user.getId() == id);
        saveUsers(users);
    }


}
