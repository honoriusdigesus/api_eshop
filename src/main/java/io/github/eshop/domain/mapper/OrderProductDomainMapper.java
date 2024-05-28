package io.github.eshop.domain.mapper;

import io.github.eshop.data.entity.OrderProduct;
import io.github.eshop.domain.entity.OrderProductDomain;
import org.springframework.stereotype.Component;

@Component
public class OrderProductDomainMapper {
    private final ProductDomainMapper productMapper;

    public OrderProductDomainMapper(ProductDomainMapper productMapper) {
        this.productMapper = productMapper;
    }

    public OrderProduct fromDomainToEntity(OrderProductDomain orderProductDomain) {
        return new OrderProduct(orderProductDomain.getId(), orderProductDomain.getQuantity(), productMapper.fromDomainToEntity(orderProductDomain.getProduct()));
    }

    public OrderProductDomain fromEntityToDomain(OrderProduct orderProduct) {
        return new OrderProductDomain(orderProduct.getId(), orderProduct.getQuantity(), productMapper.fromEntityToDomain(orderProduct.getProduct()));
    }
}
