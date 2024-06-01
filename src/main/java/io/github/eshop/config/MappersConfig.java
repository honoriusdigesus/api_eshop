package io.github.eshop.config;

import io.github.eshop.domain.mapper.*;
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
    public OrderDomainMapper orderMapper(UserDomainMapper userMapper) {
        return new OrderDomainMapper(userMapper);
    }
}
