package io.github.eshop.persistence.mapper;

import io.github.eshop.domain.entity.ProductDomain;
import io.github.eshop.persistence.entity.ProductPersistence;
import org.springframework.stereotype.Component;

@Component
public class ProductPersistenceMapper {
    public ProductPersistence fromDomainToPersistence(ProductDomain productDomain) {
        return new ProductPersistence(
                productDomain.getId(),
                productDomain.getName(),
                productDomain.getDescription(),
                productDomain.getPrice(),
                productDomain.getStock(),
                productDomain.getImage(),
                productDomain.getCategory());
    }

    public ProductDomain fromPersistenceToDomain(ProductPersistence productPersistence) {
        return new ProductDomain(
                productPersistence.getId(),
                productPersistence.getName(),
                productPersistence.getDescription(),
                productPersistence.getPrice(),
                productPersistence.getStock(),
                productPersistence.getImage(),
                productPersistence.getCategory());
    }
}
