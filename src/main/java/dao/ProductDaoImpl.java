package dao;

import api.ProductDao;
import entity.Boots;
import entity.Cloth;
import entity.Product;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDaoImpl implements ProductDao {
    private final String fileName;

    public ProductDaoImpl(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void saveProduct(Product product) throws IOException {
        List<Product> products = getAllProducts();
        products.add(product);
        saveProducts(products);
    }

    @Override
    public void saveProducts(List<Product> products) throws FileNotFoundException {
        FileOutputStream fileOutputStream = new FileOutputStream(fileName, false);
        PrintWriter printWriter = new PrintWriter(fileOutputStream);
        for (Product product : products) {
            printWriter.write(product.toString() + "\n");
        }
        printWriter.close();
    }

    @Override
    public void removeProductById(Long productId) throws IOException {
        List<Product> products = getAllProducts();
        products.removeIf(product -> product.getId() == productId);
        saveProducts(products);
    }

    @Override
    public void removeProductByName(String name) throws IOException {
        List<Product> products = getAllProducts();
        products.removeIf(product -> product.getProductName().equals(name));
        saveProducts(products);
    }

    @Override
    public List<Product> getAllProducts() throws IOException {
        List<Product> products = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        String read = reader.readLine();

        while (read != null) {
            String[] array = read.split("#");
            long id = Long.parseLong(array[0]);
            String name = array[1];
            double price = Double.parseDouble(array[2]);
            double weight = Double.parseDouble(array[3]);
            String color = array[4];
            int productCount = Integer.parseInt(array[5]);
            read = reader.readLine();

            if (fileName.contains("boots")) {
                int size = Integer.parseInt(array[6]);
                boolean isNaturalSkin = Boolean.parseBoolean(array[7]);
                products.add(new Boots(id, name, price, weight, color, productCount, size, isNaturalSkin));
            } else if (fileName.contains("clothes")) {
                String size = array[6];
                String material = array[7];
                products.add(new Cloth(id, name, price, weight, color, productCount, size, material));
            }
        }
        return products;
    }

    @Override
    public Product getProductById(Long productId) throws IOException {
        List<Product> products = getAllProducts();
        for (Product product : products) {
            if (product.getId() == productId) {
                return product;
            }
        }
        return null;
    }

    @Override
    public Product getProductByProductName(String productName) throws IOException {
        List<Product> products = getAllProducts();
        for (Product product : products) {
            if (product.getProductName().equals(productName)) {
                return product;
            }
        }
        return null;
    }
}
