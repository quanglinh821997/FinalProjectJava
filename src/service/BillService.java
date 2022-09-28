package service;

import Z_model.BillM;
import model.Bill;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

public interface BillService {
    void input(Bill bill) throws ParseException;

    void info(Bill bill);

    void createBill(Bill bill);


    public List<Bill> findBillByDate(String dateFrom, String dateTo);

    public List<Bill> printAllBill();
}
