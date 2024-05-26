package io.github.eshop.domain.entity;

import io.github.eshop.data.entity.OrderProduct;
import io.github.eshop.data.entity.Shipping_Address;
import io.github.eshop.data.entity.User;
import jakarta.persistence.*;

import java.util.List;


public class OrderDomain {

    private Integer id;
    private UserDomain user;
    private String paymentMethod;
    private AddressDomain address;
    private List<OrderProductDomain> items;
    private double totalPrice;

    public OrderDomain() {
    }

    public OrderDomain(Integer id, String paymentMethod, UserDomain user, AddressDomain address, List<OrderProductDomain> items, double totalPrice) {
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

    public UserDomain getUser() {
        return user;
    }

    public void setUser(UserDomain user) {
        this.user = user;
    }

    public AddressDomain getAddress() {
        return address;
    }

    public void setAddress(AddressDomain address) {
        this.address = address;
    }

    public List<OrderProductDomain> getItems() {
        return items;
    }

    public void setItems(List<OrderProductDomain> items) {
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

    @Override
    public String toString() {
        return "OrderDomain{" +
                "id=" + id +
                ", user=" + user +
                ", paymentMethod='" + paymentMethod + '\'' +
                ", address=" + address +
                ", items=" + items +
                ", totalPrice=" + totalPrice +
                '}';
    }
}
