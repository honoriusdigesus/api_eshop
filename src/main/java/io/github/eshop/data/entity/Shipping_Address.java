package io.github.eshop.data.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "address")
public class Shipping_Address {
    @Id
    @GeneratedValue
    private Integer id;
    private String country;
    private String state;
    private String city;
    private String address_line; //Direccin completa, ejemplo: CR12AA#12-34 Apto 123 Conjunto 1 Barrio La Locura
    @OneToOne
    @JoinColumn(name="users_id")
    private User users;

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress_line() {
        return address_line;
    }

    public void setAddress_line(String address_line) {
        this.address_line = address_line;
    }

    public User getUsers() {
        return users;
    }

    public void setUsers(User users) {
        this.users = users;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Shipping_Address() {
    }

    public Shipping_Address(Integer id, String country, String state, String city, String address_line, User users) {
        this.id = id;
        this.country = country;
        this.state = state;
        this.city = city;
        this.address_line = address_line;
        this.users = users;
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", country='" + country + '\'' +
                ", state='" + state + '\'' +
                ", city='" + city + '\'' +
                ", address_line='" + address_line + '\'' +
                ", users=" + users +
                '}';
    }
}
