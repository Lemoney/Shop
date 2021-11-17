package dao;

import entity.Boots;
import entity.Product;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

public class ProductDaoTest {

    @Test
    public void testSaveProduct() throws IOException {
        Product nike = new Boots(1L, "Nike", 250, 50, "black", 5, 43, false);
        Product armani = new Boots(2L, "Armani", 300, 70, "black", 3, 42, true);
        ProductDaoImpl productDao = new ProductDaoImpl("test_save_product_1.tst");
        productDao.saveProduct(nike);
    }
}
