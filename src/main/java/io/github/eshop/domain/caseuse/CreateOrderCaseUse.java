package io.github.eshop.domain.caseuse;

import io.github.eshop.data.repository.OrderRepository;
import io.github.eshop.domain.entity.OrderDomain;
import io.github.eshop.domain.mapper.OrderDomainMapper;
import org.springframework.stereotype.Component;

@Component
public class CreateOrderCaseUse {
    private final OrderRepository orderRepository;
    private final OrderDomainMapper orderMapper;

    public CreateOrderCaseUse(OrderRepository orderRepository, OrderDomainMapper orderMapper) {
        this.orderRepository = orderRepository;
        this.orderMapper = orderMapper;
    }

    public void create(OrderDomain orderDomain) {
        orderRepository.save(orderMapper.fromDomainToEntity(orderDomain));
    }
}
