package io.github.eshop.data.entity;

import io.github.eshop.enums.OrderStatus;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue
    private Integer id;

    @Column(nullable = false)
    private LocalDateTime date = LocalDateTime.now();

    private String comment;

    @Enumerated(value = EnumType.STRING)
    private OrderStatus state = OrderStatus.PENDING;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "order", cascade = CascadeType.PERSIST)
    List<OrderItem> items;

    public Order() {
    }

    public Order(Integer id, LocalDateTime date, String comment, OrderStatus state, User user, List<OrderItem> items) {
        this.id = id;
        this.date = date;
        this.comment = comment;
        this.state = state;
        this.user = user;
        this.items = items;
    }

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

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public OrderStatus getState() {
        return state;
    }

    public void setState(OrderStatus state) {
        this.state = state;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<OrderItem> getItems() {
        return items;
    }

    public void setItems(List<OrderItem> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", date=" + date +
                ", comment='" + comment + '\'' +
                ", state=" + state +
                ", user=" + user +
                ", items=" + items +
                '}';
    }
}
