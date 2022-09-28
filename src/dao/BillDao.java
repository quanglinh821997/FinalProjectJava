package dao;

import model.Bill;

import java.util.List;

public interface BillDao {
    public void createBillJDBC(Bill bill);

    public List<Bill> findBillByDateJDBC(String dateFrom, String dateTo);

    public List<Bill> printAllBillJDBC();
}
