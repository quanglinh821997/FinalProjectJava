package Z_service;

import Z_model.BillM;
import model.Bill;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

public interface BillServiceM {
    public void input(BillM bill) throws ParseException;

    public void info(BillM bill);

    public void createBill(BillM bill);

    public List<BillM> findBillByDate(Date dateFrom, Date dateTo);

    public List<BillM> printAllBill();
}
