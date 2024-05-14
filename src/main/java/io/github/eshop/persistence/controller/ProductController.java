package io.github.eshop.persistence.controller;

import io.github.eshop.domain.caseuse.CreateProductCaseUse;
import io.github.eshop.persistence.entity.ProductPersistence;
import io.github.eshop.persistence.mapper.ProductMapperPersistence;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
public class ProductController {
    private final CreateProductCaseUse createProductCaseUse;
    private final ProductMapperPersistence productMapper;

    public ProductController(CreateProductCaseUse createProductCaseUse, ProductMapperPersistence productMapper) {
        this.createProductCaseUse = createProductCaseUse;
        this.productMapper = productMapper;
    }

    @PostMapping("/create")
    public void createProduct(@RequestBody ProductPersistence productPersistence) {
        createProductCaseUse.createProduct(productMapper.fromPersistenceToDomain(productPersistence));
    }
}
