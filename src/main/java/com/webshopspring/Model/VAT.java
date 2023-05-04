package com.webshop.Model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "VAT")
public class VAT {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private long id;

    @Column(name = "Percentage")
    private int percentage;

    @OneToMany(mappedBy = "vat")
    private List<Product> products;

    public VAT() {
    }

    public VAT(int percentage) {
        this.percentage = percentage;
    }

    public VAT(int percentage, List<Product> products) {
        this.percentage = percentage;
        this.products = products;
    }

    public long getId() {
        return id;
    }

    public int getPercentage() {
        return percentage;
    }

    public void setPercentage(int percentage) {
        this.percentage = percentage;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
