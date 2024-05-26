package io.github.eshop.domain.mapper;

import io.github.eshop.data.entity.OrderProduct;
import io.github.eshop.domain.entity.OrderProductDomain;
import org.springframework.stereotype.Component;

@Component
public class OrderProductDomainMapper {
    private final ProductDomainMapper productDomainMapper;

    public OrderProductDomainMapper(ProductDomainMapper productDomainMapper) {
        this.productDomainMapper = productDomainMapper;
    }

    public OrderProductDomain fromEntityToDomain(OrderProduct orderProduct) {

        return new OrderProductDomain(
                orderProduct.getId(),
                productDomainMapper.fromEntityToDomain(orderProduct.getProduct()),
                orderProduct.getQuantity()
        );
    }

    public OrderProduct fromDomainToEntity(OrderProductDomain orderProductDomain) {

        return new OrderProduct(
                orderProductDomain.getId(),
                productDomainMapper.fromDomainToEntity(orderProductDomain.getProduct()),
                orderProductDomain.getQuantity()
        );
    }

}
