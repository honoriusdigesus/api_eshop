package io.github.eshop.domain.mapper;

import io.github.eshop.data.entity.OrderProduct;
import io.github.eshop.domain.entity.OrderProductDomain;
import org.springframework.stereotype.Component;

@Component
public class OrderProductMapper {
    public OrderProductDomain fromEntityToDomain(OrderProduct orderProduct) {
        return new OrderProductDomain(orderProduct.getId(), orderProduct.getProduct(), orderProduct.getQuantity());
    }

    public OrderProduct fromDomainToEntity(OrderProductDomain orderProductDomain) {
        return new OrderProduct(orderProductDomain.getId(), orderProductDomain.getProduct(), orderProductDomain.getQuantity());
    }
}
