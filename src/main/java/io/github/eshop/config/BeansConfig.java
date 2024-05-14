package io.github.eshop.config;

import io.github.eshop.data.repository.CategoryRepository;
import io.github.eshop.data.repository.ProductRepository;
import io.github.eshop.domain.caseuse.CreateCategoryCaseUse;
import io.github.eshop.domain.caseuse.CreateProductCaseUse;
import io.github.eshop.domain.caseuse.DeleteCategoryCaseUse;
import io.github.eshop.domain.caseuse.FindByCategoryNameCaseUse;
import io.github.eshop.domain.mapper.CategoryMapper;
import io.github.eshop.domain.mapper.ProductMapper;
import io.github.eshop.utils.Validator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeansConfig {
    private final CategoryMapper categoryMapper;

    public BeansConfig(CategoryMapper categoryMapper) {
        this.categoryMapper = categoryMapper;
    }

    @Bean
    public CreateCategoryCaseUse createCategoryCaseUse(CategoryRepository categoryRepository, CategoryMapper categoryMapper, Validator validator) {
        return new CreateCategoryCaseUse(categoryRepository, categoryMapper, validator);
    }

    @Bean
    public FindByCategoryNameCaseUse findByCategoryNameCaseUse(CategoryRepository categoryRepository, CategoryMapper categoryMapper, Validator validator) {
        return new FindByCategoryNameCaseUse(categoryRepository, categoryMapper, validator);
    }

    @Bean
    public DeleteCategoryCaseUse deleteCategoryCaseUse(FindByCategoryNameCaseUse findByCategoryNameCaseUse, CategoryRepository categoryRepository) {
        return new DeleteCategoryCaseUse(findByCategoryNameCaseUse, categoryRepository);
    }

    @Bean
    public CreateProductCaseUse createProductCaseUse(ProductRepository productRepository, ProductMapper productMapper, Validator validator) {
        return new CreateProductCaseUse(productRepository, productMapper, validator);
    }

}
