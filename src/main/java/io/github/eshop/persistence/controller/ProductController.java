package io.github.eshop.persistence.controller;

import com.sun.jdi.PrimitiveValue;
import io.github.eshop.domain.caseuse.CreateProductCaseUse;
import io.github.eshop.domain.caseuse.FindByNameProductCaseUse;
import io.github.eshop.persistence.entity.ProductPersistence;
import io.github.eshop.persistence.mapper.ProductMapperPersistence;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
public class ProductController {
    private final CreateProductCaseUse createProductCaseUse;
    private final ProductMapperPersistence productMapper;
    private final FindByNameProductCaseUse findByNameProductCaseUse;

    public ProductController(CreateProductCaseUse createProductCaseUse, ProductMapperPersistence productMapper, FindByNameProductCaseUse findByNameProductCaseUse) {
        this.createProductCaseUse = createProductCaseUse;
        this.productMapper = productMapper;
        this.findByNameProductCaseUse = findByNameProductCaseUse;
    }

    @PostMapping("/create")
    public void createProduct(@RequestBody ProductPersistence productPersistence) {
        createProductCaseUse.createProduct(productMapper.fromPersistenceToDomain(productPersistence));
    }

    @GetMapping("/search/{name}")
    public ProductPersistence findByName(@PathVariable String name) {
        return productMapper.fromDomainToPersistence(findByNameProductCaseUse.findByName(name));
    }
}
