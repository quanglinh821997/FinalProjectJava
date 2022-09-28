package dao;

import model.Category;

import java.util.List;

public interface CategoryDao {
    public void createCategoryJDBC(Category category);

    public void updateCategoryJDBC(Category category);

    public void deleteCategoryJDBC(int id);

    public Category findByIDCategoryJDBC(int id);

    public List<Category> printAllCategoryJDBC();
}
