package io.github.eshop.config;

import io.github.eshop.data.repository.*;
import io.github.eshop.domain.caseuse.*;
import io.github.eshop.domain.mapper.*;
import io.github.eshop.utils.Validator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeansConfig {
    private final CategoryMapper categoryMapper;

    public BeansConfig(CategoryMapper categoryMapper) {
        this.categoryMapper = categoryMapper;
    }

    @Bean
    public CreateCategoryCaseUse createCategoryCaseUse(CategoryRepository categoryRepository, CategoryMapper categoryMapper, Validator validator) {
        return new CreateCategoryCaseUse(categoryRepository, categoryMapper, validator);
    }

    @Bean
    public FindByCategoryNameCaseUse findByCategoryNameCaseUse(CategoryRepository categoryRepository, CategoryMapper categoryMapper, Validator validator) {
        return new FindByCategoryNameCaseUse(categoryRepository, categoryMapper, validator);
    }

    @Bean
    public DeleteCategoryCaseUse deleteCategoryCaseUse(FindByCategoryNameCaseUse findByCategoryNameCaseUse, CategoryRepository categoryRepository) {
        return new DeleteCategoryCaseUse(findByCategoryNameCaseUse, categoryRepository);
    }

    @Bean
    public CreateProductCaseUse createProductCaseUse(ProductRepository productRepository, ProductMapper productMapper, Validator validator) {
        return new CreateProductCaseUse(productRepository, productMapper, validator);
    }

    @Bean
    public GetAllsCategoriesCaseUse getAllsCategoriesCaseUse(CategoryRepository categoryRepository, CategoryMapper categoryMapper) {
        return new GetAllsCategoriesCaseUse(categoryRepository, categoryMapper);
    }

    @Bean
    public FindByNameProductCaseUse findByNameProductCaseUse(ProductRepository productRepository, ProductMapper productMapper, Validator validator) {
        return new FindByNameProductCaseUse(productRepository, productMapper, validator);
    }

    @Bean
    public GetAllProductsCaseUse getAllProductsCaseUse(ProductRepository productRepository, ProductMapper productMapper) {
        return new GetAllProductsCaseUse(productRepository, productMapper);
    }

    @Bean
    public UpdateProductCaseUse updateProductCaseUse(ProductRepository productRepository, ProductMapper productMapper, Validator validator, FindByNameProductCaseUse findByNameProductCaseUse) {
        return new UpdateProductCaseUse(productRepository, productMapper, validator, findByNameProductCaseUse);
    }

    @Bean
    public DeleteProductCaseUse deleteProductCaseUse(FindByNameProductCaseUse findByNameProductCaseUse, ProductMapper productMapper, Validator validator, ProductRepository productRepository) {
        return new DeleteProductCaseUse(findByNameProductCaseUse, productMapper, validator, productRepository);
    }

    @Bean
    public CreateUserCaseUse createUserCaseUse(UserRepository userRepository, UserMapper userMapper, Validator validator) {
        return new CreateUserCaseUse(userRepository, userMapper, validator);
    }

    @Bean
    public FindUserByCcCaseUse findUserByCcCaseUse(UserRepository userRepository, UserMapper userMapper) {
        return new FindUserByCcCaseUse(userRepository, userMapper);
    }

    @Bean
    public GetAllUserCaseUse getAllUserCaseUse(UserRepository userRepository, UserMapper userMapper) {
        return new GetAllUserCaseUse(userRepository, userMapper);
    }

    @Bean
    public CreateAddressCaseUse createAddressCaseUse(ShippingAddressRepository addressRepository, AddressMapper addressMapper) {
        return new CreateAddressCaseUse(addressRepository, addressMapper);
    }

    @Bean
    public UpdateUserCaseUse updateUserCaseUse(FindUserByCcCaseUse findUserByCcCaseUse, UserMapper userMapper, UserRepository userRepository) {
        return new UpdateUserCaseUse(findUserByCcCaseUse, userMapper, userRepository);
    }

    @Bean
    public UpdateShippingAddressCaseUse updateShippingAddressCaseUse(ShippingAddressRepository addressRepository, AddressMapper addressMapper, UpdateUserCaseUse updateUserCaseUse, FindUserByCcCaseUse findUserByCcCaseUse, UserMapper userMapper) {
        return new UpdateShippingAddressCaseUse(addressRepository, addressMapper, updateUserCaseUse, findUserByCcCaseUse, userMapper);
    }

    @Bean
    public DeleteShippingAddressCaseUse deleteShippingAddressCaseUse(ShippingAddressRepository addressRepository) {
        return new DeleteShippingAddressCaseUse(addressRepository);
    }

    @Bean
    public GetAllShippingAddressCaseUse getAllShippingAddressCaseUse(ShippingAddressRepository addressRepository, AddressMapper addressMapper) {
        return new GetAllShippingAddressCaseUse(addressRepository, addressMapper);
    }

    @Bean
    public DeleteUserCaseUse deleteUserCaseUse(UserRepository userRepository, FindUserByCcCaseUse findUserByCcCaseUse, UserMapper userMapper) {
        return new DeleteUserCaseUse(userRepository, findUserByCcCaseUse, userMapper);
    }

    @Bean
    public CreateOrderProductCaseUse createOrderProductCaseUse(OrderProductRepository orderProductRepository, OrderProductMapper orderProductMapper) {
        return new CreateOrderProductCaseUse(orderProductRepository, orderProductMapper);
    }
}
