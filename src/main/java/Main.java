import entity.Boots;
import entity.Product;
import service.ProductServiceImpl;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Product> products = new ArrayList<>();
        Product nike = new Boots(1L, "Nike", 250, 50, "black", 5, 43, false);
        Product armani = new Boots(2L, "Armani", 300, 70, "black", 3, 42, true);
        products.add(nike);
        //then
        ProductServiceImpl productService = new ProductServiceImpl(products);
        List<Product> result = new ArrayList<>(productService.getAllProducts());
        result.add(armani);

        //expected
        System.out.println("Wynik: " + result);
        System.out.println("Orginalna lista: " + products);

    }
}
