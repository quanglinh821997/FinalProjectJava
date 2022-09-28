package service;

import dao.ProductDaoImplement;
import model.Category;
import model.Product;

import java.util.List;
import java.util.Scanner;

public class ProductServiceImplement implements ProductService {
    @Override
    public void input(Product product) {
        System.out.print("Enter idProduct: ");
        product.setIdProduct(new Scanner(System.in).nextInt());

        System.out.print("Enter nameProduct: ");
        product.setNameProduct(new Scanner(System.in).nextLine());

        System.out.print("Enter quantityProduct: ");
        product.setQuantityProduct(new Scanner(System.in).nextInt());

        System.out.print("Enter priceProduct: ");
        product.setPriceProduct(new Scanner(System.in).nextInt());

        System.out.print("Enter idCategory: ");
        int idCategory = new Scanner(System.in).nextInt();
        Category category = new Category(idCategory);
        product.setCategory(category);
    }

    @Override
    public void info(Product product) {
        System.out.printf("%-15d", product.getIdProduct());
        System.out.printf("%-15s", product.getNameProduct());
        System.out.printf("%-15s", product.getQuantityProduct());
        System.out.printf("%-15s", product.getPriceProduct());
        System.out.printf("%-15s", product.getCategory().getIdCategory());
        System.out.printf("%-15s", product.getCategory().getNameCategory());
        System.out.println();
    }

    @Override
    public void createProduct(Product product) {
        ProductDaoImplement productDaoImplement = new ProductDaoImplement();
        productDaoImplement.createProductJDBC(product);
    }

    @Override
    public void updateProduct(Product product) {
        ProductDaoImplement productDaoImplement = new ProductDaoImplement();
        productDaoImplement.updateProductJDBC(product);
    }

    @Override
    public void deleteProduct(int id) {
        ProductDaoImplement productDaoImplement = new ProductDaoImplement();
        productDaoImplement.deleteProductJDBC(id);
    }

    @Override
    public Product findByIdProduct(int id) {
        ProductDaoImplement productDaoImplement = new ProductDaoImplement();
        return productDaoImplement.findByIDProductJDBC(id);
    }

    @Override
    public List<Product> findByNameProduct(String name) {
        ProductDaoImplement productDaoImplement = new ProductDaoImplement();
        return productDaoImplement.findByNameProductJDBC(name);
    }

    @Override
    public List<Product> findByPriceProduct(int priceLow, int priceHigh) {
        ProductDaoImplement productDaoImplement = new ProductDaoImplement();
        return productDaoImplement.findByPriceProductJDBC(priceLow, priceHigh);
    }

    @Override
    public List<Product> findByNameCategory(String name) {
        ProductDaoImplement productDaoImplement = new ProductDaoImplement();
        return productDaoImplement.findByNameCategoryJDBC(name);
    }

    @Override
    public List<Product> printAllProduct() {
        ProductDaoImplement productDaoImplement = new ProductDaoImplement();
        return productDaoImplement.printAllProductJDBC();
    }
}
