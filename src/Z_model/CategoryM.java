package Z_model;

public class CategoryM {
    private int idCategory;
    private String nameCategory;

    public CategoryM() {
    }

    public CategoryM(int idCategory) {
        this.idCategory = idCategory;
    }

    public CategoryM(int idCategory, String nameCategory) {
        this.idCategory = idCategory;
        this.nameCategory = nameCategory;
    }

    public int getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(int idCategory) {
        this.idCategory = idCategory;
    }

    public String getNameCategory() {
        return nameCategory;
    }

    public void setNameCategory(String nameCategory) {
        this.nameCategory = nameCategory;
    }
}
