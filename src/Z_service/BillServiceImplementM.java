package Z_service;

import Z_dao.BillDaoImplementM;
import Z_model.BillM;
import Z_model.ProductM;
import model.Bill;
import service.BillService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class BillServiceImplementM implements BillServiceM {
    @Override
    public void input(BillM bill) throws ParseException {
        Scanner sc = new Scanner(System.in);
        /*
        public BillM(int idBill, Product product, int quantityBill, int priceBill, Date buyDateBill)
         */
        System.out.println("Enter idBill : ");
        bill.setIdBill(Integer.parseInt(sc.nextLine()));

        // Set product of bill
        // Take list of product => check invalid input idProduct
        ProductServiceImplementM productServiceImplementM = new ProductServiceImplementM();
        List<ProductM> productMList = productServiceImplementM.printAllProduct();
        boolean isValidProduct = false;
        while (!isValidProduct) {
            System.out.println("Enter idProduct : ");
            int idProduct = Integer.parseInt(sc.nextLine());
            for (ProductM productM :productMList) {
                if (productM.getIdProduct() == idProduct) {
                    isValidProduct = true;
                    bill.setProduct(productM);
                    break;
                }
            }
        }

        System.out.println("Enter quantityBill : ");
        bill.setQuantityBill(Integer.parseInt(sc.nextLine()));

        System.out.println("Enter priceBill : ");
        bill.setPriceBill(Integer.parseInt(sc.nextLine()));

        System.out.println("Enter date : ");
        String dateString = sc.nextLine();
        Date date = new SimpleDateFormat("yyyy-MM-dd").parse(dateString);
        bill.setBuyDateBill(date);

    }

    @Override
    public void info(BillM bill) {
        System.out.printf("%s%15s%15s%15s%15s",bill.getIdBill(),bill.getProduct().getIdProduct()
            ,bill.getQuantityBill(),bill.getPriceBill(),bill.getBuyDateBill());
        System.out.println();
    }

    @Override
    public void createBill(BillM bill) {
        BillDaoImplementM billDaoImplementM = new BillDaoImplementM();
        billDaoImplementM.createBillJDBC(bill);
    }

    @Override
    public List<BillM> findBillByDate(Date dateFrom, Date dateTo) {
        BillDaoImplementM billDaoImplementM = new BillDaoImplementM();
        List<BillM> billMList = billDaoImplementM.findBillByDateJDBC(dateFrom,dateTo);
        return billMList;
    }

    @Override
    public List<BillM> printAllBill() {
        BillDaoImplementM billDaoImplementM = new BillDaoImplementM();
        List <BillM> billMList = billDaoImplementM.printAllBillJDBC();
        return billMList;
    }
}
