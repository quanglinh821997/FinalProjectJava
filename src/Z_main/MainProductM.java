package Z_main;

import Z_model.ProductM;
import Z_service.ProductServiceImplementM;
import service.ProductServiceImplement;

import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class MainProductM {
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
        System.out.println("9. Print all PRODUCT in order Descending price");
        System.out.println("0. Back MENU SHOP");
        System.out.println("-------------------------------");
        System.out.print("Enter your select: ");
    }


    public void productManagement() {
        while (true) {
            printMenu();
            int select = new Scanner(System.in).nextInt();
            switch (select) {
                case 1: {
                    System.out.println("1. Create PRODUCT");
                    createProductM();
                    break;
                }
                case 2: {
                    System.out.println("2. Update PRODUCT");
                    updateProductM();
                    break;
                }
                case 3: {
                    System.out.println("3. Delete PRODUCT");
                    deleteProductM();
                    break;
                }
                case 4: {
                    System.out.println("4. Find PRODUCT by id");
                    findProductById();
                    break;
                }
                case 5: {
                    System.out.println("5. Find PRODUCT by name");
                    findProductByName();
                    break;
                }
                case 6: {
                    System.out.println("6. Find PRODUCT by price");
                    findProductByPrice();
                    break;
                }
                case 7: {
                    System.out.println("7. Find PRODUCT by nameCategory");
                    findProductByNameCategory();
                    break;
                }
                case 8: {
                    System.out.println("8. Print all PRODUCT");
                    printAllListProductM();
                    break;
                }
                case 9: {
                    System.out.println("9. Print all PRODUCT in order Descending price");
                    printAllListProductMDescPrice();
                    break;
                }
                case 0: {
                    System.out.println("0. Back MENU SHOP");
                    return;
                }
                default: {
                    System.out.println("Invalid value. Please choose again");
                    break;
                }


            }
        }
    }

    private void createProductM() {
        ProductM productM = new ProductM();
        ProductServiceImplementM productServiceImplementM = new ProductServiceImplementM();
        productServiceImplementM.input(productM);
        productServiceImplementM.createProduct(productM);
    }

    private void printAllListProductMDescPrice() {
        ProductServiceImplementM productServiceImplementM = new ProductServiceImplementM();
        List<ProductM> productMList = productServiceImplementM.printAllProduct();
        productMList.stream().sorted(Comparator.comparing(ProductM::getPriceProduct).reversed())
                .forEach(productServiceImplementM::info);
    }

    private void findProductByNameCategory() {
        System.out.println("Enter nameCategory : ");
        String nameCategory = new Scanner(System.in).nextLine();
        ProductServiceImplementM productServiceImplementM = new ProductServiceImplementM();
        List<ProductM> productMList = productServiceImplementM.findByNameCategory(nameCategory);
        if (productMList.isEmpty()) {
            System.out.println("There are no products with this Product's name Category");
        } else {
            for (ProductM productM : productMList) {
                productServiceImplementM.info(productM);
            }
        }
    }

    private void findProductByPrice() {
        System.out.println("Enter low price : ");
        int lowPriceProduct = new Scanner(System.in).nextInt();
        System.out.println("Enter high price : ");
        int highPriceProduct = new Scanner(System.in).nextInt();

        ProductServiceImplementM productServiceImplementM = new ProductServiceImplementM();
        List<ProductM> productMList = productServiceImplementM.findByPriceProduct(lowPriceProduct, highPriceProduct);
        if (productMList.isEmpty()) {
            System.out.println("There are no products in this price range");
        } else {
            for (ProductM productM : productMList) {
                productServiceImplementM.info(productM);
            }
        }
    }

    private void findProductByName() {

        System.out.println("Enter name want to find : ");
        String nameProduct = new Scanner(System.in).nextLine();
        ProductServiceImplementM productServiceImplementM = new ProductServiceImplementM();
        List<ProductM> productMLis = productServiceImplementM.findByNameProduct(nameProduct);

        if (productMLis.isEmpty()) {
            System.out.println("There are no product have this name.");
        } else {
            System.out.println("Some product is found");
            for (ProductM productM : productMLis) {
                productServiceImplementM.info(productM);
            }
        }
    }

    private void printAllListProductM() {
        ProductServiceImplementM productServiceImplementM = new ProductServiceImplementM();
        List<ProductM> productMList = productServiceImplementM.printAllProduct();
        if (productMList.isEmpty()) {
            System.out.println("Empty product list.");
        } else {
            for (ProductM productM : productMList) {
                productServiceImplementM.info(productM);
            }
        }
    }

    private void findProductById() {
        // Take a list of Product, check idProduct input exist or not?
        ProductServiceImplementM productServiceImplementM = new ProductServiceImplementM();
        List<ProductM> productMList = productServiceImplementM.printAllProduct();

        int idProduct = -1;
        boolean isValidIdProduct = false;
        while (!isValidIdProduct) {
            System.out.println("Enter idProduct need find : ");
            idProduct = new Scanner(System.in).nextInt();
            for (ProductM productM : productMList) {
                if (productM.getIdProduct() == idProduct) {
                    isValidIdProduct = true;
                    break;
                }
            }
        }

        ProductM productM = productServiceImplementM.findByIdProduct(idProduct);
        productServiceImplementM.info(productM);
    }

    private void deleteProductM() {
        // Take a list of Product, check idProduct input exist or not?
        ProductServiceImplementM productServiceImplementM = new ProductServiceImplementM();
        List<ProductM> productMList = productServiceImplementM.printAllProduct();

        int idProduct = -1;
        boolean isValidIdProduct = false;
        while (!isValidIdProduct) {
            System.out.println("Enter idProduct need delete : ");
            idProduct = new Scanner(System.in).nextInt();
            for (ProductM productM : productMList) {
                if (productM.getIdProduct() == idProduct) {
                    isValidIdProduct = true;
                    break;
                }
            }
        }

        productServiceImplementM.deleteProduct(idProduct);
    }

    private void updateProductM() {
        // Take a list of Product, check idProduct input exist or not?
        ProductServiceImplementM productServiceImplementM = new ProductServiceImplementM();
        List<ProductM> productMList = productServiceImplementM.printAllProduct();

        int idProduct = -1;
        boolean isValidIdProduct = false;
        while (!isValidIdProduct) {
            System.out.println("Enter idProduct need update : ");
            idProduct = new Scanner(System.in).nextInt();
            for (ProductM productM : productMList) {
                if (productM.getIdProduct() == idProduct) {
                    isValidIdProduct = true;
                    break;
                }
            }
        }

        productServiceImplementM.updateProduct(idProduct);
    }


}
