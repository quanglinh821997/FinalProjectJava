package Z_dao;

import Z_model.CategoryM;
import model.Category;

import java.util.List;

public interface CategoryDaoM {
    public void createCategoryJDBC(CategoryM category);

    public void updateCategoryJDBC(int id, String name);

    public void deleteCategoryJDBC(int id);

    public CategoryM findByIDCategoryJDBC(int id);

    public List<CategoryM> printAllCategoryJDBC();
}
