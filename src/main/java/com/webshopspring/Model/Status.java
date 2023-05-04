package com.webshop.Model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "status")
public class Status {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private long id;

    @Column(name = "Name", length = 20)
    private String name;

    @OneToMany(mappedBy = "status")
    private List<OrderItem> orderItems;

    @OneToMany(mappedBy = "status")
    private List<Order> orders;

    public Status() {
    }

    public Status(String name) {
        this.name = name;
    }

    public Status(String name, List<OrderItem> orderItems, List<Order> orders) {
        this.name = name;
        this.orderItems = orderItems;
        this.orders = orders;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }
}
