package io.github.eshop.domain.caseuse;

import io.github.eshop.data.repository.CategoryRepository;
import io.github.eshop.domain.entity.CategoryDomain;
import org.springframework.stereotype.Component;

@Component
public class DeleteCategoryCaseUse {
    private final FindByCategoryNameCaseUse findByCategoryNameCaseUse;
    private final CategoryRepository categoryRepository;

    public DeleteCategoryCaseUse(FindByCategoryNameCaseUse findByCategoryNameCaseUse, CategoryRepository categoryRepository) {
        this.findByCategoryNameCaseUse = findByCategoryNameCaseUse;
        this.categoryRepository = categoryRepository;
    }

    public void deleteCategory(String categoryName) {
        CategoryDomain category = findByCategoryNameCaseUse.findByCategoryName(categoryName);
        categoryRepository.deleteById(category.getId());
    }
}
