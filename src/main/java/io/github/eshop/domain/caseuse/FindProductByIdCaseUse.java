package io.github.eshop.domain.caseuse;

import io.github.eshop.data.repository.ProductRepository;
import io.github.eshop.domain.entity.ProductDomain;
import io.github.eshop.domain.mapper.ProductMapper;
import org.springframework.stereotype.Component;

@Component
public class FindProductByIdCaseUse {
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    public FindProductByIdCaseUse(ProductRepository productRepository, ProductMapper productMapper) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
    }

    public ProductDomain findProductById(Integer id) {
        return productMapper.fromEntityToDomain(productRepository.findById(id).orElseThrow());
    }
}
