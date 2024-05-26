package io.github.eshop.domain.caseuse;

import io.github.eshop.data.repository.ProductRepository;
import io.github.eshop.domain.entity.ProductDomain;
import io.github.eshop.domain.mapper.ProductDomainMapper;
import io.github.eshop.utils.Validator;
import org.springframework.stereotype.Component;

@Component
public class UpdateProductCaseUse {
    private final ProductRepository productRepository;
    private final ProductDomainMapper productMapper;
    private final Validator validator;
    private final FindByNameProductCaseUse findByNameProductCaseUse;

    public UpdateProductCaseUse(ProductRepository productRepository, ProductDomainMapper productMapper, Validator validator, FindByNameProductCaseUse findByNameProductCaseUse) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
        this.validator = validator;
        this.findByNameProductCaseUse = findByNameProductCaseUse;
    }

    public void updateProduct(String nameProductToUpdate, ProductDomain productUpdate) {

        var productFound = findByNameProductCaseUse.findByProductName(nameProductToUpdate);
        if (validator.validateProduct(productUpdate) == false) {
            throw new RuntimeException("Product not valid");
        } else if (productFound != null) {
            productFound.setName(productUpdate.getName());
            productFound.setDescription(productUpdate.getDescription());
            productFound.setPrice(productUpdate.getPrice());
            productFound.setStock(productUpdate.getStock());
            productFound.setCategory(productUpdate.getCategory());
            productFound.setImage(productUpdate.getImage());
            productRepository.save(productMapper.fromDomainToEntity(productFound));
        } else {
            throw new RuntimeException("Product not found");
        }
    }
}
