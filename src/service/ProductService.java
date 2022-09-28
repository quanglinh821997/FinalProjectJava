package service;

import model.Category;
import model.Product;

import java.util.List;

public interface ProductService {
    public void input(Product product);

    public void info(Product product);

    public void createProduct(Product product);

    public void updateProduct(Product product);

    public void deleteProduct(int id);

    public Product findByIdProduct(int id);

    public List<Product> findByNameProduct(String name);

    public List<Product> findByPriceProduct(int priceLow, int priceHigh);

    public List<Product> findByNameCategory(String name);

    public List<Product> printAllProduct();
}
