package model;

import java.util.Date;

public class Bill {
    private int idBill;
    private Product product;
    private int quantityBill;
    private int priceBill;
    private Date buyDateBill;

    public Bill() {
    }

    public Bill(int idBill, Product product, int quantityBill, int priceBill, Date buyDateBill) {
        this.idBill = idBill;
        this.product = product;
        this.quantityBill = quantityBill;
        this.priceBill = priceBill;
        this.buyDateBill = buyDateBill;
    }

    public int getIdBill() {
        return idBill;
    }

    public void setIdBill(int idBill) {
        this.idBill = idBill;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantityBill() {
        return quantityBill;
    }

    public void setQuantityBill(int quantityBill) {
        this.quantityBill = quantityBill;
    }

    public int getPriceBill() {
        return priceBill;
    }

    public void setPriceBill(int priceBill) {
        this.priceBill = priceBill;
    }

    public Date getBuyDateBill() {
        return buyDateBill;
    }

    public void setBuyDateBill(Date buyDateBill) {
        this.buyDateBill = buyDateBill;
    }
}
