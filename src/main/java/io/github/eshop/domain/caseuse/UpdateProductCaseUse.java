package io.github.eshop.domain.caseuse;

import io.github.eshop.data.repository.ProductRepository;
import io.github.eshop.domain.entity.ProductDomain;
import io.github.eshop.domain.mapper.ProductMapper;
import io.github.eshop.utils.Validator;
import org.springframework.stereotype.Component;

@Component
public class UpdateProductCaseUse {
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;
    private final Validator validator;

    public UpdateProductCaseUse(ProductRepository productRepository, ProductMapper productMapper, Validator validator) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
        this.validator = validator;
    }

    public void updateProduct(String nameProductToUpdate, ProductDomain productUpdate) {

        var productFound = productRepository.findByProductName(nameProductToUpdate);
        if (validator.validateProduct(productUpdate) == false) {
            throw new RuntimeException("Product not valid");
        } else if (productFound != null) {
            productFound.setName(productUpdate.getName());
            productFound.setDescription(productUpdate.getDescription());
            productFound.setPrice(productUpdate.getPrice());
            productFound.setStock(productUpdate.getStock());
            productFound.setCategory(productUpdate.getCategory());
            productFound.setImage(productUpdate.getImage());
            productRepository.save(productFound);
        } else {
            throw new RuntimeException("Product not found");
        }
    }
}
