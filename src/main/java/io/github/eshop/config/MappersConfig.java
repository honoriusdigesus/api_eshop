package io.github.eshop.config;

import io.github.eshop.domain.mapper.*;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class MappersConfig {
    @Bean
    public CategoryMapper categoryMapper() {
        return new CategoryMapper();
    }

    @Bean
    public ProductMapper productMapper() {
        return new ProductMapper();
    }

    @Bean
    public UserMapper userMapper() {
        return new UserMapper();
    }

    @Bean
    public AddressMapper addressMapper() {
        return new AddressMapper();
    }

    @Bean
    public OrderProductMapper orderProductMapper() {
        return new OrderProductMapper();
    }

    @Bean
    public OrderMapperDomain orderMapper() {
        return new OrderMapperDomain();
    }
}
