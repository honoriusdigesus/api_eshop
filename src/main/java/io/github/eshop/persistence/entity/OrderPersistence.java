package io.github.eshop.persistence.entity;

import io.github.eshop.data.entity.Product;
import io.github.eshop.data.entity.Shipping_Address;
import io.github.eshop.data.entity.User;

import java.util.List;


public class OrderPersistence {

    private Integer id;
    private User user;
    private String paymentMethod;
    private Shipping_Address address;
    private List<OrderProductPersistence> items;
    private double totalPrice;

    public OrderPersistence() {
    }

    public OrderPersistence(Integer id, String paymentMethod, User user, Shipping_Address address, List<OrderProductPersistence> items, double totalPrice) {
        this.id = id;
        this.paymentMethod = paymentMethod;
        this.user = user;
        this.address = address;
        this.items = items;
        this.totalPrice = totalPrice;
    }

    public OrderPersistence(Product product, Integer quantity) {
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

    public List<OrderProductPersistence> getItems() {
        return items;
    }

    public void setItems(List<OrderProductPersistence> items) {
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
        return "OrderPersistence{" +
                "id=" + id +
                ", user=" + user +
                ", paymentMethod='" + paymentMethod + '\'' +
                ", address=" + address +
                ", items=" + items +
                ", totalPrice=" + totalPrice +
                '}';
    }
}
