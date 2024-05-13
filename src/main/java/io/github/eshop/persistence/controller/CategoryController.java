package io.github.eshop.persistence.controller;

import io.github.eshop.domain.caseuse.CreateCategoryCaseUse;
import io.github.eshop.persistence.entity.CategoryPersistence;
import io.github.eshop.persistence.mapper.CategoryMapperPersistence;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/category")
public class CategoryController {
    private final CreateCategoryCaseUse createCategoryCaseUse;
    private final CategoryMapperPersistence categoryMapper;

    public CategoryController(CreateCategoryCaseUse createCategoryCaseUse, CategoryMapperPersistence categoryMapper) {
        this.createCategoryCaseUse = createCategoryCaseUse;
        this.categoryMapper = categoryMapper;
    }

    @PostMapping("/create")
    public void createCategory(@RequestBody CategoryPersistence categoryPersistence) {
        createCategoryCaseUse.createCategory(categoryMapper.fromPersistenceToDomain(categoryPersistence));
    }
}
