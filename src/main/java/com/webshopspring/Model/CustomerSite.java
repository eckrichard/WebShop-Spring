package com.webshop.Model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "customer_site")
public class CustomerSite {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private long id;

    @Column(name = "ZipCode", length = 4)
    private String zipcode;

    @Column(name = "City", length = 50)
    private String city;

    @Column(name = "Street", length = 50)
    private String street;

    @Column(name = "Tel", length = 15)
    private String tel;

    @Column(name = "Fax", length = 15)
    private String fax;

    @OneToOne(mappedBy = "mainCustomerSite")
    private Customer mainCustomer;

    @ManyToOne
    @JoinColumn(name = "CustomerID", referencedColumnName = "ID")
    private Customer customer;

    @OneToMany(mappedBy = "customerSite")
    private List<Order> orders;

    public CustomerSite() {
    }

    public CustomerSite(String zipcode, String city, String street, String tel, String fax) {
        this.zipcode = zipcode;
        this.city = city;
        this.street = street;
        this.tel = tel;
        this.fax = fax;
    }

    public CustomerSite(String zipcode, String city, String street, String tel, String fax, Customer customer) {
        this.zipcode = zipcode;
        this.city = city;
        this.street = street;
        this.tel = tel;
        this.fax = fax;
        this.customer = customer;
    }

    public long getId() {
        return id;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public Customer getMainCustomer() {
        return mainCustomer;
    }

    public void setMainCustomer(Customer mainCustomer) {
        this.mainCustomer = mainCustomer;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }
}
