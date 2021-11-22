
import dao.ProductDaoImpl;
import dao.UserDaoImpl;
import entity.Boots;
import entity.Product;
import entity.User;
import exception.UserLoginAlreadyExistException;
import exception.UserShortLengthLoginException;
import exception.UserShortLengthPasswordException;
import validator.UserValidator;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, UserShortLengthLoginException, UserLoginAlreadyExistException, UserShortLengthPasswordException {
        User klimek = new User(1L, "Klimek", "admin1234");
        User kuba = new User(2L, "kuba", "gosc12345");

//        Product nike = new Boots(1L, "Nike", 250, 50, "black", 5, 43, false);
//        Product armani = new Boots(2L, "Armani", 300, 70, "black", 3, 42, true);
//
//        ProductDaoImpl productDao = new ProductDaoImpl("colo.txt");
//        productDao.saveProduct(nike);
//        System.out.println(productDao.getAllProducts());

        UserDaoImpl userDao = new UserDaoImpl("users.txt");
        //userDao.saveUser(klimek);
        //userDao.getUserByLogin("kuba");

        UserValidator.getInstance().isValidate(kuba);

    }


}
