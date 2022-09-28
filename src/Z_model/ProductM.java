package Z_model;

import model.Category;

public class ProductM {
    private int idProduct;
    private String nameProduct;
    private int quantityProduct;
    private int priceProduct;
    private CategoryM category;

    public ProductM() {
    }

    public ProductM(int idProduct) {
        this.idProduct = idProduct;
    }

    public ProductM(int idProduct, String nameProduct, int priceProduct) {
        this.idProduct = idProduct;
        this.nameProduct = nameProduct;
        this.priceProduct = priceProduct;
    }

    public ProductM(int idProduct, String nameProduct, int quantityProduct, int priceProduct, CategoryM category) {
        this.idProduct = idProduct;
        this.nameProduct = nameProduct;
        this.quantityProduct = quantityProduct;
        this.priceProduct = priceProduct;
        this.category = category;
    }

    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public int getQuantityProduct() {
        return quantityProduct;
    }

    public void setQuantityProduct(int quantityProduct) {
        this.quantityProduct = quantityProduct;
    }

    public int getPriceProduct() {
        return priceProduct;
    }

    public void setPriceProduct(int priceProduct) {
        this.priceProduct = priceProduct;
    }

    public CategoryM getCategory() {
        return category;
    }

    public void setCategory(CategoryM category) {
        this.category = category;
    }
}
