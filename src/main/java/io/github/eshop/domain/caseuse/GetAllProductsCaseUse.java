package io.github.eshop.domain.caseuse;

import io.github.eshop.data.repository.ProductRepository;
import io.github.eshop.domain.entity.ProductDomain;
import io.github.eshop.domain.mapper.ProductMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class GetAllProductsCaseUse {
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    public GetAllProductsCaseUse(ProductRepository productRepository, ProductMapper productMapper) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
    }

    public List<ProductDomain> getAllProducts() {
        return productRepository.findAll().stream()
                .map(productMapper::fromEntityToDomain)
                .collect(Collectors.toList());
    }
}
