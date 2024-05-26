package io.github.eshop.domain.mapper;

import io.github.eshop.domain.entity.OrderDomain;
import io.github.eshop.persistence.entity.OrderPersistence;
import io.github.eshop.persistence.entity.OrderProductPersistence;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class OrderMapperDomain {
    public static OrderPersistence fromDomainToEntity(OrderDomain orderDomain) {
        List<OrderProductPersistence> orderProductPersistenceList = new ArrayList<>();
        for (io.github.eshop.domain.entity.OrderProductDomain orderProductDomain : orderDomain.getItems()) {
            orderProductPersistenceList.add(new OrderProductPersistence(orderProductDomain.getProduct(), orderProductDomain.getQuantity()));
        }
        return new OrderPersistence(orderDomain.getId(), orderDomain.getPaymentMethod(), orderDomain.getUser(), orderDomain.getAddress(), orderProductPersistenceList, orderDomain.getTotalPrice());
    }

    public static OrderDomain formEntityToDomain(OrderPersistence order) {
        List<io.github.eshop.domain.entity.OrderProductDomain> orderProductDomainList = new ArrayList<>();
        for (OrderProductPersistence orderProductPersistence : order.getItems()) {
            orderProductDomainList.add(new io.github.eshop.domain.entity.OrderProductDomain(orderProductPersistence.getProduct(), orderProductPersistence.getQuantity()));
        }
        return new OrderDomain(order.getId(), order.getPaymentMethod(), order.getUser(), order.getAddress(), orderProductDomainList, order.getTotalPrice());
    }
}
