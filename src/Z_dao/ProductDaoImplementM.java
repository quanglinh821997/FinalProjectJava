package Z_dao;

import Z_model.CategoryM;
import Z_model.ProductM;
import Z_service.CategoryServiceImplementM;
import dao.JDBCConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProductDaoImplementM implements ProductDaoM {
    @Override
    public void createProductJDBC(ProductM product) {
        String sql = "INSERT INTO FinalProject.Product VALUES ( ?,?,?,?,? )";
        JDBCConnectionM jdbcConnectionM = new JDBCConnectionM();

        try (PreparedStatement preparedStatement = jdbcConnectionM.getConnection().prepareStatement(sql)) {
            preparedStatement.setInt(1,product.getIdProduct());
            preparedStatement.setString(2,product.getNameProduct());
            preparedStatement.setInt(3,product.getQuantityProduct());
            preparedStatement.setInt(4,product.getPriceProduct());
            preparedStatement.setInt(5,product.getCategory().getIdCategory());

            int isUpdateSuccessful = preparedStatement.executeUpdate();
            if (isUpdateSuccessful>0) {
                System.out.println("Update product successful");
            } else {
                System.out.println("Update product unsuccessful");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updateProductJDBC(int idProduct) {
        String sql = "UPDATE FinalProject.Product SET idProduct = ?, nameProduct = ? " +
                ", quantityProduct = ?, priceProduct = ?, idCategory = ? " +
                "WHERE idProduct = ?";
        Scanner sc = new Scanner(System.in);
        JDBCConnectionM jdbcConnectionM = new JDBCConnectionM();
        try (PreparedStatement preparedStatement = jdbcConnectionM.getConnection().prepareStatement(sql)) {

            System.out.println("Enter new idProduct : ");
            int newIdProduct = Integer.parseInt(sc.nextLine());
            preparedStatement.setInt(1,newIdProduct);

            System.out.println("Enter new nameProduct : ");
            String newNameProduct = sc.nextLine();
            preparedStatement.setString(2,newNameProduct);

            System.out.println("Enter new quantityProduct : ");
            int newQuantityProduct = sc.nextInt();
            preparedStatement.setInt(3,newQuantityProduct);

            System.out.println("Enter new priceProduct : ");
            int newPriceProduct = sc.nextInt();
            preparedStatement.setInt(4,newPriceProduct);

            // Take a list of category, check Product's newIdCategory is match with id's category or not?
            CategoryDaoImplementM categoryDaoImplementM = new CategoryDaoImplementM();
            List<CategoryM> categoryMList = categoryDaoImplementM.printAllCategoryJDBC();
            boolean isIdCategoryValid = false;
            while (!isIdCategoryValid) {
                System.out.println("Enter new idCategory : ");
                int newIdCategory = sc.nextInt();
                for (CategoryM categoryM : categoryMList) {
                    if (newIdCategory == categoryM.getIdCategory()) {
                        isIdCategoryValid = true;
                        preparedStatement.setInt(5,newIdCategory);
                        break;
                    }
                }
            }

            preparedStatement.setInt(6,idProduct);

            int isUpdateSuccessful = preparedStatement.executeUpdate();
            if (isUpdateSuccessful>0) {
                System.out.println("Update product successful");
            } else {
                System.out.println("Update product unsuccessful");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void deleteProductJDBC(int id) {
        String sql = "DELETE FROM FinalProject.Product WHERE idProduct = "+id;
        JDBCConnectionM jdbcConnectionM = new JDBCConnectionM();
        try (PreparedStatement preparedStatement = jdbcConnectionM.getConnection().prepareStatement(sql)) {
            int isDeleteSuccessful = preparedStatement.executeUpdate();
            if (isDeleteSuccessful > 0) {
                System.out.println("Delete product successful");
            } else {
                System.out.println("Delete product unsuccessful");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public ProductM findByIDProductJDBC(int id) {
        String sql = "SELECT * FROM FinalProject.Product WHERE idProduct = "+id;
        JDBCConnectionM jdbcConnectionM = new JDBCConnectionM();
        try (PreparedStatement preparedStatement = jdbcConnectionM.getConnection().prepareStatement(sql)) {
            ResultSet resultSet = preparedStatement.executeQuery();

            CategoryServiceImplementM categoryServiceImplementM = new CategoryServiceImplementM();
            List<CategoryM> categoryMList = categoryServiceImplementM.printAllCategory();
            CategoryM categoryMOfProduct = new CategoryM();

            while (resultSet.next()) {

                // Find Product's category base idCategory field on table.
                for (CategoryM categoryM : categoryMList) {
                    if (categoryM.getIdCategory() == resultSet.getInt(5)) {
                        categoryMOfProduct = categoryM;
                        break;
                    }
                }

                ProductM productM = new ProductM(resultSet.getInt(1),resultSet.getString(2)
                    ,resultSet.getInt(3),resultSet.getInt(4),categoryMOfProduct);

                return productM;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public int getQuantityProductJDBC(int id) {
        return 0;
    }

//    @Override
//    public void updateQuantiTyProductJDBC(BillM bill) {
//
//    }

    @Override
    public int getPriceProductJDBC(int id) {
        return 0;
    }

    @Override
    public List<ProductM> findByNameProductJDBC(String name) {
        List<ProductM> productMList = new ArrayList<>();
        CategoryServiceImplementM categoryServiceImplementM = new CategoryServiceImplementM();

        String sql = "SELECT * FROM FinalProject.Product WHERE nameProduct = ?";
        JDBCConnectionM jdbcConnectionM = new JDBCConnectionM();
        try (PreparedStatement preparedStatement = jdbcConnectionM.getConnection().prepareStatement(sql)) {
            preparedStatement.setString(1,name);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {

                // Take category of Product base on idCategory field on table and findByIdCategory(int id) on
                // CategoryServiceImplementM class.
                CategoryM categoryMOfProduct = categoryServiceImplementM.findByIdCategory(resultSet.getInt(5));
                ProductM productM = new ProductM(resultSet.getInt(1),resultSet.getString(2),
                        resultSet.getInt(3),resultSet.getInt(4),categoryMOfProduct);
                productMList.add(productM);
            }
            return productMList;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<ProductM> findByPriceProductJDBC(int priceLow, int priceHigh) {
        List<ProductM> productMList = new ArrayList<>();
        String sql = "SELECT * FROM FinalProject.Product WHERE priceProduct >= ? AND priceProduct <= ?";
        JDBCConnectionM jdbcConnectionM = new JDBCConnectionM();
        try (PreparedStatement preparedStatement = jdbcConnectionM.getConnection().prepareStatement(sql)) {
            preparedStatement.setInt(1,priceLow);
            preparedStatement.setInt(2,priceHigh);
            ResultSet resultSet = preparedStatement.executeQuery();

            CategoryServiceImplementM categoryServiceImplementM = new CategoryServiceImplementM();
            while (resultSet.next()) {
                CategoryM categoryMOfProduct = categoryServiceImplementM.findByIdCategory(resultSet.getInt(5));
                ProductM productM = new ProductM(resultSet.getInt(1),resultSet.getString(2)
                ,resultSet.getInt(3),resultSet.getInt(4),categoryMOfProduct);
                productMList.add(productM);
            }
            return productMList;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public List<ProductM> findByNameCategoryJDBC(String name) {
        List<ProductM> productMList = new ArrayList<>();
        String sql = "SELECT * FROM FinalProject.Product";
        JDBCConnectionM jdbcConnectionM = new JDBCConnectionM();

        CategoryServiceImplementM categoryServiceImplementM = new CategoryServiceImplementM();
        try (PreparedStatement preparedStatement = jdbcConnectionM.getConnection().prepareStatement(sql)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                CategoryM categoryMOfProduct = categoryServiceImplementM.findByIdCategory(resultSet.getInt(5));
                ProductM productM = new ProductM(resultSet.getInt(1),resultSet.getString(2)
                ,resultSet.getInt(3),resultSet.getInt(4),categoryMOfProduct);
                if (categoryMOfProduct.getNameCategory().equals(name)) {
                    productMList.add(productM);
                }
            }
            return productMList;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public List<ProductM> printAllProductJDBC() {
        List <ProductM> productMList = new ArrayList<>();
        String sql = "SELECT * FROM FinalProject.Product";
        JDBCConnectionM jdbcConnectionM = new JDBCConnectionM();

        try (PreparedStatement preparedStatement = jdbcConnectionM.getConnection().prepareStatement(sql)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {

                // Take a list of category, then take Product's category base on idCategory on table.
                CategoryM categoryM = new CategoryM();
                CategoryServiceImplementM categoryServiceImplementM = new CategoryServiceImplementM();
                List<CategoryM> categoryMList = categoryServiceImplementM.printAllCategory();
                for (CategoryM categoryME : categoryMList) {
                    if (categoryME.getIdCategory() == resultSet.getInt(5)) {
                        categoryM = categoryME;
                        break;
                    }
                }

                ProductM productM = new ProductM(resultSet.getInt(1),resultSet.getString(2)
                    ,resultSet.getInt(3),resultSet.getInt(4),categoryM);
                productMList.add(productM);

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return productMList;
    }
}
