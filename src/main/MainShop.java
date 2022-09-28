package main;

import Z_main.MainCategoryM;

import java.text.ParseException;
import java.util.Scanner;

public class MainShop {
    public static void printMenu() {
        System.out.println();
        System.out.println("---- SHOP MANAGEMENT ----");
        System.out.println("1. CATEGORY MANAGEMENT");
        System.out.println("2. PRODUCT MANAGEMENT");
        System.out.println("3. BILL MANAGEMENT");
        System.out.println("0. Exit");
        System.out.println("-------------------------");
        System.out.print("Enter your select: ");
    }

    public static void main(String[] args) throws ParseException {
        while (true) {
            printMenu();

            int select = new Scanner(System.in).nextInt();

            switch (select) {
                case 1: {
                    MainCategoryM mainCategory = new MainCategoryM();
                    mainCategory.categoryManagement();
                    break;
                }
                case 2: {
                    MainProduct mainProduct = new MainProduct();
                    mainProduct.productManagement();
                    break;
                }
                case 3: {
                    MainBill mainBill = new MainBill();
                    mainBill.billManagement();
                    break;
                }
                case 0: {
                    System.out.println("Thanks for using !!");
                    return;
                }
                default: {
                    System.out.println("Select invalid. Choose another select !");
                }
            }
        }
    }
}
