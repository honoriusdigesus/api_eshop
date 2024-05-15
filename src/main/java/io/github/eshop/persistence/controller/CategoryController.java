package io.github.eshop.persistence.controller;

import io.github.eshop.domain.caseuse.CreateCategoryCaseUse;
import io.github.eshop.domain.caseuse.DeleteCategoryCaseUse;
import io.github.eshop.domain.caseuse.FindByCategoryNameCaseUse;
import io.github.eshop.domain.caseuse.GetAllsCategoriesCaseUse;
import io.github.eshop.persistence.entity.CategoryPersistence;
import io.github.eshop.persistence.mapper.CategoryMapperPersistence;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/category")
public class CategoryController {
    private final CreateCategoryCaseUse createCategoryCaseUse;
    private final CategoryMapperPersistence categoryMapper;
    private final FindByCategoryNameCaseUse findByCategoryNameCaseUse;
    private final DeleteCategoryCaseUse deleteCategoryCaseUse;
    private final GetAllsCategoriesCaseUse getAllsCategoriesCaseUse;

    public CategoryController(CreateCategoryCaseUse createCategoryCaseUse, CategoryMapperPersistence categoryMapper, FindByCategoryNameCaseUse findByCategoryNameCaseUse, DeleteCategoryCaseUse deleteCategoryCaseUse, GetAllsCategoriesCaseUse getAllsCategoriesCaseUse) {
        this.createCategoryCaseUse = createCategoryCaseUse;
        this.categoryMapper = categoryMapper;
        this.findByCategoryNameCaseUse = findByCategoryNameCaseUse;
        this.deleteCategoryCaseUse = deleteCategoryCaseUse;
        this.getAllsCategoriesCaseUse = getAllsCategoriesCaseUse;
    }

    @PostMapping("/create")
    public void createCategory(@RequestBody CategoryPersistence categoryPersistence) {
        createCategoryCaseUse.createCategory(categoryMapper.fromPersistenceToDomain(categoryPersistence));
    }

    @GetMapping("/search/{categoryName}")
    public CategoryPersistence findByCategoryName(@PathVariable String categoryName) {
        return categoryMapper.fromDomainToPersistence(findByCategoryNameCaseUse.findByCategoryName(categoryName));
    }

    @DeleteMapping("/delete/{categoryName}")
    public void deleteCategory(@PathVariable String categoryName) {
        deleteCategoryCaseUse.deleteCategory(categoryName);
    }

    @GetMapping("/all")
    public List<CategoryPersistence> getAllCategories() {
        return getAllsCategoriesCaseUse.getAllCategories().stream()
                .map(categoryMapper::fromDomainToPersistence)
                .collect(Collectors.toList());
    }

}
