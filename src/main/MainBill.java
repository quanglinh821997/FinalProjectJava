package main;

import model.Bill;
import service.BillServiceImplement;

import java.text.ParseException;
import java.util.List;
import java.util.Scanner;

public class MainBill {
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

    public static void printKhung() {
        System.out.printf("%-20s", "ID_BILL");
        System.out.printf("%-20s", "NAME_PRODUCT");
        System.out.printf("%-20s", "PRICE_PRODUCT");
        System.out.printf("%-20s", "QUANTITY_BILL");
        System.out.printf("%-20s", "PRICE_BILL");
        System.out.printf("%-20s", "BUY_DATE_BILL");

        System.out.println();
        for (int i = 1; i <= 60; i++) {
            System.out.print("* ");
        }
        System.out.println();
    }

    public void billManagement() throws ParseException {
        while (true) {
            printMenu();

            int select = new Scanner(System.in).nextInt();

            switch (select) {
                case 1: {
                    create();
                    break;
                }
                case 2: {
                    findByDate();
                    break;
                }
                case 3: {
                    printAll();
                    break;
                }
                case 0: {
                    return;
                }
                default: {
                    System.out.println("Select invalid. Choose another select !");
                }
            }
        }
    }


    public static void create() throws ParseException {
        Bill bill = new Bill();

        BillServiceImplement billServiceImplement = new BillServiceImplement();
        billServiceImplement.input(bill);

        billServiceImplement.createBill(bill);
    }

    public static void findByDate() {
        System.out.print("Enter dateFrom(yyyy-MM-dd): ");
        String dateFrom = new Scanner(System.in).nextLine();

        System.out.print("Enter dateFrom(yyyy-MM-dd): ");
        String dateTo = new Scanner(System.in).nextLine();

        BillServiceImplement billServiceImplement = new BillServiceImplement();
        List<Bill> billList = billServiceImplement.findBillByDate(dateFrom, dateTo);

        if (billList.isEmpty()) {
            System.out.println("billListFindByDate is empty.");
        } else {
            printKhung();
            for (Bill bill : billList) {
                billServiceImplement.info(bill);
            }
        }
    }

    public static void printAll() {
        BillServiceImplement billServiceImplement = new BillServiceImplement();
        List<Bill> billList = billServiceImplement.printAllBill();

        if (billList.isEmpty()) {
            System.out.println("billList is empty.");
        } else {
            printKhung();
            for (Bill bill : billList) {
                billServiceImplement.info(bill);
            }
        }
    }
}
