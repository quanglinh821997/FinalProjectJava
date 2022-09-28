package Z_main;

import main.MainBill;

import java.text.ParseException;
import java.util.Scanner;

public class MainShopM {
    public static void main(String[] args) throws ParseException {

        while (true) {
            printMenu();

            int select = new Scanner(System.in).nextInt();
            switch (select) {
                case 1 : {
                    System.out.println("1. CATEGORY MANAGEMENT");
                    MainCategoryM mainCategoryManagement = new MainCategoryM ();
                    mainCategoryManagement.categoryManagement();
                    break;
                }

                case 2 : {
                    System.out.println("2. PRODUCT MANAGEMENT");
                    MainProductM mainProductM = new MainProductM();
                    mainProductM.productManagement();
                    break;
                }

                case 3 : {
                    System.out.println("3. BILL MANAGEMENT");
                    MainBillM mainBillM = new MainBillM();
                    mainBillM.billManagementM();
                    break;
                }

                case 0 : {
                    System.out.println("0. Exit");
                    return;
                }

                default : {
                    System.out.println("Invalid select. Choose again");
                    break;
                }
            }

        }
    }

    private static void printMenu() {
        System.out.println();
        System.out.println("---- SHOP MANAGEMENT ----");
        System.out.println("1. CATEGORY MANAGEMENT");
        System.out.println("2. PRODUCT MANAGEMENT");
        System.out.println("3. BILL MANAGEMENT");
        System.out.println("0. Exit");
        System.out.println("-------------------------");
        System.out.print("Enter your select: ");
    }
}
