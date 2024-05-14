package io.github.eshop.domain.mapper;

import io.github.eshop.data.entity.Product;
import io.github.eshop.domain.entity.ProductDomain;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {
    public Product fromDomainToEntity(ProductDomain productDomain) {
        return new Product(
                productDomain.getId(),
                productDomain.getName(),
                productDomain.getDescription(),
                productDomain.getPrice(),
                productDomain.getStock(),
                productDomain.getImage(),
                productDomain.getCategory());
    }

    public ProductDomain fromEntityToDomain(Product product) {
        return new ProductDomain(
                product.getId(),
                product.getName(),
                product.getDescription(),
                product.getPrice(),
                product.getStock(),
                product.getImage(),
                product.getCategory());
    }
}
