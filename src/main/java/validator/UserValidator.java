package validator;

import dao.UserDaoImpl;
import entity.User;
import exception.UserLoginAlreadyExistException;
import exception.UserShortLengthLoginException;
import exception.UserShortLengthPasswordException;

import java.io.IOException;
/*
Class cheks that the users logn and password is long enough
If it's not it throws special exceptions
 */

public class UserValidator {

    private final int MIN_PASSWORD_LENGTH = 6;
    private final int MIN_LOGIN_LENGTH = 4;
    private static UserValidator instance = null;
    UserDaoImpl userDao = new UserDaoImpl("users.txt");

    public static UserValidator getInstance() {
        if (instance == null) {
            instance = new UserValidator();
        }
        return instance;
    }

    public boolean isValidate(User user) throws UserShortLengthPasswordException, UserShortLengthLoginException, IOException, UserLoginAlreadyExistException {
        if (!isPasswordLongEnough(user.getPassword())) {
            throw new UserShortLengthPasswordException("Password \"" + user.getPassword() + "\" is too short.");
        }
        if (!isLoginLongEnough(user.getLogin())) {
            throw new UserShortLengthLoginException("Login \"" + user.getLogin() + "\" is too short.");
        }
        if (!isLoginExist(user.getLogin())) {
            throw new UserLoginAlreadyExistException("User with this login already exist");
        }
        return true;
    }

    private boolean isPasswordLongEnough(String password) {
        return password.length() >= instance.MIN_PASSWORD_LENGTH;
    }

    private boolean isLoginLongEnough(String login) {
        return login.length() >= instance.MIN_LOGIN_LENGTH;
    }

    private boolean isLoginExist(String login) {
        boolean exist = false;
        try {
            exist = userDao.isUserByLoginExist(login);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return !exist;
    }
}
