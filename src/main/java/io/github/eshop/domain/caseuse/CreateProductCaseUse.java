package io.github.eshop.domain.caseuse;

import io.github.eshop.data.repository.ProductRepository;
import io.github.eshop.domain.entity.ProductDomain;
import io.github.eshop.domain.exception.InvalidProductException;
import io.github.eshop.domain.mapper.CategoryMapper;
import io.github.eshop.domain.mapper.ProductMapper;
import io.github.eshop.utils.Validator;
import org.springframework.stereotype.Component;

@Component
public class CreateProductCaseUse {
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;
    private final Validator validator;


    public CreateProductCaseUse(ProductRepository productRepository, ProductMapper productMapper, Validator validator) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
        this.validator = validator;
    }

    public void createProduct(ProductDomain productDomain) {
        if (validator.validateProduct(productDomain).booleanValue() == false){
            throw new InvalidProductException("The product name must not be null or empty, nor must it be a number");
        }else{
            productDomain.setName(productDomain.getName().trim().toUpperCase());
            productDomain.setDescription(productDomain.getDescription().trim().toUpperCase());
            productDomain.setCategory(productDomain.getCategory());
            productRepository.save(productMapper.fromDomainToEntity(productDomain));
        }
    }
}
