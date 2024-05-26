package io.github.eshop.persistence.controller;

import io.github.eshop.domain.caseuse.CreateOrderCaseUse;
import io.github.eshop.persistence.entity.OrderPersistence;
import io.github.eshop.persistence.mapper.OrderPersistenceMapper;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {
    private final CreateOrderCaseUse createOrderCaseUse;
    private final OrderPersistenceMapper orderMapperPersistence;

    public OrderController(CreateOrderCaseUse createOrderCaseUse, OrderPersistenceMapper orderMapperPersistence) {
        this.createOrderCaseUse = createOrderCaseUse;
        this.orderMapperPersistence = orderMapperPersistence;
    }

    @PostMapping("/create")
    public void createOrder(@RequestBody OrderPersistence orderPersistence) {
        createOrderCaseUse.createOrder(orderMapperPersistence.(orderPersistence));
    }

}
