package io.github.eshop.domain.caseuse;

import io.github.eshop.data.repository.CategoryRepository;
import io.github.eshop.domain.entity.CategoryDomain;
import io.github.eshop.domain.mapper.CategoryDomainMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class GetAllsCategoriesCaseUse {
    private final CategoryRepository categoryRepository;
    private final CategoryDomainMapper categoryMapper;

    public GetAllsCategoriesCaseUse(CategoryRepository categoryRepository, CategoryDomainMapper categoryMapper) {
        this.categoryRepository = categoryRepository;
        this.categoryMapper = categoryMapper;
    }

    public List<CategoryDomain> getAllCategories() {
        return categoryRepository.findAll().stream()
                .map(categoryMapper::fromDataToDomain)
                .collect(Collectors.toList());
    }
}
