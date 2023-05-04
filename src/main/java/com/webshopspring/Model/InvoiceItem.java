package com.webshop.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "invoice_item")
public class InvoiceItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private long id;

    @Column(name = "Name", length = 50)
    private String name;

    @Column(name = "Amount")
    private int amount;

    @Column(name = "Price")
    private float price;

    @Column(name = "VATPercentage")
    private int vatPercentage;

    @ManyToOne
    @JoinColumn(name = "InvoiceID", referencedColumnName = "ID")
    private Invoice invoice;

    @ManyToOne
    @JoinColumn(name = "OrderItemID", referencedColumnName = "ID")
    private OrderItem orderItem;

    public InvoiceItem() {
    }

    public InvoiceItem(String name, int amount, float price, int vatPercentage) {
        this.name = name;
        this.amount = amount;
        this.price = price;
        this.vatPercentage = vatPercentage;
    }

    public InvoiceItem(String name, int amount, float price, int vatPercentage, Invoice invoice, OrderItem orderItem) {
        this.name = name;
        this.amount = amount;
        this.price = price;
        this.vatPercentage = vatPercentage;
        this.invoice = invoice;
        this.orderItem = orderItem;
    }

    public InvoiceItem(String name, int amount, float price, int vatPercentage, Invoice invoice) {
        this.name = name;
        this.amount = amount;
        this.price = price;
        this.vatPercentage = vatPercentage;
        this.invoice = invoice;
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

    public int getVatPercentage() {
        return vatPercentage;
    }

    public void setVatPercentage(int vatPercentage) {
        this.vatPercentage = vatPercentage;
    }

    public Invoice getInvoice() {
        return invoice;
    }

    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }

    public OrderItem getOrderItem() {
        return orderItem;
    }

    public void setOrderItem(OrderItem orderItem) {
        this.orderItem = orderItem;
    }
}
