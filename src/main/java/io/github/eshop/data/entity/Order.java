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
    private LocalDateTime order_date;
    private OrderStatus status;

    @OneToOne
    @JoinColumn(name = "payment_id")
    private Payment payment;

    @OneToOne
    @JoinColumn(name = "users_id")
    private User user;

    @OneToOne
    @JoinColumn(name = "address_id")
    private Shipping_Address address;

    @OneToMany(mappedBy = "order")
    private List<OrderDetail> orderDetails;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDateTime getOrder_date() {
        return order_date;
    }

    public void setOrder_date(LocalDateTime order_date) {
        this.order_date = order_date;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
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

    public List<OrderDetail> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(List<OrderDetail> orderDetails) {
        this.orderDetails = orderDetails;
    }

    public Order() {
    }

    public Order(Integer id, LocalDateTime order_date, OrderStatus status, Payment payment, User user, Shipping_Address address, List<OrderDetail> orderDetails) {
        this.id = id;
        this.order_date = order_date;
        this.status = status;
        this.payment = payment;
        this.user = user;
        this.address = address;
        this.orderDetails = orderDetails;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", order_date=" + order_date +
                ", status=" + status +
                ", payment=" + payment +
                ", user=" + user +
                ", address=" + address +
                ", orderDetails=" + orderDetails +
                '}';
    }
}
