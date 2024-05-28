package io.github.eshop.data.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "order_product")
public class Order {
    @Id
    @GeneratedValue
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToOne
    @JoinColumn(name = "address_id")
    private Shipping_Address address;

    @ManyToOne
    @JoinColumn(name = "Order_product_id")
    private OrderProduct products;

    private Double total;

    public Order() {
    }

    public Order(Integer id, User user, Shipping_Address address, OrderProduct products, Double total) {
        this.id = id;
        this.user = user;
        this.address = address;
        this.products = products;
        this.total = total;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Shipping_Address getAddress() {
        return address;
    }

    public void setAddress(Shipping_Address address) {
        this.address = address;
    }

    public OrderProduct getProducts() {
        return products;
    }

    public void setProducts(OrderProduct products) {
        this.products = products;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", user=" + user +
                ", address=" + address +
                ", products=" + products +
                ", total=" + total +
                '}';
    }
}
