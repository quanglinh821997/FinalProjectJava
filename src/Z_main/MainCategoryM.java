package Z_main;

import Z_dao.CategoryDaoImplementM;
import Z_model.CategoryM;
import Z_service.CategoryServiceImplementM;
import Z_service.CategoryServiceM;
import model.Category;
import service.CategoryService;

import java.util.List;
import java.util.Scanner;

public class MainCategoryM {

    public void categoryManagement() {
        while (true) {
            printMenu();
            int select = new Scanner(System.in).nextInt();

            switch (select) {
                case 1 : {
                    System.out.println("1. Create CATEGORY");
                    createCategory();
                    break;
                }

                case 2 : {
                    System.out.println("2. Update CATEGORY");
                    updateCategoryM();
                    break;
                }

                case 3 : {
                    System.out.println("3. Delete CATEGORY");
                    deleteCategoryM();
                    break;
                }

                case 4 : {
                    System.out.println("4. Find CATEGORY by id");
                    findCategoryM();
                    break;
                }

                case 5 : {
                    System.out.println("5. Print all CATEGORY");
                    printFieldName();
                    printAllCategoryM();
                    break;
                }

                case 0 : {
                    System.out.println("0. Back MENU SHOP");
                    return;
                }

                default : {
                    System.out.println("Invalid select. Choose again");
                    break;
                }
            }
        }
    }

    private void printFieldName() {
        System.out.printf("%s%15s","idCategory","nameCategory");
        System.out.println();
    }

    private void printAllCategoryM() {
        CategoryServiceImplementM categoryServiceImplementM = new CategoryServiceImplementM();
        List<CategoryM> categoryMList = categoryServiceImplementM.printAllCategory();
        if (categoryMList == null) {
            System.out.println("Empty table.");
        } else {
            for (CategoryM categoryM : categoryMList) {
                categoryServiceImplementM.info(categoryM);
            }
        }
    }

    private void findCategoryM() {
        System.out.println("Enter the idCategory");
        int idCategory = new Scanner(System.in).nextInt();

        CategoryDaoImplementM categoryDaoImplementM = new CategoryDaoImplementM();
        CategoryM categoryM = categoryDaoImplementM.findByIDCategoryJDBC(idCategory);
        if (categoryM == null) {
            System.out.println("Category table empty");
        } else {
            CategoryServiceImplementM categoryServiceM = new CategoryServiceImplementM();
            categoryServiceM.info(categoryM);
        }

    }

    private void deleteCategoryM() {
        System.out.println("Enter the idCategory : ");
        int idCategory = new Scanner(System.in).nextInt();
        
        CategoryDaoImplementM categoryDaoImplementM = new CategoryDaoImplementM();
        categoryDaoImplementM.deleteCategoryJDBC(idCategory);
    }

    private void updateCategoryM() {
        System.out.println("Enter the idCategory : ");
        int idCategory = new Scanner(System.in).nextInt();

        System.out.println("Enter the new nameCategory : ");
        String nameCategory = new Scanner(System.in).nextLine();
        
        CategoryDaoImplementM categoryDaoImplementM = new CategoryDaoImplementM();
        categoryDaoImplementM.updateCategoryJDBC(idCategory,nameCategory);
    }


    private void createCategory() {
        CategoryM categoryM = new CategoryM();
        CategoryServiceImplementM categoryServiceImplementM = new CategoryServiceImplementM();
        categoryServiceImplementM.input(categoryM);
        categoryServiceImplementM.createCategory(categoryM);
    }

    private void printMenu() {
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
}
