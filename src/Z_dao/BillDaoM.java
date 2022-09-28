package Z_dao;

import Z_model.BillM;
import model.Bill;

import java.util.Date;
import java.util.List;

public interface BillDaoM {
    public void createBillJDBC(BillM bill);

    public List<BillM> findBillByDateJDBC(Date dateFrom, Date dateTo);

    public List<BillM> printAllBillJDBC();
}
