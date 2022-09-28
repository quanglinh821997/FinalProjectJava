package main;

import model.Category;
import service.CategoryServiceImplement;

import java.util.List;
import java.util.Scanner;

public class MainCategory {
    public static void printMenu() {
        System.out.println();
        System.out.println("---- CATEGORY MANAGEMENT ----");
        System.out.println("1. Create CATEGORY");
        System.out.println("2. Update CATEGORY");
        System.out.println("3. Delete CATEGORY");
        System.out.println("4. Find CATEGORY by id");
        System.out.println("5. Print all CATEGORY");
        System.out.println("0. Back MENU SHOP");
        System.out.println("-------------------------------");
        System.out.print("Enter your select: ");
    }

    public static void printKhung() {
        System.out.printf("%-15s", "ID_CATEGORY");
        System.out.printf("%-15s", "NAME_CATEGORY");

        System.out.println();
        for (int i = 1; i <= 15; i++) {
            System.out.print("* ");
        }
        System.out.println();
    }

    public void categoryManagement() {
        while (true) {
            printMenu();

            int select = new Scanner(System.in).nextInt();

            switch (select) {
                case 1: {
                    createCategory();
                    break;
                }
                case 2: {
                    updateCategory();
                    break;
                }
                case 3: {
                    deleteCategory();
                    break;
                }
                case 4: {
                    findByIdCategory();
                    break;
                }
                case 5: {
                    printAllCategory();
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


    public static void createCategory() {
        Category category = new Category();

        CategoryServiceImplement categoryServiceImplement = new CategoryServiceImplement();
        categoryServiceImplement.input(category);

        categoryServiceImplement.createCategory(category);
    }

    public static void updateCategory() {
        Category category = new Category();

        CategoryServiceImplement categoryServiceImplement = new CategoryServiceImplement();
        categoryServiceImplement.input(category);

        categoryServiceImplement.updateCategory(category);
    }

    public static void deleteCategory() {
        System.out.print("Enter idCategory need delete: ");
        int id = new Scanner(System.in).nextInt();

        CategoryServiceImplement categoryServiceImplement = new CategoryServiceImplement();
        categoryServiceImplement.deleteCategory(id);
    }

    public static void findByIdCategory() {
        System.out.print("Enter idProduct need find: ");
        int id = new Scanner(System.in).nextInt();

        CategoryServiceImplement categoryServiceImplement = new CategoryServiceImplement();
        Category category = categoryServiceImplement.findByIdCategory(id);

        if (category == null) {
            System.out.println("idCategory is non-exsist.");
        } else {
            printKhung();
            categoryServiceImplement.info(category);
        }
    }

    public static void printAllCategory() {
        CategoryServiceImplement categoryServiceImplement = new CategoryServiceImplement();
        List<Category> categoryList = categoryServiceImplement.printAllCategory();

        if (categoryList.isEmpty()) {
            System.out.println("categoryList is empty.");
        } else {
            printKhung();
            for (Category category : categoryList) {
                categoryServiceImplement.info(category);
            }
        }
    }
}
