package Z_dao;

import Z_model.CategoryM;
import dao.CategoryDao;
import dao.JDBCConnection;
import model.Category;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CategoryDaoImplementM implements CategoryDaoM {

    @Override
    public void createCategoryJDBC(CategoryM category) {
        String sql = "INSERT INTO FinalProject.Category() VALUES (?,?)";
        JDBCConnectionM jdbcConnection = new JDBCConnectionM();
        try (PreparedStatement preparedStatement = jdbcConnection.getConnection().prepareStatement(sql)) {
            preparedStatement.setInt(1, category.getIdCategory());
            preparedStatement.setString(2, category.getNameCategory());
            int isCreateSuccessful = preparedStatement.executeUpdate();
            if (isCreateSuccessful > 0) {
                System.out.println("Create new category successful");
            } else {
                System.out.println("Create new category unsuccessful");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updateCategoryJDBC(int idCategory, String nameCategory) {
        String sql = "UPDATE FinalProject.category SET nameCategory = ? WHERE idCategory = ?";
        JDBCConnectionM jdbcConnectionM = new JDBCConnectionM();
        try (PreparedStatement preparedStatement = jdbcConnectionM.getConnection().prepareStatement(sql)) {
            preparedStatement.setString(1, nameCategory);
            preparedStatement.setInt(2, idCategory);
            int updatedSuccessful = preparedStatement.executeUpdate();
            if (updatedSuccessful > 0) {
                System.out.println("Update category successful");
            } else {
                System.out.println("Update category unsuccessful");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteCategoryJDBC(int id) {
        String sql = "DELETE FROM  FinalProject.category WHERE idCategory = ?";
        JDBCConnectionM jdbcConnection = new JDBCConnectionM();
        try (PreparedStatement preparedStatement = jdbcConnection.getConnection().prepareStatement(sql)) {
            preparedStatement.setInt(1, id);
            int isDeleteSuccessful = preparedStatement.executeUpdate();
            if (isDeleteSuccessful > 0) {
                System.out.println("Delete category successful");
            } else {
                System.out.println("Delete category unsuccessful");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public CategoryM findByIDCategoryJDBC(int id) {
        CategoryM categoryM = new CategoryM();
        String sql = "SELECT * FROM FinalProject.category WHERE idCategory = ? ";
        JDBCConnectionM jdbcConnectionM = new JDBCConnectionM();
        try (PreparedStatement preparedStatement = jdbcConnectionM.getConnection().prepareStatement(sql)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                categoryM.setIdCategory(resultSet.getInt(1));
                categoryM.setNameCategory(resultSet.getString(2));
            }
            return categoryM;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<CategoryM> printAllCategoryJDBC() {
        List<CategoryM> list = new ArrayList<>();

        String sql = "SELECT * FROM FinalProject.category";
        JDBCConnectionM jdbcConnectionM = new JDBCConnectionM();
        try (PreparedStatement preparedStatement = jdbcConnectionM.getConnection().prepareStatement(sql)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                CategoryM categoryM = new CategoryM(resultSet.getInt(1),resultSet.getString(2));
                list.add(categoryM);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return list;
    }
}
