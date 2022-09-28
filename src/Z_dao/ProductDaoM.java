package Z_dao;

import Z_model.ProductM;
import model.Bill;

import java.util.List;

public interface ProductDaoM {
    public void createProductJDBC(ProductM product);

    public void updateProductJDBC(int idProduct);

    public void deleteProductJDBC(int id);

    public ProductM findByIDProductJDBC(int id);

    public int getQuantityProductJDBC(int id);

//    public void updateQuantiTyProductJDBC(BillM bill);

    public int getPriceProductJDBC(int id);

    public List<ProductM> findByNameProductJDBC(String name);

    public List<ProductM> findByPriceProductJDBC(int priceLow, int priceHigh);

    public List<ProductM> findByNameCategoryJDBC(String name);

    public List<ProductM> printAllProductJDBC();
}
