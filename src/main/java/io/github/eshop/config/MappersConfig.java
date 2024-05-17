package io.github.eshop.config;

import io.github.eshop.domain.mapper.AddressMapper;
import io.github.eshop.domain.mapper.CategoryMapper;
import io.github.eshop.domain.mapper.ProductMapper;
import io.github.eshop.domain.mapper.UserMapper;
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
}
