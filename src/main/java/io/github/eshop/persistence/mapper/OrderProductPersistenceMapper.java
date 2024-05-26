package io.github.eshop.persistence.mapper;

import io.github.eshop.domain.entity.OrderProductDomain;
import io.github.eshop.persistence.entity.OrderProductPersistence;
import org.springframework.stereotype.Component;

@Component
public class OrderProductPersistenceMapper {
    public OrderProductDomain fromPersistenceToDomain(OrderProductPersistence orderProductPersistence) {
        return new io.github.eshop.domain.entity.OrderProductDomain(orderProductPersistence.getId(), orderProductPersistence.getProduct(), orderProductPersistence.getQuantity());
    }

    public OrderProductPersistence fromDomainToPersistence(OrderProductDomain orderProductDomain) {
        return new OrderProductPersistence(orderProductDomain.getId(), orderProductDomain.getProduct(), orderProductDomain.getQuantity());
    }
}
