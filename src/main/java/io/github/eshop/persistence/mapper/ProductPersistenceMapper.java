package io.github.eshop.persistence.mapper;

import io.github.eshop.domain.entity.ProductDomain;
import io.github.eshop.persistence.entity.ProductPersistence;
import org.springframework.stereotype.Component;

@Component
public class ProductPersistenceMapper {
    public ProductPersistence fromDomainToPersistence(ProductDomain productDomain) {
//        return new ProductPersistence(
//                productDomain.getId(),
//                productDomain.getName(),
//                productDomain.getDescription(),
//                productDomain.getPrice(),
//                productDomain.getStock(),
//                productDomain.getImage(),
//                productDomain.getCategory());
        ProductPersistence productPersistence = new ProductPersistence();
        productPersistence.setId(productDomain.getId());
        productPersistence.setName(productDomain.getName());
        productPersistence.setDescription(productDomain.getDescription());
        productPersistence.setPrice(productDomain.getPrice());
        productPersistence.setStock(productDomain.getStock());
        productPersistence.setImage(productDomain.getImage());
        productPersistence.setCategory(productDomain.getCategory());
        return productPersistence;
    }

    public ProductDomain fromPersistenceToDomain(ProductPersistence productPersistence) {
        System.out.println(productPersistence + "***********************************************");
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
