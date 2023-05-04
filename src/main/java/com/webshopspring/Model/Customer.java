package com.webshop.Model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private long id;

    @Column(name = "Name", length = 50)
    private String name;

    @Column(name = "BankAccount", length = 50)
    private String bankAccount;

    @Column(name = "Login", length = 50)
    private String login;

    @Column(name = "Password", length = 50)
    private String password;

    @Column(name = "Email", length = 50)
    private String email;

    @OneToOne
    @JoinColumn(name = "MainCustomerSiteID", referencedColumnName = "ID")
    private CustomerSite mainCustomerSite;

    @OneToMany(mappedBy = "customer")
    private List<CustomerSite> customerSites;

    public Customer() {
    }

    public Customer(String name, String bankAccount, String login, String password, String email) {
        this.name = name;
        this.bankAccount = bankAccount;
        this.login = login;
        this.password = password;
        this.email = email;
    }

    public Customer(String name, String bankAccount, String login, String password, String email, CustomerSite mainCustomerSite) {
        this.name = name;
        this.bankAccount = bankAccount;
        this.login = login;
        this.password = password;
        this.email = email;
        this.mainCustomerSite = mainCustomerSite;
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

    public String getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(String bankAccount) {
        this.bankAccount = bankAccount;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public CustomerSite getMainCustomerSite() {
        return mainCustomerSite;
    }

    public void setMainCustomerSite(CustomerSite mainCustomerSite) {
        this.mainCustomerSite = mainCustomerSite;
    }

    public List<CustomerSite> getCustomerSites() {
        if(customerSites == null)
            customerSites = new ArrayList<CustomerSite>();
        return customerSites;
    }

    public void setCustomerSites(List<CustomerSite> customerSites) {
        this.customerSites = customerSites;
    }
}
