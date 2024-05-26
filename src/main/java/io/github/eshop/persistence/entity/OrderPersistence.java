package io.github.eshop.persistence.entity;

import java.util.List;


public class OrderPersistence {

    private Integer id;
    private UserPersistence user;
    private String paymentMethod;
    private AddressPersistence address;
    private List<OrderProductPersistence> items;
    private double totalPrice;

    public OrderPersistence() {
    }

    public OrderPersistence(Integer id, String paymentMethod, UserPersistence user, AddressPersistence address, List<OrderProductPersistence> items, double totalPrice) {
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

    public UserPersistence getUser() {
        return user;
    }

    public void setUser(UserPersistence user) {
        this.user = user;
    }

    public AddressPersistence getAddress() {
        return address;
    }

    public void setAddress(AddressPersistence address) {
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
