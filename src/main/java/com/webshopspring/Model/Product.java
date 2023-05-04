package com.webshop.Model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private long id;

    @Column(name = "Name", length = 50)
    private String name;

    @Column(name = "Price")
    private float price;

    @Column(name = "Stock")
    private int stock;

    @ManyToOne
    @JoinColumn(name = "VATID", referencedColumnName = "ID")
    private VAT vat;

    @ManyToOne
    @JoinColumn(name = "CategoryID", referencedColumnName = "ID")
    private Category category;

    @Column(name = "Description")
    private String description;

    @OneToMany(mappedBy = "product")
    private List<OrderItem> orderItems;

    public Product() {
    }

    public Product(String name, float price, int stock, String description) {
        this.name = name;
        this.price = price;
        this.stock = stock;
        this.description = description;
    }

    public Product(String name, float price, int stock, Category category, String description) {
        this.name = name;
        this.price = price;
        this.stock = stock;
        this.category = category;
        this.description = description;
    }

    public Product(String name, float price, int stock, VAT vat, Category category, String description) {
        this.name = name;
        this.price = price;
        this.stock = stock;
        this.vat = vat;
        this.category = category;
        this.description = description;
    }

    public Product(String name, float price, int stock, VAT vat, Category category, String description, List<OrderItem> orderItems) {
        this.name = name;
        this.price = price;
        this.stock = stock;
        this.vat = vat;
        this.category = category;
        this.description = description;
        this.orderItems = orderItems;
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

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public VAT getVat() {
        return vat;
    }

    public void setVat(VAT vat) {
        this.vat = vat;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }
}
