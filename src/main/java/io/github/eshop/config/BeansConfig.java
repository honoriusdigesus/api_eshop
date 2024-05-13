package io.github.eshop.config;

import io.github.eshop.data.repository.CategoryRepository;
import io.github.eshop.domain.caseuse.CreateCategoryCaseUse;
import io.github.eshop.domain.mapper.CategoryMapper;
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
}
