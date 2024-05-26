package io.github.eshop.config;

import io.github.eshop.domain.mapper.*;
import io.github.eshop.persistence.mapper.OrderPersistenceMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class MappersConfig {
    @Bean
    public CategoryDomainMapper categoryMapper() {
        return new CategoryDomainMapper();
    }

    @Bean
    public ProductDomainMapper productMapper() {
        return new ProductDomainMapper();
    }

    @Bean
    public UserDomainMapper userMapper() {
        return new UserDomainMapper();
    }

    @Bean
    public AddressDomainMapper addressMapper(UserDomainMapper userMapper) {
        return new AddressDomainMapper(userMapper);
    }

    @Bean
    public OrderProductDomainMapper orderProductMapper(ProductDomainMapper productDomainMapper) {
        return new OrderProductDomainMapper(productDomainMapper);
    }

    @Bean
    public OrderDomainMapper orderMapper() {
        return new OrderDomainMapper();
    }

}
