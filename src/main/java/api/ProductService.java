package api;

import entity.Product;

import java.util.List;

public interface ProductService {

    List<Product> getAllProducts();
    int getNumberOfProducts();
    Product getProductByName(String productName);
    boolean isProductAvalible(String productName);
    boolean isProductNameExist(String productName);
    boolean isProductIdExist(Long id);


}
