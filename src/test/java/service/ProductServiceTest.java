package service;

import entity.Boots;
import entity.Product;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class ProductServiceTest {

    @Test
    public void testGetAllProductsPositive() {
        //is
        List<Product> products = new ArrayList<>();
        Product nike = new Boots(1L, "Nike", 250, 50, "black", 5, 43, false);
        Product armani = new Boots(2L, "Armani", 300, 70, "black", 3, 42, true);
        products.add(nike);
        products.add(armani);
        //then
        ProductServiceImpl productService = new ProductServiceImpl(products);
        //expected
        Assert.assertEquals(products, productService.getAllProducts());
    }

    @Test
    public void testGetAllProductsNegative() {
        //is
        List<Product> products = new ArrayList<>();
        Product nike = new Boots(1L, "Nike", 250, 50, "black", 5, 43, false);
        Product armani = new Boots(2L, "Armani", 300, 70, "black", 3, 42, true);
        products.add(nike);
        //then
        ProductServiceImpl productService = new ProductServiceImpl(products);
        List<Product> result = new ArrayList<>(productService.getAllProducts());
        result.add(armani);

        //expected
        Assert.assertNotEquals(products, result);
    }

    @Test
    public void testGetNumberOfProductsPositive() {
        //is
        List<Product> products = new ArrayList<>();
        Product nike = new Boots(1L, "Nike", 250, 50, "black", 5, 43, false);
        Product armani = new Boots(2L, "Armani", 300, 70, "black", 3, 42, true);
        products.add(nike);
        products.add(armani);
        //then
        ProductServiceImpl productService = new ProductServiceImpl(products);
        //expected
        Assert.assertEquals(products.size(), productService.getNumberOfProducts());
    }

    @Test
    public void testGetNumberOfZeroProduct() {
        //is
        List<Product> products = new ArrayList<>();
        //then
        ProductServiceImpl productService = new ProductServiceImpl(products);
        //expected
        Assert.assertEquals(0, productService.getNumberOfProducts());
    }

    @Test
    public void testGetProductByNamePositive() {
        List<Product> products = new ArrayList<>();
        Product nike = new Boots(1L, "Nike", 250, 50, "black", 5, 43, false);
        Product armani = new Boots(2L, "Armani", 300, 70, "black", 3, 42, true);
        products.add(nike);
        products.add(armani);
        //then
        ProductServiceImpl productService = new ProductServiceImpl(products);
        //expected
        Assert.assertEquals(armani, productService.getProductByName("Armani"));
    }

    @Test
    public void testGetProductByNameNegative() {
        List<Product> products = new ArrayList<>();
        Product nike = new Boots(1L, "Nike", 250, 50, "black", 5, 43, false);
        Product armani = new Boots(2L, "Armani", 300, 70, "black", 3, 42, true);
        products.add(nike);
        products.add(armani);
        //then
        ProductServiceImpl productService = new ProductServiceImpl(products);
        //expected
        Assert.assertNotEquals(armani, productService.getProductByName("Nike"));
    }

    @Test
    public void testGetProductByNameIfUnknown() {
        List<Product> products = new ArrayList<>();
        Product nike = new Boots(1L, "Nike", 250, 50, "black", 5, 43, false);
        Product armani = new Boots(2L, "Armani", 300, 70, "black", 3, 42, true);
        products.add(nike);
        products.add(armani);
        //then
        ProductServiceImpl productService = new ProductServiceImpl(products);
        //expected
        Assert.assertNull(productService.getProductByName("Adidas"));
    }

    @Test
    public void testIsProductAvalibleTrue() {
        //is
        List<Product> products = new ArrayList<>();
        Product nike = new Boots(1L, "Nike", 250, 50, "black", 5, 43, false);
        Product armani = new Boots(2L, "Armani", 300, 70, "black", 0, 42, true);
        products.add(nike);
        products.add(armani);
        //then
        ProductServiceImpl productService = new ProductServiceImpl(products);
        //expected
        Assert.assertTrue(productService.isProductAvalible("Nike"));
    }

    @Test
    public void testIsProductAvalibleFalse() {
        //is
        List<Product> products = new ArrayList<>();
        Product nike = new Boots(1L, "Nike", 250, 50, "black", 5, 43, false);
        Product armani = new Boots(2L, "Armani", 300, 70, "black", 0, 42, true);
        products.add(nike);
        products.add(armani);
        //then
        ProductServiceImpl productService = new ProductServiceImpl(products);
        //expected
        Assert.assertFalse(productService.isProductAvalible("Armani"));
    }

    @Test
    public void testIsProductNameExistTrue() {
        //is
        List<Product> products = new ArrayList<>();
        Product nike = new Boots(1L, "Nike", 250, 50, "black", 5, 43, false);
        Product armani = new Boots(2L, "Armani", 300, 70, "black", 0, 42, true);
        products.add(nike);
        products.add(armani);
        //then
        ProductServiceImpl productService = new ProductServiceImpl(products);
        //expected
        Assert.assertTrue(productService.isProductNameExist("Armani"));
    }

    @Test
    public void testIsProductNameExistFalse() {
        //is
        List<Product> products = new ArrayList<>();
        Product nike = new Boots(1L, "Nike", 250, 50, "black", 5, 43, false);
        Product armani = new Boots(2L, "Armani", 300, 70, "black", 0, 42, true);
        products.add(nike);
        products.add(armani);
        //then
        ProductServiceImpl productService = new ProductServiceImpl(products);
        //expected
        Assert.assertFalse(productService.isProductNameExist("Adidas"));
    }

    @Test
    public void testIsProductIdExistTrue() {
        //is
        List<Product> products = new ArrayList<>();
        Product nike = new Boots(1L, "Nike", 250, 50, "black", 5, 43, false);
        Product armani = new Boots(2L, "Armani", 300, 70, "black", 0, 42, true);
        products.add(nike);
        products.add(armani);
        //then
        ProductServiceImpl productService = new ProductServiceImpl(products);
        //expected
        Assert.assertTrue(productService.isProductIdExist(2L));
    }

    @Test
    public void testIsProductIdExistFalse() {
        //is
        List<Product> products = new ArrayList<>();
        Product nike = new Boots(1L, "Nike", 250, 50, "black", 5, 43, false);
        Product armani = new Boots(2L, "Armani", 300, 70, "black", 0, 42, true);
        products.add(nike);
        products.add(armani);
        //then
        ProductServiceImpl productService = new ProductServiceImpl(products);
        //expected
        Assert.assertFalse(productService.isProductIdExist(3L));
    }
}
