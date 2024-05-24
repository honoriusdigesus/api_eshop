package io.github.eshop.domain.caseuse;

import io.github.eshop.data.repository.OrderProductRepository;
import io.github.eshop.domain.entity.OrderProductDomain;
import io.github.eshop.domain.mapper.OrderProductMapper;
import org.springframework.stereotype.Component;

@Component
public class CreateOrderProductCaseUse {
    private final OrderProductRepository orderProductRepository;
    private final OrderProductMapper orderProductMapper;

    public CreateOrderProductCaseUse(OrderProductRepository orderProductRepository, OrderProductMapper orderProductMapper) {
        this.orderProductRepository = orderProductRepository;
        this.orderProductMapper = orderProductMapper;
    }

    public void saveOrderProduct(OrderProductDomain orderProductDomain) {
        orderProductRepository.save(orderProductMapper.fromDomainToEntity(orderProductDomain));
    }
}
