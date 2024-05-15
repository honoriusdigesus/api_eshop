package io.github.eshop.domain.caseuse;

import io.github.eshop.data.repository.ProductRepository;
import io.github.eshop.domain.entity.ProductDomain;
import io.github.eshop.domain.mapper.ProductMapper;
import io.github.eshop.utils.Validator;
import org.springframework.stereotype.Component;

@Component
public class DeleteProductCaseUse {
    private final FindByNameProductCaseUse findByNameProductCaseUse;
    private final ProductMapper productMapper;
    private final Validator validator;
    private final ProductRepository productRepository;

    public DeleteProductCaseUse(FindByNameProductCaseUse findByNameProductCaseUse, ProductMapper productMapper, Validator validator, ProductRepository productRepository) {
        this.findByNameProductCaseUse = findByNameProductCaseUse;
        this.productMapper = productMapper;
        this.validator = validator;
        this.productRepository = productRepository;
    }

    public void deleteProduct(String productName) {

        ProductDomain productFound = findByNameProductCaseUse.findByProductName(productName);
        if (validator.validateProduct(productFound) == false || validator.validateNameProduct(productName) == false) {
            throw new RuntimeException("Check the product name");
        } else if (productFound != null) {
            productRepository.delete(productMapper.fromDomainToEntity(productFound));
        }
    }
}
