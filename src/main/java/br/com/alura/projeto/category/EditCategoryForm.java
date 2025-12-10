package br.com.alura.projeto.category;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class EditCategoryForm {

    @NotBlank
    private String name;

    @NotBlank
    private String code;

    @NotBlank
    private String color;

    @NotNull
    private Integer order;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

    public EditCategoryForm() {}

    public EditCategoryForm(Category category) {
        this.name = category.getName();
        this.code = category.getCode();
        this.color = category.getColor();
        this.order = category.getOrder();
    }

    public void update(Category category) {
        category.setName(this.name);
        category.setCode(this.code);
        category.setColor(this.color);
        category.setOrder(this.order);
    }
}

