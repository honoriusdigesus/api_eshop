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
    private LocalDateTime date = LocalDateTime.now();
    private Double totalPrice;

    @OneToOne
    @JoinColumn(name="payment_id")
    private Payment payment;

    @ManyToOne
    @JoinColumn(name="users_id", nullable=false)
    private User user;

    @OneToMany
    @JoinColumn(name="order_product_id")
    private List<OrderProduct> orderProducts;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<OrderProduct> getOrderProducts() {
        return orderProducts;
    }

    public void setOrderProducts(List<OrderProduct> orderProducts) {
        this.orderProducts = orderProducts;
    }

    public Order() {
    }

    public Order(Integer id, LocalDateTime date, Double totalPrice, User user, List<OrderProduct> orderProducts) {
        this.id = id;
        this.date = date;
        this.totalPrice = totalPrice;
        this.user = user;
        this.orderProducts = orderProducts;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", date=" + date +
                ", totalPrice=" + totalPrice +
                ", user=" + user +
                ", orderProducts=" + orderProducts +
                '}';
    }
}
