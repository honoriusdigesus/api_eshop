package io.github.eshop.persistence.mapper;

import io.github.eshop.data.entity.OrderProduct;
import io.github.eshop.domain.entity.OrderProductDomain;
import io.github.eshop.domain.mapper.ProductDomainMapper;
import io.github.eshop.persistence.entity.OrderProductPersistence;
import org.springframework.stereotype.Component;

@Component
public class OrderProductPersistenceMapper {
    private final ProductPersistenceMapper productMapper;

    public OrderProductPersistenceMapper(ProductPersistenceMapper productMapper) {
        this.productMapper = productMapper;
    }

    public OrderProductPersistence fromDomainToPersistence(OrderProductDomain orderProductDomain) {
        return new OrderProductPersistence(orderProductDomain.getId(), orderProductDomain.getQuantity(), productMapper.fromDomainToPersistence(orderProductDomain.getProduct()));
    }

    public OrderProductDomain fromPersistenceToDomain(OrderProductPersistence orderProduct) {
        return new OrderProductDomain(orderProduct.getId(), orderProduct.getQuantity(), productMapper.fromPersistenceToDomain(orderProduct.getProduct()));
    }
}
