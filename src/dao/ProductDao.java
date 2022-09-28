package dao;

import model.Bill;
import model.Product;

import java.util.List;

public interface ProductDao {
    public void createProductJDBC(Product product);

    public void updateProductJDBC(Product product);

    public void deleteProductJDBC(int id);

    public Product findByIDProductJDBC(int id);

    public int getQuantityProductJDBC(int id);

    public void updateQuantiTyProductJDBC(Bill bill);

    public int getPriceProductJDBC(int id);

    public List<Product> findByNameProductJDBC(String name);

    public List<Product> findByPriceProductJDBC(int priceLow, int priceHigh);

    public List<Product> findByNameCategoryJDBC(String name);

    public List<Product> printAllProductJDBC();
}
