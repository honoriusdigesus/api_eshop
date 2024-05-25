package io.github.eshop.domain.mapper;

import io.github.eshop.data.entity.Order;
import io.github.eshop.domain.entity.OrderDomain;
import org.springframework.stereotype.Component;

@Component
public class OrderMapper {
    public Order fromDomainToEntity(OrderDomain orderDomain) {
        return new Order(orderDomain.getId(), orderDomain.getPaymentMethod(), orderDomain.getUser(), orderDomain.getAddress(), orderDomain.getItems(), orderDomain.getTotalPrice());
    }

    public OrderDomain fromEntityToDomain(Order order) {
        return new OrderDomain(order.getId(), order.getPaymentMethod(), order.getUser(), order.getAddress(), order.getItems(), order.getTotalPrice());
    }
}
