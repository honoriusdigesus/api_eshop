package io.github.eshop.persistence.mapper;

import io.github.eshop.domain.entity.CategoryDomain;
import io.github.eshop.persistence.entity.CategoryPersistence;
import org.springframework.stereotype.Component;

@Component
public class CategoryMapperPersistence {

        public CategoryDomain fromPersistenceToDomain(CategoryPersistence category) {
            return new CategoryDomain(category.getId(), category.getCategory(), category.getDescription());
        }

        public CategoryPersistence fromDomainToPersistence(CategoryDomain categoryDomain) {
            return new CategoryPersistence(categoryDomain.getId(), categoryDomain.getCategory(), categoryDomain.getDescription());
        }
}
