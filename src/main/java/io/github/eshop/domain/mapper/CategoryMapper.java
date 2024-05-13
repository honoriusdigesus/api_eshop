package io.github.eshop.domain.mapper;

import io.github.eshop.data.entity.Category;
import io.github.eshop.domain.entity.CategoryDomain;
import org.springframework.stereotype.Component;

@Component
public class CategoryMapper {

    public CategoryDomain fromDataToDomain(Category category) {
        return new CategoryDomain(category.getId(), category.getCategory(), category.getDescription());
    }

    public Category fromDomainToData(CategoryDomain categoryDomain) {
        return new Category(categoryDomain.getId(), categoryDomain.getCategory(), categoryDomain.getDescription());
    }
}
