package io.github.eshop.data.entity;

import io.github.eshop.enums.Payment_Method;
import jakarta.persistence.Entity;
import jakarta.persistence.*;
import jakarta.persistence.Table;

@Entity
@Table(name = "payment")
public class Payment {
    @Id
    @GeneratedValue
    private Integer id;
    private Payment_Method paymentMethod;
    private String description;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Payment_Method getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(Payment_Method paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Payment() {
    }

    public Payment(Integer id, Payment_Method paymentMethod, String description) {
        this.id = id;
        this.paymentMethod = paymentMethod;
        this.description = description;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "id=" + id +
                ", paymentMethod=" + paymentMethod +
                ", description='" + description + '\'' +
                '}';
    }
}
