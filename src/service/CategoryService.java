package service;

import model.Category;

import java.util.List;

public interface CategoryService {
    public void input(Category category);

    public void info(Category category);

    public void createCategory(Category category);

    public void updateCategory(Category category);

    public void deleteCategory(int id);

    public Category findByIdCategory(int id);

    public List<Category> printAllCategory();
}
