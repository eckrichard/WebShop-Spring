package com.webshop.Model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private long id;

    @Column(name = "Date")
    private LocalDate date;

    @Column(name = "Deadline")
    private LocalDate deadline;

    @ManyToOne
    @JoinColumn(name = "CustomerSiteID", referencedColumnName = "ID")
    private CustomerSite customerSite;

    @ManyToOne
    @JoinColumn(name = "StatusID", referencedColumnName = "ID")
    private Status status;

    @ManyToOne
    @JoinColumn(name = "PaymentMethodID", referencedColumnName = "ID")
    private PaymentMethod paymentMethod;

    @OneToMany(mappedBy = "order")
    private List<Invoice> invoices;

    @OneToMany(mappedBy = "order")
    private List<OrderItem> orderItems;

    public Order() {
    }

    public Order(LocalDate date, LocalDate deadline) {
        this.date = date;
        this.deadline = deadline;
    }

    public Order(LocalDate date, LocalDate deadline, CustomerSite customerSite) {
        this.date = date;
        this.deadline = deadline;
        this.customerSite = customerSite;
    }

    public Order(LocalDate date, LocalDate deadline, CustomerSite customerSite, Status status, PaymentMethod paymentMethod) {
        this.date = date;
        this.deadline = deadline;
        this.customerSite = customerSite;
        this.status = status;
        this.paymentMethod = paymentMethod;
    }

    public long getId() {
        return id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate name) {
        this.date = name;
    }

    public LocalDate getDeadline() {
        return deadline;
    }

    public void setDeadline(LocalDate price) {
        this.deadline = price;
    }

    public CustomerSite getCustumerSite() {
        return customerSite;
    }

    public void setCustumerSite(CustomerSite customerSite) {
        this.customerSite = customerSite;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public PaymentMethod getPaymantMethod() {
        return paymentMethod;
    }

    public void setPaymantMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }
}
