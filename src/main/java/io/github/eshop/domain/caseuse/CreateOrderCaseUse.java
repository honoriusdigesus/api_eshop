package io.github.eshop.domain.caseuse;

import io.github.eshop.data.repository.OrderRepository;
import io.github.eshop.domain.entity.OrderDomain;
import io.github.eshop.domain.entity.ProductDomain;
import io.github.eshop.domain.entity.UserDomain;
import io.github.eshop.domain.mapper.AddressDomainMapper;
import io.github.eshop.domain.mapper.OrderDomainMapper;
import io.github.eshop.domain.mapper.ProductDomainMapper;
import io.github.eshop.domain.mapper.UserDomainMapper;
import org.springframework.stereotype.Component;

@Component
public class CreateOrderCaseUse {


    private final UserDomainMapper userMapper;
    private final FindProductByIdCaseUse findProductByIdCaseUse;
    private final FindUserByIdCaseUse findUserByIdCaseUse;
    private final ProductDomainMapper productMapper;
    private final UpdateProductCaseUse updateProductCaseUse;
    private final FindAddressByUserCcCaseUse findAddressByIdCaseUse;
    private final AddressDomainMapper addressMapper;



    public CreateOrderCaseUse(

            UserDomainMapper userMapper,
            FindProductByIdCaseUse findProductByIdCaseUse,
            FindUserByIdCaseUse findUserByIdCaseUse,
            ProductDomainMapper productMapper,
            UpdateProductCaseUse updateProductCaseUse,
            FindAddressByUserCcCaseUse findAddressByIdCaseUse,
            AddressDomainMapper addressMapper
    ) {

        this.userMapper = userMapper;
        this.findProductByIdCaseUse = findProductByIdCaseUse;
        this.findUserByIdCaseUse = findUserByIdCaseUse;
        this.productMapper = productMapper;
        this.updateProductCaseUse = updateProductCaseUse;
        this.findAddressByIdCaseUse = findAddressByIdCaseUse;
        this.addressMapper = addressMapper;
    }

    public void createOrder(OrderDomain orderDomain) {
        UserDomain userDomain = findUserByIdCaseUse.findUserById(orderDomain.getUser().getId());
        orderDomain.setUser(userDomain);
        orderDomain.setAddress(findAddressByIdCaseUse.findAddressByCc(userDomain.getCc()));

        //Buscar los productos por id foreach
        orderDomain.getItems().forEach(orderProduct -> {
            ProductDomain product = findProductByIdCaseUse.findProductById(orderProduct.getProduct().getId());
            if (product == null) {
                throw new RuntimeException("Product not found");
            }else {
                if (product.getStock() < orderProduct.getQuantity()) {
                    throw new RuntimeException("Product out of stock");
                }
                product.setStock(product.getStock() - orderProduct.getQuantity());
                updateProductCaseUse.updateProduct(product.getName(), product);
            }
            orderProduct.setProduct(product);
            System.out.println(product);
        });
    }
}

