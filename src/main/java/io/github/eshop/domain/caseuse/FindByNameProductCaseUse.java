package io.github.eshop.domain.caseuse;

import io.github.eshop.data.repository.ProductRepository;
import io.github.eshop.domain.entity.ProductDomain;
import io.github.eshop.domain.exception.CategoryNotFoundException;
import io.github.eshop.domain.exception.InvalidCategoryException;
import io.github.eshop.domain.mapper.ProductDomainMapper;
import io.github.eshop.utils.Validator;
import org.springframework.stereotype.Component;

@Component
public class FindByNameProductCaseUse {
    private final ProductRepository productRepository;
    private final ProductDomainMapper productMapper;
    private final Validator validator;

    public FindByNameProductCaseUse(ProductRepository productRepository, ProductDomainMapper productMapper, Validator validator) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
        this.validator = validator;
    }

    public ProductDomain findByProductName(String name) {
        if (!validator.validateCategoryName(name)) {
            throw new InvalidCategoryException("The product name must not be null or empty, nor must it be a number");
        } else {
            var product = productRepository.findByProductName(name.trim().toUpperCase());
            if (product == null) {
                throw new CategoryNotFoundException("No category found with name: " + name);
            }
            return productMapper.fromEntityToDomain(product);
        }
    }
}
