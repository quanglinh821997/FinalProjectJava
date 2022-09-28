package service;

import Z_model.BillM;
import dao.BillDaoImplement;
import model.Bill;
import model.Product;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Scanner;

public class BillServiceImplement implements BillService {
    @Override
    public void input(Bill bill) throws ParseException {
        System.out.print("Enter idBill: ");
        bill.setIdBill(new Scanner(System.in).nextInt());

        System.out.print("Enter idProduct: ");
        int idProduct = new Scanner(System.in).nextInt();
        Product product = new Product(idProduct);
        bill.setProduct(product);

        System.out.print("Enter quantityBill: ");
        bill.setQuantityBill(new Scanner(System.in).nextInt());

        System.out.print("Enter buyDateBill(yyyy-MM-dd): ");
        String date = new Scanner(System.in).nextLine();
        bill.setBuyDateBill(new SimpleDateFormat("yyyy-MM-dd").parse(date));
    }

    @Override
    public void info(Bill bill) {
        System.out.printf("%-20d", bill.getIdBill());
        System.out.printf("%-20s", bill.getProduct().getNameProduct());
        System.out.printf("%-20d", bill.getProduct().getPriceProduct());
        System.out.printf("%-20d", bill.getQuantityBill());
        System.out.printf("%-20d", bill.getPriceBill());
        System.out.printf("%-20s", bill.getBuyDateBill());
        System.out.println();
    }

    @Override
    public void createBill(Bill bill) {
        BillDaoImplement billDaoImplement = new BillDaoImplement();
        billDaoImplement.createBillJDBC(bill);
    }


    @Override
    public List<Bill> findBillByDate(String dateFrom, String dateTo) {
        BillDaoImplement billDaoImplement = new BillDaoImplement();
        return billDaoImplement.findBillByDateJDBC(dateFrom, dateTo);
    }

    @Override
    public List<Bill> printAllBill() {
        BillDaoImplement billDaoImplement = new BillDaoImplement();
        return billDaoImplement.printAllBillJDBC();
    }
}
