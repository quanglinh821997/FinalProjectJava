package Z_service;

import Z_dao.CategoryDaoImplementM;
import Z_model.CategoryM;
import dao.CategoryDaoImplement;

import java.util.List;
import java.util.Scanner;

public class CategoryServiceImplementM implements CategoryServiceM {

    @Override
    public void input(CategoryM category) {
        System.out.println("Enter idCategory : ");
        category.setIdCategory(new Scanner(System.in).nextInt());
        System.out.println("Enter nameCategory : ");
        category.setNameCategory(new Scanner(System.in).nextLine());
    }

    @Override
    public void info(CategoryM category) {
        System.out.printf("%-15d", category.getIdCategory());
        System.out.printf("%-15s", category.getNameCategory());
        System.out.println();
    }

    @Override
    public void createCategory(CategoryM category) {
        CategoryDaoImplementM categoryDaoImplementM = new CategoryDaoImplementM();
        categoryDaoImplementM.createCategoryJDBC(category);
    }


    @Override
    public void updateCategory(int idCategory, String nameCategory) {
        CategoryDaoImplementM categoryDaoImplementM = new CategoryDaoImplementM();
        categoryDaoImplementM.updateCategoryJDBC(idCategory,nameCategory);
    }

    @Override
    public void deleteCategory(int id) {
        CategoryDaoImplementM categoryDaoImplementM = new CategoryDaoImplementM();
        categoryDaoImplementM.deleteCategoryJDBC(id);
    }

    @Override
    public CategoryM findByIdCategory(int id) {
        CategoryDaoImplementM categoryDaoImplementM = new CategoryDaoImplementM();
        return categoryDaoImplementM.findByIDCategoryJDBC(id);
    }

    @Override
    public List<CategoryM> printAllCategory() {
        CategoryDaoImplementM categoryDaoImplement = new CategoryDaoImplementM();
        return categoryDaoImplement.printAllCategoryJDBC();
    }
}
