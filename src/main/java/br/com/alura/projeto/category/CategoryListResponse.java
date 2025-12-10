package br.com.alura.projeto.category;

public class CategoryListResponse {
    private String categoryName;
    private String categoryCourses;
    private String categoryColor;
    private String categoryCode;

    public CategoryListResponse() {
    }

    public CategoryListResponse(String categoryName, String categoryCourses, String categoryColor, String categoryCode) {
        this.categoryName = categoryName;
        this.categoryCourses = categoryCourses;
        this.categoryColor = categoryColor;
        this.categoryCode = categoryCode;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategoryCourses() {
        return categoryCourses;
    }

    public void setCategoryCourses(String categoryCourses) {
        this.categoryCourses = categoryCourses;
    }

    public String getCategoryColor() {
        return categoryColor;
    }

    public void setCategoryColor(String categoryColor) {
        this.categoryColor = categoryColor;
    }

    public String getCategoryCode() {
        return categoryCode;
    }

    public void setCategoryCode(String categoryCode) {
        this.categoryCode = categoryCode;
    }
}
