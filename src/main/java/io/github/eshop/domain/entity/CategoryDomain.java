package io.github.eshop.domain.entity;

import io.github.eshop.enums.Categories;
import org.antlr.v4.runtime.misc.NotNull;
import org.hibernate.annotations.JdbcTypeCode;

import java.sql.Types;


public class CategoryDomain {

    private Integer id;


    private Categories category;
    private String description;

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

    public CategoryDomain() {
    }

    public CategoryDomain(Integer id, Categories category, String description) {
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
