package io.github.eshop.persistence.controller;

import io.github.eshop.domain.caseuse.CreateProductCaseUse;
import io.github.eshop.domain.caseuse.FindByNameProductCaseUse;
import io.github.eshop.domain.caseuse.GetAllProductsCaseUse;
import io.github.eshop.persistence.entity.ProductPersistence;
import io.github.eshop.persistence.mapper.ProductMapperPersistence;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/product")
public class ProductController {
    private final CreateProductCaseUse createProductCaseUse;
    private final ProductMapperPersistence productMapper;
    private final FindByNameProductCaseUse findByNameProductCaseUse;
    private final GetAllProductsCaseUse getAllProductsCaseUSe;

    public ProductController(CreateProductCaseUse createProductCaseUse, ProductMapperPersistence productMapper, FindByNameProductCaseUse findByNameProductCaseUse, GetAllProductsCaseUse getAllProductsCaseUSe) {
        this.createProductCaseUse = createProductCaseUse;
        this.productMapper = productMapper;
        this.findByNameProductCaseUse = findByNameProductCaseUse;
        this.getAllProductsCaseUSe = getAllProductsCaseUSe;
    }

    @PostMapping("/create")
    public void createProduct(@RequestBody ProductPersistence productPersistence) {
        createProductCaseUse.createProduct(productMapper.fromPersistenceToDomain(productPersistence));
    }

    @GetMapping("/search/{productName}")
    public ProductPersistence findByName(@PathVariable String productName) {
        return productMapper.fromDomainToPersistence(findByNameProductCaseUse.findByProductName(productName));
    }

    @GetMapping("/all")
    public List<ProductPersistence> getAllProducts() {
        return getAllProductsCaseUSe.getAllProducts().stream()
                .map(productMapper::fromDomainToPersistence)
                .collect(Collectors.toList());
    }

}
