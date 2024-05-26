package io.github.eshop.persistence.mapper;

import io.github.eshop.domain.entity.OrderProductDomain;
import io.github.eshop.persistence.entity.OrderProductPersistence;
import org.springframework.stereotype.Component;

@Component
public class OrderProductPersistenceMapper {
    private final ProductPersistenceMapper productMapper;

    public OrderProductPersistenceMapper(ProductPersistenceMapper productMapper) {
        this.productMapper = productMapper;
    }

    public OrderProductPersistence fromDomainToPersistence(OrderProductDomain orderProductDomain) {
        return new OrderProductPersistence(
                orderProductDomain.getId(),
                productMapper.fromDomainToPersistence(orderProductDomain.getProduct()),
                orderProductDomain.getQuantity()
        );
    }

    public OrderProductDomain fromPersistenceToDomain(OrderProductPersistence orderProductPersistence) {

        return new OrderProductDomain(
                orderProductPersistence.getId(),
                productMapper.fromPersistenceToDomain(orderProductPersistence.getProduct()),
                orderProductPersistence.getQuantity()
        );
    }

}
