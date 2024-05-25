package io.github.eshop.data.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue
    private Integer id;
    @ManyToOne
    private User user;

    private String paymentMethod;

    @ManyToOne
    private Shipping_Address address;

    @OneToMany(cascade = CascadeType.ALL)
    private List<OrderProduct> items;

    private double totalPrice;

    public Order() {
    }

    public Order(Integer id, String paymentMethod, User user, Shipping_Address address, List<OrderProduct> items, double totalPrice) {
        this.id = id;
        this.paymentMethod = paymentMethod;
        this.user = user;
        this.address = address;
        this.items = items;
        this.totalPrice = totalPrice;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
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

    public List<OrderProduct> getItems() {
        return items;
    }

    public void setItems(List<OrderProduct> items) {
        this.items = items;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public void calculateTotalPrice() {
        totalPrice = items.stream()
                .mapToDouble(item -> item.getProduct().getPrice() * item.getQuantity())
                .sum();
    }
}
