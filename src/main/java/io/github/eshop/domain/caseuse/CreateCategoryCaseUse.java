package io.github.eshop.domain.caseuse;

import io.github.eshop.data.repository.CategoryRepository;
import io.github.eshop.domain.entity.CategoryDomain;
import io.github.eshop.domain.exception.InvalidCategoryException;
import io.github.eshop.domain.mapper.CategoryMapper;
import io.github.eshop.utils.Validator;
import org.springframework.stereotype.Component;

@Component
public class CreateCategoryCaseUse {
    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;
    private final Validator validator;

    public CreateCategoryCaseUse(CategoryRepository categoryRepository, CategoryMapper categoryMapper, Validator validator) {
        this.categoryRepository = categoryRepository;
        this.categoryMapper = categoryMapper;
        this.validator = validator;
    }

    public void createCategory(CategoryDomain categoryDomain) {
        if (validator.validateCategoryName(categoryDomain.getCategory()).booleanValue() == false){
            throw new InvalidCategoryException("The category name must not be null or empty, nor must it be a number");
        }else{
            categoryDomain.setCategory(categoryDomain.getCategory().trim().toUpperCase());
            categoryDomain.setDescription(categoryDomain.getDescription().trim().toUpperCase());
            categoryRepository.save(categoryMapper.fromDomainToData(categoryDomain));
        }
    }
}
