package io.github.eshop.persistence.entity;

import io.github.eshop.enums.Categories;


public class CategoryPersistence {

    private Integer id;
    private Categories category;
    private String description = "Sin descripción";

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Categories getCategory() {
        return category;
    }

    public void setCategory(Categories category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public CategoryPersistence() {
        description = "Sin descripción";
    }

    public CategoryPersistence(Integer id, Categories category, String description) {
        this.id = id;
        this.category = category;
        this.description = description;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", category=" + category +
                ", description='" + description + '\'' +
                '}';
    }
}
