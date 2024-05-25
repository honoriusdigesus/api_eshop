package io.github.eshop.persistence.mapper;

import io.github.eshop.domain.entity.OrderDomain;
import io.github.eshop.persistence.entity.OrderPersistence;
import org.springframework.stereotype.Component;

@Component
public class OrderMapperPersistence {
    public OrderPersistence fromDomainToPersistence(OrderDomain orderDomain) {
        return new OrderPersistence(orderDomain.getId(), orderDomain.getPaymentMethod(), orderDomain.getUser(), orderDomain.getAddress(), orderDomain.getItems(), orderDomain.getTotalPrice());
    }

    public OrderDomain fromPersistenceToDomain(OrderPersistence orderPersistence) {
        return new OrderDomain(orderPersistence.getId(), orderPersistence.getPaymentMethod(), orderPersistence.getUser(), orderPersistence.getAddress(), orderPersistence.getItems(), orderPersistence.getTotalPrice());
    }
}
