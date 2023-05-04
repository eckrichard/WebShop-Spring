package com.webshop.Model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "invoice_issuer")
public class InvoiceIssuer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private long id;

    @Column(name = "Name", length = 50)
    private String name;

    @Column(name = "ZipCode", length = 4)
    private String zipCode;

    @Column(name = "City", length = 50)
    private String city;

    @Column(name = "Street", length = 50)
    private String street;

    @Column(name = "TaxIdentifier", length = 20)
    private String taxIdentifier;

    @Column(name = "BankAccount", length = 50)
    private String bankAccount;

    @OneToMany(mappedBy = "invoiceIssuer")
    private List<Invoice> invoices;

    public InvoiceIssuer() {
    }

    public InvoiceIssuer(String name, String zipCode, String city, String street, String taxIdentifier, String bankAccount) {
        this.name = name;
        this.zipCode = zipCode;
        this.city = city;
        this.street = street;
        this.taxIdentifier = taxIdentifier;
        this.bankAccount = bankAccount;
    }

    public InvoiceIssuer(String name, String zipCode, String city, String street, String taxIdentifier, String bankAccount, List<Invoice> invoices) {
        this.name = name;
        this.zipCode = zipCode;
        this.city = city;
        this.street = street;
        this.taxIdentifier = taxIdentifier;
        this.bankAccount = bankAccount;
        this.invoices = invoices;
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

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
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

    public String getTaxIdentifier() {
        return taxIdentifier;
    }

    public void setTaxIdentifier(String taxIdentifier) {
        this.taxIdentifier = taxIdentifier;
    }

    public String getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(String bankAccount) {
        this.bankAccount = bankAccount;
    }

    public List<Invoice> getInvoices() {
        return invoices;
    }

    public void setInvoices(List<Invoice> invoices) {
        this.invoices = invoices;
    }
}
