package Z_main;

import Z_model.BillM;
import Z_service.BillServiceImplementM;
import service.BillServiceImplement;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class MainBillM {
    public static void printMenu() {
        System.out.println();
        System.out.println("---- BILL MANAGEMENT ----");
        System.out.println("1. Create BILL");
        System.out.println("2. Find BILL by date");
        System.out.println("3. Print all BILL");
        System.out.println("0. Back MENU SHOP");
        System.out.println("-------------------------");
        System.out.print("Enter your select: ");
    }


    public void billManagementM() throws ParseException {

        while (true) {
            printMenu();
            int select = new Scanner(System.in).nextInt();
            switch (select) {
                case 1: {
                    System.out.println("1. Create BILL");
                    createBill();
                    break;
                }
                case 2: {
                    System.out.println("2. Find BILL by date");
                    findBillByDate();
                    break;
                }
                case 3: {
                    System.out.println("3. Print all BILL");
                    printAllBill();
                    break;
                }
                case 0: {
                    System.out.println("0. Back MENU SHOP");
                    return;
                }
                default: {
                    System.out.println("Invalid select. Please choose again");
                    break;
                }


            }
        }

    }

    private void printAllBill() {
        BillServiceImplementM billServiceImplementM = new BillServiceImplementM();
        List<BillM> billMList = billServiceImplementM.printAllBill();
        if (billMList.isEmpty()) {
            System.out.println("Bill empty.");
        } else {
            for (BillM billM : billMList) {
                billServiceImplementM.info(billM);
            }
        }
    }

    private void findBillByDate() throws ParseException {
        System.out.println("Enter date : yyyy-MM-dd ");
        String dateFromString = new Scanner(System.in).nextLine();
        String dateToString = new Scanner(System.in).nextLine();
        Date dateFrom = new SimpleDateFormat("yyyy-MM-dd").parse(dateFromString);
        Date dateTo = new SimpleDateFormat("yyyy-MM-dd").parse(dateToString);

        BillServiceImplementM billServiceImplement = new BillServiceImplementM();
        List<BillM> billMList = billServiceImplement.findBillByDate(dateFrom,dateTo);
        if (billMList.isEmpty()) {
            System.out.println("There are no bill in this time range");
        } else {
            for (BillM billM : billMList) {
                billServiceImplement.info(billM);
            }
        }
    }

    private void createBill() throws ParseException {
        BillM billM = new BillM();
        BillServiceImplementM billServiceImplementM = new BillServiceImplementM();
        billServiceImplementM.input(billM);
        billServiceImplementM.createBill(billM);
    }
}
