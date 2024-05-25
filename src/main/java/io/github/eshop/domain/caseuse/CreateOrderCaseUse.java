package io.github.eshop.domain.caseuse;

import io.github.eshop.data.entity.Shipping_Address;
import io.github.eshop.data.repository.OrderRepository;
import io.github.eshop.domain.entity.AddressDomain;
import io.github.eshop.domain.entity.OrderDomain;
import io.github.eshop.domain.entity.ProductDomain;
import io.github.eshop.domain.entity.UserDomain;
import io.github.eshop.domain.mapper.OrderMapper;
import io.github.eshop.domain.mapper.ProductMapper;
import io.github.eshop.domain.mapper.UserMapper;
import org.springframework.stereotype.Component;

@Component
public class CreateOrderCaseUse {

    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;
    private final UserMapper userMapper;
    private final FindProductByIdCaseUse findProductByIdCaseUse;
    private final FindUserByIdCaseUse findUserByIdCaseUse;
    private final ProductMapper productMapper;
    private final UpdateProductCaseUse updateProductCaseUse;


    public CreateOrderCaseUse(
            OrderRepository orderRepository,
            OrderMapper orderMapper,
            UserMapper userMapper,
            FindProductByIdCaseUse findProductByIdCaseUse,
            FindUserByIdCaseUse findUserByIdCaseUse,
            ProductMapper productMapper, UpdateProductCaseUse updateProductCaseUse
    ) {
        this.orderRepository = orderRepository;
        this.orderMapper = orderMapper;
        this.userMapper = userMapper;
        this.findProductByIdCaseUse = findProductByIdCaseUse;
        this.findUserByIdCaseUse = findUserByIdCaseUse;
        this.productMapper = productMapper;
        this.updateProductCaseUse = updateProductCaseUse;
    }

    public void createOrder(OrderDomain orderDomain) {
        UserDomain userDomain = findUserByIdCaseUse.findUserById(orderDomain.getUser().getId());
        orderDomain.setUser(userMapper.fromDomainToEntity(userDomain));
        AddressDomain addressDomain;

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
            orderProduct.setProduct(productMapper.fromDomainToEntity(product));
            System.out.println("Product: " + product.getName() + " - " + product.getPrice());
        });
    }
}

