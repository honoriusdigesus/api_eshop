package io.github.eshop.persistence.mapper;

import io.github.eshop.domain.entity.OrderDomain;
import io.github.eshop.domain.entity.OrderProductDomain;
import io.github.eshop.persistence.entity.OrderPersistence;
import io.github.eshop.persistence.entity.OrderProductPersistence;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class OrderMapperPersistence {
    public static OrderPersistence fromDomainToPersistence(OrderDomain orderDomain) {
        List<OrderProductPersistence> orderProductPersistenceList = new ArrayList<>();
        for (OrderProductDomain orderProductDomain : orderDomain.getItems()) {
            orderProductPersistenceList.add(new OrderProductPersistence(orderProductDomain.getProduct(), orderProductDomain.getQuantity()));
        }
        return new OrderPersistence(orderDomain.getId(), orderDomain.getPaymentMethod(), orderDomain.getUser(), orderDomain.getAddress(), orderProductPersistenceList, orderDomain.getTotalPrice());
    }

    public static OrderDomain fromPersistenceToDomain(OrderPersistence orderPersistence) {
        List<OrderProductDomain> orderProductDomainList = new ArrayList<>();
        for (OrderProductPersistence orderProductPersistence : orderPersistence.getItems()) {
            orderProductDomainList.add(new io.github.eshop.domain.entity.OrderProductDomain(orderProductPersistence.getProduct(), orderProductPersistence.getQuantity()));
        }
        return new OrderDomain(orderPersistence.getId(), orderPersistence.getPaymentMethod(), orderPersistence.getUser(), orderPersistence.getAddress(), orderProductDomainList, orderPersistence.getTotalPrice());
    }
}
