package Z_service;

import Z_model.ProductM;

import java.util.List;

public interface ProductServiceM {
    public void input(ProductM product);

    public void info(ProductM product);

    public void createProduct(ProductM product);

    public void updateProduct(int id);

    public void deleteProduct(int id);

    public ProductM findByIdProduct(int id);

    public List<ProductM> findByNameProduct(String name);

    public List<ProductM> findByPriceProduct(int priceLow, int priceHigh);

    public List<ProductM> findByNameCategory(String name);

    public List<ProductM> printAllProduct();
}
