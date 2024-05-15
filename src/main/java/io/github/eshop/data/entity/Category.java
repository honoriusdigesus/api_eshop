package io.github.eshop.data.entity;

import jakarta.persistence.*;
import org.antlr.v4.runtime.misc.NotNull;

@Entity
@Table(name = "category")
public class Category {
    @Id
    @GeneratedValue
    private Integer id;

    @NotNull
    @Column(unique = true)
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

    public Category() {
        description = "SIN DESCRIPCIÓN";
    }

    public Category(Integer id, String category, String description) {
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
