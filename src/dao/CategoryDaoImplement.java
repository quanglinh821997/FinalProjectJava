package dao;

import model.Category;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CategoryDaoImplement implements CategoryDao {
    @Override
    public void createCategoryJDBC(Category category) {
        try {
            String sql = "INSERT INTO CATEGORY(id_category, name_category) VALUE (?, ?)";
            JDBCConnection jdbcConnection = new JDBCConnection();
            PreparedStatement preparedStatement = jdbcConnection.getConnection().prepareStatement(sql);

            preparedStatement.setInt(1, category.getIdCategory());
            preparedStatement.setString(2, category.getNameCategory());

            preparedStatement.executeUpdate();
            System.out.println("Create CATEGORY success !");
        } catch (Exception e) {
            System.out.println("Create CATEGORY JDBC error: " + e);
        }
    }

    @Override
    public void updateCategoryJDBC(Category category) {
        try {
            String sql = "UPDATE CATEGORY SET name_category = ? WHERE id_category = ?";
            JDBCConnection jdbcConnection = new JDBCConnection();
            PreparedStatement preparedStatement = jdbcConnection.getConnection().prepareStatement(sql);

            preparedStatement.setString(1, category.getNameCategory());
            preparedStatement.setInt(2, category.getIdCategory());

            preparedStatement.executeUpdate();
            System.out.println("Update CATEGORY success !");
        } catch (Exception e) {
            System.out.println("Update CATEGORY JDBC error: " + e);
        }
    }

    @Override
    public void deleteCategoryJDBC(int id) {
        try {
            String sql = "DELETE FROM CATEGORY WHERE id_category = ?";
            JDBCConnection jdbcConnection = new JDBCConnection();
            PreparedStatement preparedStatement = jdbcConnection.getConnection().prepareStatement(sql);

            preparedStatement.setInt(1, id);

            preparedStatement.executeUpdate();
            System.out.println("Delete CATEGORY success !");
        } catch (Exception e) {
            System.out.println("Delete CATEGORY JDBC error: " + e);
        }
    }

    @Override
    public Category findByIDCategoryJDBC(int id) {
        try {
            String sql = "SELECT * FROM CATEGORY WHERE id_category = ?";
            JDBCConnection jdbcConnection = new JDBCConnection();
            PreparedStatement preparedStatement = jdbcConnection.getConnection().prepareStatement(sql);

            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int id_category_resultSet = resultSet.getInt("id_category");
                String name_category_resultSet = resultSet.getString("name_category");

                Category category = new Category(id_category_resultSet, name_category_resultSet);

                return category;
            }
        } catch (Exception e) {
            System.out.println("Find by id CATEGORY JDBC error: " + e);
        }

        return null;
    }

    @Override
    public List<Category> printAllCategoryJDBC() {
        List<Category> categoryList = new ArrayList<Category>();

        try {
            String sql = "SELECT * FROM CATEGORY";
            JDBCConnection jdbcConnection = new JDBCConnection();
            PreparedStatement preparedStatement = jdbcConnection.getConnection().prepareStatement(sql);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int id_category_resultSet = resultSet.getInt("id_category");
                String name_category_resultSet = resultSet.getString("name_category");

                Category category = new Category(id_category_resultSet, name_category_resultSet);

                categoryList.add(category);
            }

            return categoryList;
        } catch (Exception e) {
            System.out.println("Print all CATEGORY JDBC error: " + e);
        }

        return null;
    }
}
