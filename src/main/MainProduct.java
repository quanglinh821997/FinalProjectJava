package main;

import model.Product;
import service.ProductServiceImplement;

import java.util.List;
import java.util.Scanner;

public class MainProduct {
    public static void printMenu() {
        System.out.println();
        System.out.println("---- PRODUCT MANAGEMENT ----");
        System.out.println("1. Create PRODUCT");
        System.out.println("2. Update PRODUCT");
        System.out.println("3. Delete PRODUCT");
        System.out.println("4. Find PRODUCT by id");
        System.out.println("5. Find PRODUCT by name");
        System.out.println("6. Find PRODUCT by price");
        System.out.println("7. Find PRODUCT by nameCategory");
        System.out.println("8. Print all PRODUCT");
        System.out.println("0. Back MENU SHOP");
        System.out.println("-------------------------------");
        System.out.print("Enter your select: ");
    }

    public static void printKhung() {
        System.out.printf("%-15s", "ID");
        System.out.printf("%-15s", "NAME");
        System.out.printf("%-15s", "QUANTITY");
        System.out.printf("%-15s", "PRICE");
        System.out.printf("%-15s", "ID_CATEGORY");
        System.out.printf("%-15s", "NAME_CATEGORY");

        System.out.println();
        for (int i = 1; i <= 45; i++) {
            System.out.print("* ");
        }
        System.out.println();
    }

    public void productManagement() {
        while (true) {
            printMenu();

            int select = new Scanner(System.in).nextInt();

            switch (select) {
                case 1: {
                    createProduct();
                    break;
                }
                case 2: {
                    updateProduct();
                    break;
                }
                case 3: {
                    deleteProduct();
                    break;
                }
                case 4: {
                    findByIdProduct();
                    break;
                }
                case 5: {
                    findByNameProduct();
                    break;
                }
                case 6: {
                    findByPriceProduct();
                    break;
                }
                case 7: {
                    findByNameCategory();
                    break;
                }
                case 8: {
                    printAllProduct();
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

    public static void createProduct() {
        Product product = new Product();

        ProductServiceImplement productServiceImplement = new ProductServiceImplement();
        productServiceImplement.input(product);

        productServiceImplement.createProduct(product);
    }

    public static void updateProduct() {
        Product product = new Product();

        ProductServiceImplement productServiceImplement = new ProductServiceImplement();
        productServiceImplement.input(product);

        productServiceImplement.updateProduct(product);
    }

    public static void deleteProduct() {
        System.out.print("Enter idProduct need delete: ");
        int id = new Scanner(System.in).nextInt();

        ProductServiceImplement productServiceImplement = new ProductServiceImplement();

        productServiceImplement.deleteProduct(id);
    }

    public static void findByIdProduct() {
        System.out.print("Enter idProduct need find: ");
        int id = new Scanner(System.in).nextInt();

        ProductServiceImplement productServiceImplement = new ProductServiceImplement();
        Product product = productServiceImplement.findByIdProduct(id);

        if (product == null) {
            System.out.println("idProduct is non-exsist.");
        } else {
            printKhung();
            productServiceImplement.info(product);
        }
    }

    public static void findByNameProduct() {
        System.out.print("Enter nameProduct need find: ");
        String name = new Scanner(System.in).nextLine();

        ProductServiceImplement productServiceImplement = new ProductServiceImplement();
        List<Product> productList = productServiceImplement.findByNameProduct(name);

        if (productList.isEmpty()) {
            System.out.println("listProductFindByNameProduct is empty.");
        } else {
            printKhung();
            for (Product product : productList) {
                productServiceImplement.info(product);
            }
        }
    }

    public static void findByPriceProduct() {
        System.out.print("Enter priceLow: ");
        int priceLow = new Scanner(System.in).nextInt();

        System.out.print("Enter priceHigh: ");
        int priceHigh = new Scanner(System.in).nextInt();

        ProductServiceImplement productServiceImplement = new ProductServiceImplement();
        List<Product> productList = productServiceImplement.findByPriceProduct(priceLow, priceHigh);

        if (productList.isEmpty()) {
            System.out.println("listFindByPriceProduct is empty.");
        } else {
            printKhung();
            for (Product product : productList) {
                productServiceImplement.info(product);
            }
        }
    }

    public static void findByNameCategory() {
        System.out.print("Enter nameCategory need find: ");
        String name = new Scanner(System.in).nextLine();

        ProductServiceImplement productServiceImplement = new ProductServiceImplement();
        List<Product> productList = productServiceImplement.findByNameCategory(name);

        if (productList.isEmpty()) {
            System.out.println("listProductFindByNameCategory is empty.");
        } else {
            printKhung();
            for (Product product : productList) {
                productServiceImplement.info(product);
            }
        }
    }

    public static void printAllProduct() {
        ProductServiceImplement productServiceImplement = new ProductServiceImplement();
        List<Product> productList = productServiceImplement.printAllProduct();

        if (productList.isEmpty()) {
            System.out.println("listProduct is empty.");
        } else {
            printKhung();
            for (Product product : productList) {
                productServiceImplement.info(product);
            }
        }
    }
}
