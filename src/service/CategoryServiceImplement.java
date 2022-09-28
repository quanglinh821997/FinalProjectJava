package service;

import dao.CategoryDaoImplement;
import model.Category;

import java.util.List;
import java.util.Scanner;

public class CategoryServiceImplement implements CategoryService {
    @Override
    public void input(Category category) {
        System.out.print("Enter idCategory: ");
        category.setIdCategory(new Scanner(System.in).nextInt());

        System.out.print("Enter nameCategory: ");
        category.setNameCategory(new Scanner(System.in).nextLine());
    }

    @Override
    public void info(Category category) {
        System.out.printf("%-15d", category.getIdCategory());
        System.out.printf("%-15s", category.getNameCategory());
        System.out.println();
    }

    @Override
    public void createCategory(Category category) {
        CategoryDaoImplement categoryDaoImplement = new CategoryDaoImplement();
        categoryDaoImplement.createCategoryJDBC(category);
    }

    @Override
    public void updateCategory(Category category) {
        CategoryDaoImplement categoryDaoImplement = new CategoryDaoImplement();
        categoryDaoImplement.updateCategoryJDBC(category);
    }

    @Override
    public void deleteCategory(int id) {
        CategoryDaoImplement categoryDaoImplement = new CategoryDaoImplement();
        categoryDaoImplement.deleteCategoryJDBC(id);
    }

    @Override
    public Category findByIdCategory(int id) {
        CategoryDaoImplement categoryDaoImplement = new CategoryDaoImplement();
        return categoryDaoImplement.findByIDCategoryJDBC(id);
    }

    @Override
    public List<Category> printAllCategory() {
        CategoryDaoImplement categoryDaoImplement = new CategoryDaoImplement();
        return categoryDaoImplement.printAllCategoryJDBC();
    }
}
