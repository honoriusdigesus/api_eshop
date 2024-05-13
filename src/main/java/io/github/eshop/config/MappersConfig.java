package io.github.eshop.config;

import io.github.eshop.domain.mapper.CategoryMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class MappersConfig {
    @Bean
    public CategoryMapper categoryMapper() {
        return new CategoryMapper();
    }
}
