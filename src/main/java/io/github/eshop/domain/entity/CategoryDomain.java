package io.github.eshop.domain.entity;

public class CategoryDomain {

    private Integer id;


    private String category;
    private String description;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public CategoryDomain() {
    }

    public CategoryDomain(Integer id, String category, String description) {
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
