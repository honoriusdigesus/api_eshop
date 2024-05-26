package io.github.eshop.persistence.mapper;

import io.github.eshop.domain.entity.OrderDomain;
import io.github.eshop.persistence.entity.OrderPersistence;
import io.github.eshop.persistence.entity.OrderProductPersistence;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;


@Component
public class OrderPersistenceMapper {
    private final UserPersistenceMapper userMapper;
    private final AddressPersistenceMapper addressMapper;
    private final OrderProductPersistenceMapper orderProductMapper;

    public OrderPersistenceMapper(
            UserPersistenceMapper userMapper,
            AddressPersistenceMapper addressMapper,
            OrderProductPersistenceMapper orderProductMapper) {
        this.userMapper = userMapper;
        this.addressMapper = addressMapper;
        this.orderProductMapper = orderProductMapper;
    }

    public OrderPersistence fromDomainToPersistence(OrderDomain orderDomain) {
        if (orderDomain == null) {
            return null;
        }
        OrderPersistence orderPersistence = new OrderPersistence();
        orderPersistence.setId(orderDomain.getId());
        orderPersistence.setUser(userMapper.fromDomainToPersistence(orderDomain.getUser()));
        orderPersistence.setPaymentMethod(orderDomain.getPaymentMethod());
        orderPersistence.setAddress(addressMapper.fromDomainToPersistence(orderDomain.getAddress()));
        orderPersistence.setItems(orderDomain.getItems().stream()
                .map(orderProductMapper::fromDomainToPersistence)
                .collect(Collectors.toList()));
        orderPersistence.setTotalPrice(orderDomain.getTotalPrice());
        return orderPersistence;
    }

    public OrderDomain fromPersistenceToDomain(OrderPersistence orderPersistence) {
        if (orderPersistence == null) {
            return null;
        }
        OrderDomain orderDomain = new OrderDomain();
        orderDomain.setId(orderPersistence.getId());
        orderDomain.setUser(userMapper.fromPersistenceToDomain(orderPersistence.getUser()));
        orderDomain.setPaymentMethod(orderPersistence.getPaymentMethod());
        orderDomain.setAddress(addressMapper.fromPersistenceToDomain(orderPersistence.getAddress()));
        orderDomain.setItems(orderPersistence.getItems().stream()
                .map(orderProductMapper::fromPersistenceToDomain)
                .collect(Collectors.toList()));
        orderDomain.setTotalPrice(orderPersistence.getTotalPrice());
        return orderDomain;
    }
}