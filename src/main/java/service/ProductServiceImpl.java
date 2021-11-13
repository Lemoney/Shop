package service;

import api.ProductService;
import entity.Product;
import java.util.ArrayList;
import java.util.List;

public class ProductServiceImpl implements ProductService {

    List<Product> products;

    public ProductServiceImpl(List<Product> products) {
        this.products = products;
    }

    public ProductServiceImpl() {
        products = new ArrayList<>();
    }

    public List<Product> getAllProducts() {
        return products;
    }

    public int getNumberOfProducts() {
        return products.size();
    }

    @Override
    public Product getProductByName(String productName) {
        for (Product product : products) {
            if (productName.equals(product.getProductName())) {
                return product;
            }
        }
        return null;
    }

    @Override
    public boolean isProductAvalible(String productName) {
        Product product = getProductByName(productName);
        return product.getProductCount() > 0;
    }

    @Override
    public boolean isProductNameExist(String productName) {
        return getProductByName(productName) != null;
    }

    @Override
    public boolean isProductIdExist(Long id) {
       for(Product product : products) {
           if (product.getId() == id) {
               return true;
           }
       }
       return false;
    }
}
