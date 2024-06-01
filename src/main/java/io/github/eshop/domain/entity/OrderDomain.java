package io.github.eshop.domain.entity;

import java.time.LocalDateTime;

public class OrderDomain {

    private Integer id;
    private UserDomain user;
    private LocalDateTime date;
    private String status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public UserDomain getUser() {
        return user;
    }

    public void setUser(UserDomain user) {
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

    public OrderDomain() {
    }

    public OrderDomain(Integer id, UserDomain user, LocalDateTime date, String status) {
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
