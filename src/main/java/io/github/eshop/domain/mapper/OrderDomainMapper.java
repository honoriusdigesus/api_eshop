package io.github.eshop.domain.mapper;

import io.github.eshop.data.entity.Order;
import io.github.eshop.domain.entity.OrderDomain;
import io.github.eshop.persistence.entity.OrderPersistence;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class OrderDomainMapper {
    private final UserDomainMapper userMapper;
    private final AddressDomainMapper addressMapper;
    private final OrderProductDomainMapper orderProductMapper;

    public OrderDomainMapper(UserDomainMapper userMapper, AddressDomainMapper addressMapper, OrderProductDomainMapper orderProductMapper) {
        this.userMapper = userMapper;
        this.addressMapper = addressMapper;
        this.orderProductMapper = orderProductMapper;
    }

    public Order fromDomainToEntity(OrderDomain orderDomain) {

        Order order = new Order();
        order.setId(orderDomain.getId());
        order.setUser(userMapper.fromDomainToEntity(orderDomain.getUser()));
        order.setPaymentMethod(orderDomain.getPaymentMethod());
        order.setAddress(addressMapper.fromDomainToEntity(orderDomain.getAddress()));
        order.setItems(orderDomain.getItems().stream()
                .map(orderProductMapper::fromDomainToEntity)
                .collect(Collectors.toList()));
        order.setTotalPrice(orderDomain.getTotalPrice());
        return order;
    }

    public OrderDomain fromEntityToDomain(Order order) {
        OrderDomain orderDomain = new OrderDomain();
        orderDomain.setId(order.getId());
        orderDomain.setUser(userMapper.fromEntityToDomain(order.getUser()));
        orderDomain.setPaymentMethod(order.getPaymentMethod());
        orderDomain.setAddress(addressMapper.fromEntityToDomain(order.getAddress()));
        orderDomain.setItems(order.getItems().stream()
                .map(orderProductMapper::fromEntityToDomain)
                .collect(Collectors.toList()));
        orderDomain.setTotalPrice(order.getTotalPrice());
        return orderDomain;
    }
}
