package io.github.eshop.persistence.entity;

import io.github.eshop.data.entity.Product;


public class OrderProductPersistence {

    private Integer id;

    private ProductPersistence product;

    private Integer quantity;

    public OrderProductPersistence(ProductPersistence product, Integer quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public ProductPersistence getProduct() {
        return product;
    }

    public void setProduct(ProductPersistence product) {
        this.product = product;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public OrderProductPersistence() {
    }

    public OrderProductPersistence(Integer id, ProductPersistence product, Integer quantity) {
        this.id = id;
        this.product = product;
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "OrderProduct{" +
                "id=" + id +
                ", product=" + product +
                ", quantity=" + quantity +
                '}';
    }
}
