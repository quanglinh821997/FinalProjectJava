package Z_service;

import Z_model.CategoryM;
import model.Category;

import java.util.List;

public interface CategoryServiceM {
    public void input(CategoryM category);

    public void info(CategoryM category);

    public void createCategory(CategoryM category);

    public void updateCategory(int id, String name);

    public void deleteCategory(int id);

    public CategoryM findByIdCategory(int id);

    public List<CategoryM> printAllCategory();
}
