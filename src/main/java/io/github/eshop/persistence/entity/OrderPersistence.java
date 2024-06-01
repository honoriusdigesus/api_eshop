package io.github.eshop.persistence.entity;

import java.time.LocalDateTime;

public class OrderPersistence {

    private Integer id;
    private UserPersistence user;
    private LocalDateTime date;
    private String status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public UserPersistence getUser() {
        return user;
    }

    public void setUser(UserPersistence user) {
        this.user = user;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public OrderPersistence() {
    }

    public OrderPersistence(Integer id, UserPersistence user, LocalDateTime date, String status) {
        this.id = id;
        this.user = user;
        this.date = date;
        this.status = status;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", user=" + user +
                ", date=" + date +
                ", status='" + status + '\'' +
                '}';
    }
}
