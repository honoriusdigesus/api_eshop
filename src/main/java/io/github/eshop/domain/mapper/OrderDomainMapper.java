package io.github.eshop.domain.mapper;

import io.github.eshop.data.entity.Order;
import io.github.eshop.domain.entity.OrderDomain;
import org.springframework.stereotype.Component;

@Component
public class OrderDomainMapper {
    private final UserDomainMapper userMapper;

    public OrderDomainMapper(UserDomainMapper userMapper) {
        this.userMapper = userMapper;
    }

    public Order fromDomainToEntity(OrderDomain orderDomain) {
        return new Order(
                orderDomain.getId(),
                userMapper.fromDomainToEntity(orderDomain.getUser()),
                orderDomain.getDate(),
                orderDomain.getStatus());
    }

    public OrderDomain fromEntityToDomain(Order order) {
        return new OrderDomain(
                order.getId(),
                userMapper.fromEntityToDomain(order.getUser()),
                order.getDate(),
                order.getStatus());
    }
}
