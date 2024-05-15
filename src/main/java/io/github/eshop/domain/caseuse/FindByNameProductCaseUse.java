package io.github.eshop.domain.caseuse;

import io.github.eshop.data.repository.ProductRepository;
import io.github.eshop.domain.entity.ProductDomain;
import io.github.eshop.domain.exception.InvalidProductNameException;
import io.github.eshop.domain.mapper.ProductMapper;
import io.github.eshop.utils.Validator;
import org.springframework.stereotype.Component;

@Component
public class FindByNameProductCaseUse {
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;
    private final Validator validator;

    public FindByNameProductCaseUse(ProductRepository productRepository, ProductMapper productMapper, Validator validator) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
        this.validator = validator;
    }

    public ProductDomain findByName(String name) {
        if (validator.validateNameProduct(name)) {
            new InvalidProductNameException("Invalid name");
        }
        return productMapper.fromEntityToDomain(productRepository.findByProductName(name));
    }
}
