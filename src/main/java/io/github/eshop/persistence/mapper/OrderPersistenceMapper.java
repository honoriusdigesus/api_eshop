package io.github.eshop.persistence.mapper;

import io.github.eshop.domain.entity.OrderDomain;
import io.github.eshop.persistence.entity.OrderPersistence;
import org.springframework.stereotype.Component;

@Component
public class OrderPersistenceMapper {
    private final UserPersistenceMapper userMapper;

    public OrderPersistenceMapper(UserPersistenceMapper userMapper) {
        this.userMapper = userMapper;
    }

    public OrderPersistence fromDomainToEntity(OrderDomain orderDomain) {
        return new OrderPersistence(
                orderDomain.getId(),
                userMapper.fromDomainToPersistence(orderDomain.getUser()),
                orderDomain.getDate(),
                orderDomain.getStatus());
    }

    public OrderDomain fromEntityToDomain(OrderPersistence order) {
        return new OrderDomain(
                order.getId(),
                userMapper.fromPersistenceToDomain(order.getUser()),
                order.getDate(),
                order.getStatus());
    }
}
