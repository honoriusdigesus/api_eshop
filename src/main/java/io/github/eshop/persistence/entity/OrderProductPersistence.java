package io.github.eshop.persistence.entity;

public class OrderProductPersistence {

    private Integer id;
    private Integer quantity;
    private ProductPersistence product;

    public OrderProductPersistence() {
    }

    public OrderProductPersistence(Integer id, Integer quantity, ProductPersistence product) {
        this.id = id;
        this.quantity = quantity;
        this.product = product;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public ProductPersistence getProduct() {
        return product;
    }

    public void setProduct(ProductPersistence product) {
        this.product = product;
    }

    @Override
    public String toString() {
        return "OrderProduct{" +
                "id=" + id +
                ", quantity=" + quantity +
                ", product=" + product +
                '}';
    }
}
