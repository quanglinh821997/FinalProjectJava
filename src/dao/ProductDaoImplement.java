package dao;

import model.Bill;
import model.Category;
import model.Product;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProductDaoImplement implements ProductDao {
    @Override
    public void createProductJDBC(Product product) {
        try {
            String sql = "INSERT INTO PRODUCT(id_product, name_product, quantity_product, price_product, id_of_category) VALUE (?, ?, ?, ?, ?)";
            JDBCConnection jdbcConnection = new JDBCConnection();
            PreparedStatement preparedStatement = jdbcConnection.getConnection().prepareStatement(sql);

            preparedStatement.setInt(1, product.getIdProduct());
            preparedStatement.setString(2, product.getNameProduct());
            preparedStatement.setInt(3, product.getQuantityProduct());
            preparedStatement.setInt(4, product.getPriceProduct());
            preparedStatement.setInt(5, product.getCategory().getIdCategory());

            preparedStatement.executeUpdate();
            System.out.println("Create PRODUCT success !");
        } catch (Exception e) {
            System.out.println("Create PRODUCT JDBC error: " + e);
        }
    }

    @Override
    public void updateProductJDBC(Product product) {
        try {
            String sql = "UPDATE PRODUCT SET name_product = ?, quantity_product = ?, price_product = ?, id_of_category = ? WHERE id_product = ?";
            JDBCConnection jdbcConnection = new JDBCConnection();
            PreparedStatement preparedStatement = jdbcConnection.getConnection().prepareStatement(sql);

            preparedStatement.setString(1, product.getNameProduct());
            preparedStatement.setInt(2, product.getQuantityProduct());
            preparedStatement.setInt(3, product.getPriceProduct());
            preparedStatement.setInt(4, product.getCategory().getIdCategory());
            preparedStatement.setInt(5, product.getIdProduct());

            preparedStatement.executeUpdate();
            System.out.println("Update PRODUCT success !");
        } catch (Exception e) {
            System.out.println("Update PRODUCT JDBC error: " + e);
        }
    }

    @Override
    public void deleteProductJDBC(int id) {
        try {
            String sql = "DELETE FROM PRODUCT WHERE id_product = ?";
            JDBCConnection jdbcConnection = new JDBCConnection();
            PreparedStatement preparedStatement = jdbcConnection.getConnection().prepareStatement(sql);

            preparedStatement.setInt(1, id);

            preparedStatement.executeUpdate();
            System.out.println("Delete PRODUCT success !");
        } catch (Exception e) {
            System.out.println("Delete PRODUCT JDBC error: " + e);
        }
    }

    @Override
    public Product findByIDProductJDBC(int id) {
        try {
            String sql = "SELECT id_product, name_product, quantity_product, price_product, id_of_category, name_category FROM PRODUCT INNER JOIN CATEGORY ON product.id_of_category = category.id_category WHERE id_product = ?;";
            JDBCConnection jdbcConnection = new JDBCConnection();
            PreparedStatement preparedStatement = jdbcConnection.getConnection().prepareStatement(sql);

            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int id_product_resultSet = resultSet.getInt("id_product");
                String name_product_resultSet = resultSet.getString("name_product");
                int quantity_product_resultSet = resultSet.getInt("quantity_product");
                int price_product_resultSet = resultSet.getInt("price_product");
                int id_of_category_resultSet = resultSet.getInt("id_of_category");
                String name_category_resultSet = resultSet.getString("name_category");

                Category category = new Category(id_of_category_resultSet, name_category_resultSet);

                Product product = new Product(id_product_resultSet, name_product_resultSet, quantity_product_resultSet, price_product_resultSet, category);

                return product;
            }
        } catch (Exception e) {
            System.out.println("Find by id PRODUCT JDBC error: " + e);
        }

        return null;
    }

    @Override
    public int getQuantityProductJDBC(int id) {
        try {
            String sql = "SELECT quantity_product FROM PRODUCT INNER JOIN CATEGORY ON product.id_of_category = category.id_category WHERE id_product = ?;";
            JDBCConnection jdbcConnection = new JDBCConnection();
            PreparedStatement preparedStatement = jdbcConnection.getConnection().prepareStatement(sql);

            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                return resultSet.getInt("quantity_product");
            }
        } catch (Exception e) {
            System.out.println("Get quantity of PRODUCT JDBC error: " + e);
        }

        return 0;
    }

    @Override
    public void updateQuantiTyProductJDBC(Bill bill) {
        try {
            String sql = "UPDATE PRODUCT SET quantity_product = ? WHERE id_product = ?; ;";
            JDBCConnection jdbcConnection = new JDBCConnection();
            PreparedStatement preparedStatement = jdbcConnection.getConnection().prepareStatement(sql);

            ProductDaoImplement productDaoImplement = new ProductDaoImplement();

            preparedStatement.setInt(1, productDaoImplement.getQuantityProductJDBC(bill.getProduct().getIdProduct()) - bill.getQuantityBill());
            preparedStatement.setInt(2, bill.getProduct().getIdProduct());

            preparedStatement.executeUpdate();
        } catch (Exception e) {
            System.out.println("Update quantity of PRODUCT JDBC error: " + e);
        }
    }

    @Override
    public int getPriceProductJDBC(int id) {
        try {
            String sql = "SELECT price_product FROM PRODUCT INNER JOIN CATEGORY ON product.id_of_category = category.id_category WHERE id_product = ?;";
            JDBCConnection jdbcConnection = new JDBCConnection();
            PreparedStatement preparedStatement = jdbcConnection.getConnection().prepareStatement(sql);

            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                return resultSet.getInt("price_product");
            }
        } catch (Exception e) {
            System.out.println("Get price of PRODUCT JDBC error: " + e);
        }

        return 0;
    }

    @Override
    public List<Product> findByNameProductJDBC(String name) {
        List<Product> productList = new ArrayList<Product>();

        try {
            String sql = "SELECT id_product, name_product, quantity_product, price_product, id_of_category, name_category FROM PRODUCT INNER JOIN CATEGORY ON product.id_of_category = category.id_category WHERE name_product LIKE ?";
            JDBCConnection jdbcConnection = new JDBCConnection();
            PreparedStatement preparedStatement = jdbcConnection.getConnection().prepareStatement(sql);

            preparedStatement.setString(1, "%" + name + "%");

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int id_product_resultSet = resultSet.getInt("id_product");
                String name_product_resultSet = resultSet.getString("name_product");
                int quantity_product_resultSet = resultSet.getInt("quantity_product");
                int price_product_resultSet = resultSet.getInt("price_product");
                int id_of_category_resultSet = resultSet.getInt("id_of_category");
                String name_category_resultSet = resultSet.getString("name_category");

                Category category = new Category(id_of_category_resultSet, name_category_resultSet);

                Product product = new Product(id_product_resultSet, name_product_resultSet, quantity_product_resultSet, price_product_resultSet, category);

                productList.add(product);
            }

            return productList;
        } catch (Exception e) {
            System.out.println("Find by name PRODUCT JDBC error: " + e);
        }

        return null;
    }

    @Override
    public List<Product> findByPriceProductJDBC(int priceLow, int priceHigh) {
        List<Product> productList = new ArrayList<Product>();

        try {
            String sql = "SELECT id_product, name_product, quantity_product, price_product, id_of_category, name_category FROM PRODUCT INNER JOIN CATEGORY ON product.id_of_category = category.id_category WHERE price_product BETWEEN ? AND ?";
            JDBCConnection jdbcConnection = new JDBCConnection();
            PreparedStatement preparedStatement = jdbcConnection.getConnection().prepareStatement(sql);

            preparedStatement.setInt(1, priceLow);
            preparedStatement.setInt(2, priceHigh);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int id_product_resultSet = resultSet.getInt("id_product");
                String name_product_resultSet = resultSet.getString("name_product");
                int quantity_product_resultSet = resultSet.getInt("quantity_product");
                int price_product_resultSet = resultSet.getInt("price_product");
                int id_of_category_resultSet = resultSet.getInt("id_of_category");
                String name_category_resultSet = resultSet.getString("name_category");

                Category category = new Category(id_of_category_resultSet, name_category_resultSet);

                Product product = new Product(id_product_resultSet, name_product_resultSet, quantity_product_resultSet, price_product_resultSet, category);

                productList.add(product);
            }

            return productList;
        } catch (Exception e) {
            System.out.println("Find by price PRODUCT JDBC error: " + e);
        }

        return null;
    }

    @Override
    public List<Product> findByNameCategoryJDBC(String name) {
        List<Product> productList = new ArrayList<Product>();

        try {
            String sql = "SELECT id_of_category, name_category, id_product, name_product, quantity_product, price_product FROM CATEGORY INNER JOIN PRODUCT ON id_category = id_of_category WHERE name_category LIKE ?;";
            JDBCConnection jdbcConnection = new JDBCConnection();
            PreparedStatement preparedStatement = jdbcConnection.getConnection().prepareStatement(sql);

            preparedStatement.setString(1, "%" + name + "%");

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int id_product_resultSet = resultSet.getInt("id_product");
                String name_product_resultSet = resultSet.getString("name_product");
                int quantity_product_resultSet = resultSet.getInt("quantity_product");
                int price_product_resultSet = resultSet.getInt("price_product");
                int id_of_category_resultSet = resultSet.getInt("id_of_category");
                String name_category_resultSet = resultSet.getString("name_category");

                Category category = new Category(id_of_category_resultSet, name_category_resultSet);

                Product product = new Product(id_product_resultSet, name_product_resultSet, quantity_product_resultSet, price_product_resultSet, category);

                productList.add(product);
            }

            return productList;
        } catch (Exception e) {
            System.out.println("Find PRODUCT by name of CATEGORY JDBC error: " + e);
        }

        return null;
    }

    @Override
    public List<Product> printAllProductJDBC() {
        List<Product> productList = new ArrayList<Product>();

        try {
            String sql = "SELECT id_product, name_product, quantity_product, price_product, id_of_category, name_category FROM PRODUCT INNER JOIN CATEGORY ON product.id_of_category = category.id_category";
            JDBCConnection jdbcConnection = new JDBCConnection();
            PreparedStatement preparedStatement = jdbcConnection.getConnection().prepareStatement(sql);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int id_product_resultSet = resultSet.getInt("id_product");
                String name_product_resultSet = resultSet.getString("name_product");
                int quantity_product_resultSet = resultSet.getInt("quantity_product");
                int price_product_resultSet = resultSet.getInt("price_product");
                int id_of_category_resultSet = resultSet.getInt("id_of_category");
                String name_category_resultSet = resultSet.getString("name_category");

                Category category = new Category(id_of_category_resultSet, name_category_resultSet);

                Product product = new Product(id_product_resultSet, name_product_resultSet, quantity_product_resultSet, price_product_resultSet, category);

                productList.add(product);
            }

            return productList;
        } catch (Exception e) {
            System.out.println("Print all PRODUCT error: " + e);
        }

        return null;
    }
}
