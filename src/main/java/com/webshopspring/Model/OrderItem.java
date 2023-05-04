package com.webshop.Model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "order_item")
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private long id;

    @Column(name = "Amount")
    private int amount;

    @Column(name = "Price")
    private float price;

    @ManyToOne
    @JoinColumn(name = "OrderID", referencedColumnName = "ID")
    private Order order;

    @ManyToOne
    @JoinColumn(name = "ProductID", referencedColumnName = "ID")
    private Product product;

    @ManyToOne
    @JoinColumn(name = "StatusID", referencedColumnName = "ID")
    private Status status;

    @OneToMany(mappedBy = "orderItem")
    private List<InvoiceItem> invoiceItems;

    public OrderItem() {
    }

    public OrderItem(int amount, float price) {
        this.amount = amount;
        this.price = price;
    }

    public OrderItem(int amount, float price, Order order, Product product, Status status) {
        this.amount = amount;
        this.price = price;
        this.order = order;
        this.product = product;
        this.status = status;
    }

    public OrderItem(int amount, float price, Order order) {
        this.amount = amount;
        this.price = price;
        this.order = order;
    }

    public OrderItem(int amount, float price, Order order, Product product, Status status, List<InvoiceItem> invoiceItems) {
        this.amount = amount;
        this.price = price;
        this.order = order;
        this.product = product;
        this.status = status;
        this.invoiceItems = invoiceItems;
    }

    public long getId() {
        return id;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public List<InvoiceItem> getInvoiceItems() {
        return invoiceItems;
    }

    public void setInvoiceItems(List<InvoiceItem> invoiceItems) {
        this.invoiceItems = invoiceItems;
    }
}
