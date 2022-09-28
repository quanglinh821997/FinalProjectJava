package Z_service;

import Z_dao.ProductDaoImplementM;
import Z_model.CategoryM;
import Z_model.ProductM;

import java.util.List;
import java.util.Scanner;

public class ProductServiceImplementM implements ProductServiceM {

    @Override
    public void input(ProductM product) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter idProduct : ");
        product.setIdProduct(Integer.parseInt(sc.nextLine()));
        System.out.println("Enter nameProduct : ");
        product.setNameProduct(sc.nextLine());
        System.out.println("Enter quantity : ");
        product.setQuantityProduct(Integer.parseInt(sc.nextLine()));
        System.out.println("Enter price : ");
        product.setPriceProduct(sc.nextInt());

        CategoryServiceImplementM categoryServiceImplementM = new CategoryServiceImplementM();
        List<CategoryM> categoryMList = categoryServiceImplementM.printAllCategory();

        boolean isCategoryValid = false;
        while (!isCategoryValid) {
            System.out.println("Enter idCategory : ");
            int idCategory = sc.nextInt();

            for(CategoryM categoryM : categoryMList) {
                if (idCategory ==  categoryM.getIdCategory()) {
                    product.setCategory(categoryM);
                    isCategoryValid = true;
                    break;
                }
            }
        }
    }


    @Override
    public void info(ProductM product) {
        System.out.printf("%s%15s%15s%15s%15s",product.getIdProduct(),product.getNameProduct()
                ,product.getQuantityProduct(),product.getPriceProduct(),product.getCategory().getIdCategory());
        System.out.println();
    }

    @Override
    public void createProduct(ProductM product) {
        ProductDaoImplementM productDaoImplementM = new ProductDaoImplementM();
        productDaoImplementM.createProductJDBC(product);
    }



    @Override
    public void updateProduct(int id) {
        ProductDaoImplementM productDaoImplementM = new ProductDaoImplementM();
        productDaoImplementM.updateProductJDBC(id);
    }

    @Override
    public void deleteProduct(int id) {
        ProductDaoImplementM productDaoImplementM = new ProductDaoImplementM();
        productDaoImplementM.deleteProductJDBC(id);
    }

    @Override
    public ProductM findByIdProduct(int id) {
        ProductDaoImplementM productDaoImplementM = new ProductDaoImplementM();
        ProductM productM = productDaoImplementM.findByIDProductJDBC(id);
        return productM;
    }

    @Override
    public List<ProductM> findByNameProduct(String name) {
        ProductDaoImplementM productDaoImplementM = new ProductDaoImplementM();
        List<ProductM> productMList = productDaoImplementM.findByNameProductJDBC(name);
        return productMList;
    }

    @Override
    public List<ProductM> findByPriceProduct(int priceLow, int priceHigh) {
        ProductDaoImplementM productDaoImplementM = new ProductDaoImplementM();
        List<ProductM> productMList = productDaoImplementM.findByPriceProductJDBC(priceLow,priceHigh);
        return productMList;
    }

    @Override
    public List<ProductM> findByNameCategory(String name) {
        ProductDaoImplementM productDaoImplementM = new ProductDaoImplementM();
        List<ProductM> productMList = productDaoImplementM.findByNameCategoryJDBC(name);
        return productMList;
    }

    @Override
    public List<ProductM> printAllProduct() {
        ProductDaoImplementM productDaoImplementM = new ProductDaoImplementM();
        List<ProductM> productMList = productDaoImplementM.printAllProductJDBC();
        return productMList;
    }
}
