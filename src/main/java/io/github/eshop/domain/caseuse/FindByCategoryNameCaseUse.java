package io.github.eshop.domain.caseuse;

import io.github.eshop.data.repository.CategoryRepository;
import io.github.eshop.domain.entity.CategoryDomain;
import io.github.eshop.domain.exception.CategoryNotFoundException;
import io.github.eshop.domain.exception.InvalidCategoryException;
import io.github.eshop.domain.mapper.CategoryMapper;
import io.github.eshop.utils.Validator;
import org.springframework.stereotype.Component;

@Component
public class FindByCategoryNameCaseUse {
    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;
    private final Validator validator;

    public FindByCategoryNameCaseUse(CategoryRepository categoryRepository, CategoryMapper categoryMapper, Validator validator) {
        this.categoryRepository = categoryRepository;
        this.categoryMapper = categoryMapper;
        this.validator = validator;
    }

    public CategoryDomain findByCategoryName(String categoryName) {
        if (!validator.validateCategoryName(categoryName)) {
            throw new InvalidCategoryException("The category name must not be null or empty, nor must it be a number");
        } else {
            var categoryData = categoryRepository.findByCategoryName(categoryName.trim().toUpperCase());
            if (categoryData == null) {
                throw new CategoryNotFoundException("No category found with name: " + categoryName);
            }
            return categoryMapper.fromDataToDomain(categoryData);
        }
    }
}
