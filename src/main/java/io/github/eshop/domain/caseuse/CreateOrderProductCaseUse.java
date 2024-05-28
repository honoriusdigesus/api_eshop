package io.github.eshop.domain.caseuse;

import io.github.eshop.data.repository.OrderProductRepository;
import io.github.eshop.domain.entity.OrderProductDomain;
import io.github.eshop.domain.mapper.OrderProductDomainMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class CreateOrderProductCaseUse {
    private final OrderProductRepository orderProductRepository;
    private final OrderProductDomainMapper orderProductDomainMapper;

    public CreateOrderProductCaseUse(OrderProductRepository orderProductRepository, OrderProductDomainMapper orderProductDomainMapper) {
        this.orderProductRepository = orderProductRepository;
        this.orderProductDomainMapper = orderProductDomainMapper;
    }

    public void saveOrderProduct(OrderProductDomain products) {
        orderProductRepository.save(orderProductDomainMapper.fromDomainToEntity(products));
    }
}
