package io.github.eshop.config;

import io.github.eshop.data.repository.*;
import io.github.eshop.domain.caseuse.*;
import io.github.eshop.domain.mapper.*;
import io.github.eshop.utils.Validator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeansConfig {
    private final CategoryDomainMapper categoryMapper;

    public BeansConfig(CategoryDomainMapper categoryMapper) {
        this.categoryMapper = categoryMapper;
    }

    @Bean
    public CreateCategoryCaseUse createCategoryCaseUse(CategoryRepository categoryRepository, CategoryDomainMapper categoryMapper, Validator validator) {
        return new CreateCategoryCaseUse(categoryRepository, categoryMapper, validator);
    }

    @Bean
    public FindByCategoryNameCaseUse findByCategoryNameCaseUse(CategoryRepository categoryRepository, CategoryDomainMapper categoryMapper, Validator validator) {
        return new FindByCategoryNameCaseUse(categoryRepository, categoryMapper, validator);
    }

    @Bean
    public DeleteCategoryCaseUse deleteCategoryCaseUse(FindByCategoryNameCaseUse findByCategoryNameCaseUse, CategoryRepository categoryRepository) {
        return new DeleteCategoryCaseUse(findByCategoryNameCaseUse, categoryRepository);
    }

    @Bean
    public CreateProductCaseUse createProductCaseUse(ProductRepository productRepository, ProductDomainMapper productMapper, Validator validator) {
        return new CreateProductCaseUse(productRepository, productMapper, validator);
    }

    @Bean
    public GetAllsCategoriesCaseUse getAllsCategoriesCaseUse(CategoryRepository categoryRepository, CategoryDomainMapper categoryMapper) {
        return new GetAllsCategoriesCaseUse(categoryRepository, categoryMapper);
    }

    @Bean
    public FindByNameProductCaseUse findByNameProductCaseUse(ProductRepository productRepository, ProductDomainMapper productMapper, Validator validator) {
        return new FindByNameProductCaseUse(productRepository, productMapper, validator);
    }

    @Bean
    public GetAllProductsCaseUse getAllProductsCaseUse(ProductRepository productRepository, ProductDomainMapper productMapper) {
        return new GetAllProductsCaseUse(productRepository, productMapper);
    }

    @Bean
    public UpdateProductCaseUse updateProductCaseUse(ProductRepository productRepository, ProductDomainMapper productMapper, Validator validator, FindByNameProductCaseUse findByNameProductCaseUse) {
        return new UpdateProductCaseUse(productRepository, productMapper, validator, findByNameProductCaseUse);
    }

    @Bean
    public DeleteProductCaseUse deleteProductCaseUse(FindByNameProductCaseUse findByNameProductCaseUse, ProductDomainMapper productMapper, Validator validator, ProductRepository productRepository) {
        return new DeleteProductCaseUse(findByNameProductCaseUse, productMapper, validator, productRepository);
    }

    @Bean
    public CreateUserCaseUse createUserCaseUse(UserRepository userRepository, UserDomainMapper userMapper, Validator validator) {
        return new CreateUserCaseUse(userRepository, userMapper, validator);
    }

    @Bean
    public FindUserByCcCaseUse findUserByCcCaseUse(UserRepository userRepository, UserDomainMapper userMapper) {
        return new FindUserByCcCaseUse(userRepository, userMapper);
    }

    @Bean
    public GetAllUserCaseUse getAllUserCaseUse(UserRepository userRepository, UserDomainMapper userMapper) {
        return new GetAllUserCaseUse(userRepository, userMapper);
    }

    @Bean
    public CreateAddressCaseUse createAddressCaseUse(ShippingAddressRepository addressRepository, AddressDomainMapper addressMapper) {
        return new CreateAddressCaseUse(addressRepository, addressMapper);
    }

    @Bean
    public UpdateUserCaseUse updateUserCaseUse(FindUserByCcCaseUse findUserByCcCaseUse, UserDomainMapper userMapper, UserRepository userRepository) {
        return new UpdateUserCaseUse(findUserByCcCaseUse, userMapper, userRepository);
    }

    @Bean
    public UpdateShippingAddressCaseUse updateShippingAddressCaseUse(ShippingAddressRepository addressRepository, AddressDomainMapper addressMapper, UpdateUserCaseUse updateUserCaseUse, FindUserByCcCaseUse findUserByCcCaseUse, UserDomainMapper userMapper) {
        return new UpdateShippingAddressCaseUse(addressRepository, addressMapper, updateUserCaseUse, findUserByCcCaseUse, userMapper);
    }

    @Bean
    public DeleteShippingAddressCaseUse deleteShippingAddressCaseUse(ShippingAddressRepository addressRepository) {
        return new DeleteShippingAddressCaseUse(addressRepository);
    }

    @Bean
    public GetAllShippingAddressCaseUse getAllShippingAddressCaseUse(ShippingAddressRepository addressRepository, AddressDomainMapper addressMapper) {
        return new GetAllShippingAddressCaseUse(addressRepository, addressMapper);
    }

    @Bean
    public DeleteUserCaseUse deleteUserCaseUse(UserRepository userRepository, FindUserByCcCaseUse findUserByCcCaseUse, UserDomainMapper userMapper) {
        return new DeleteUserCaseUse(userRepository, findUserByCcCaseUse, userMapper);
    }


    @Bean
    public FindProductByIdCaseUse findProductByIdCaseUse(ProductRepository productRepository, ProductDomainMapper productMapper) {
        return new FindProductByIdCaseUse(productRepository, productMapper);
    }

    @Bean
    public FindUserByIdCaseUse findUserByIdCaseUse(UserRepository userRepository, UserDomainMapper userMapper) {
        return new FindUserByIdCaseUse(userRepository, userMapper);
    }

}
