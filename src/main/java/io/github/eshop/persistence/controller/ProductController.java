package io.github.eshop.persistence.controller;

import io.github.eshop.domain.caseuse.*;
import io.github.eshop.persistence.entity.ProductPersistence;
import io.github.eshop.persistence.mapper.ProductPersistenceMapper;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/product")
public class ProductController {
    private final CreateProductCaseUse createProductCaseUse;
    private final ProductPersistenceMapper productMapper;
    private final FindByNameProductCaseUse findByNameProductCaseUse;
    private final GetAllProductsCaseUse getAllProductsCaseUSe;
    private final UpdateProductCaseUse updateProductCaseUse;
    private final DeleteProductCaseUse deleteProductCaseUse;
    private final FindProductByIdCaseUse findProductByIdCaseUse;

    public ProductController(CreateProductCaseUse createProductCaseUse, ProductPersistenceMapper productMapper, FindByNameProductCaseUse findByNameProductCaseUse, GetAllProductsCaseUse getAllProductsCaseUSe, UpdateProductCaseUse updateProductCaseUse, DeleteProductCaseUse deleteProductCaseUse, FindProductByIdCaseUse findProductByIdCaseUse) {
        this.createProductCaseUse = createProductCaseUse;
        this.productMapper = productMapper;
        this.findByNameProductCaseUse = findByNameProductCaseUse;
        this.getAllProductsCaseUSe = getAllProductsCaseUSe;
        this.updateProductCaseUse = updateProductCaseUse;
        this.deleteProductCaseUse = deleteProductCaseUse;
        this.findProductByIdCaseUse = findProductByIdCaseUse;
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

    @GetMapping("/search/{id}")
    public ProductPersistence getAllProductsByCategory(@PathVariable Integer id) {
        return productMapper.fromDomainToPersistence(findProductByIdCaseUse.findProductById(id));
    }

    @PutMapping("/update/{productName}")
    public void updateProduct(@PathVariable String productName, @RequestBody ProductPersistence productPersistence) {
        updateProductCaseUse.updateProduct(productName, productMapper.fromPersistenceToDomain(productPersistence));
    }

    @DeleteMapping("/delete/{productName}")
    public void deleteProduct(@PathVariable String productName) {
        deleteProductCaseUse.deleteProduct(productName);
    }
}
