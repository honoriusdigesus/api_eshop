package io.github.eshop.persistence.controller;

import io.github.eshop.domain.caseuse.CreateOrderProductCaseUse;
import io.github.eshop.persistence.entity.OrderProductPersistence;
import io.github.eshop.persistence.mapper.OrderProductPersistenceMapper;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order-product")
public class OrderProductController {
    private final CreateOrderProductCaseUse createOrderProductCaseUse;
    private final OrderProductPersistenceMapper orderProductPersistenceMapper;

    public OrderProductController(CreateOrderProductCaseUse createOrderProductCaseUse, OrderProductPersistenceMapper orderProductPersistenceMapper) {
        this.createOrderProductCaseUse = createOrderProductCaseUse;
        this.orderProductPersistenceMapper = orderProductPersistenceMapper;
    }

    @PostMapping("/create")
    public void createOrderProduct(@RequestBody  OrderProductPersistence orderProductPersistence) {
        createOrderProductCaseUse.saveOrderProduct(orderProductPersistenceMapper.fromPersistenceToDomain(orderProductPersistence));
    }
}
