package com.webshop.Model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "paymant_method")
public class PaymentMethod {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private long id;

    @Column(name = "Method", length = 20)
    private String method;

    @Column(name = "Deadline")
    private int deadline;

    @OneToMany(mappedBy = "paymantMethod")
    private List<Order> orders;

    public PaymentMethod() {
    }

    public PaymentMethod(String method, int deadline) {
        this.method = method;
        this.deadline = deadline;
    }

    public PaymentMethod(String method, int deadline, List<Order> orders) {
        this.method = method;
        this.deadline = deadline;
        this.orders = orders;
    }

    public long getId() {
        return id;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public int getDeadline() {
        return deadline;
    }

    public void setDeadline(int deadline) {
        this.deadline = deadline;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }
}
