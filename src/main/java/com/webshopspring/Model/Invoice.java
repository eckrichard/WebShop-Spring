package com.webshop.Model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "invoice")
public class Invoice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private long id;

    @Column(name = "CustomerName", length = 50)
    private String customerName;

    @Column(name = "CustomerZipCode", length = 4)
    private String customerZipCode;

    @Column(name = "CustomerCity", length = 50)
    private String customerCity;

    @Column(name = "CustomerStreet", length = 50)
    private String customerStreet;

    @Column(name = "PrintedCopies")
    private int printedCopies;

    @Column(name = "Cancelled")
    private boolean cancelled;

    @Column(name = "PaymentMethod", length = 20)
    private String paymentMethod;

    @Column(name = "CreationDate")
    private LocalDate creationDate;

    @Column(name = "DeliveryDate")
    private LocalDate deliveryDate;

    @Column(name = "PaymentDeadline")
    private LocalDate paymentDeadline;

    @ManyToOne
    @JoinColumn(name = "InvoiceIssuerID", referencedColumnName = "ID")
    private InvoiceIssuer invoiceIssuer;

    @ManyToOne
    @JoinColumn(name = "OrderID", referencedColumnName = "ID")
    private Order order;

    @OneToMany(mappedBy = "invoice")
    private List<InvoiceItem> invoiceItems;

    public Invoice() {
    }



    public Invoice(String customerName, String customerZipCode, String customerCity, String customerStreet, int printedCopies, boolean cancelled, String paymentMethod, LocalDate creationDate, LocalDate deliveryDate, LocalDate paymentDeadline) {
        this.customerName = customerName;
        this.customerZipCode = customerZipCode;
        this.customerCity = customerCity;
        this.customerStreet = customerStreet;
        this.printedCopies = printedCopies;
        this.cancelled = cancelled;
        this.paymentMethod = paymentMethod;
        this.creationDate = creationDate;
        this.deliveryDate = deliveryDate;
        this.paymentDeadline = paymentDeadline;
    }

    public Invoice(String customerName, String customerZipCode, String customerCity, String customerStreet, int printedCopies, boolean cancelled, String paymentMethod, LocalDate creationDate, LocalDate deliveryDate, LocalDate paymentDeadline, InvoiceIssuer invoiceIssuer, Order order) {
        this.customerName = customerName;
        this.customerZipCode = customerZipCode;
        this.customerCity = customerCity;
        this.customerStreet = customerStreet;
        this.printedCopies = printedCopies;
        this.cancelled = cancelled;
        this.paymentMethod = paymentMethod;
        this.creationDate = creationDate;
        this.deliveryDate = deliveryDate;
        this.paymentDeadline = paymentDeadline;
        this.invoiceIssuer = invoiceIssuer;
        this.order = order;
    }

    public Invoice(String customerName, String customerZipCode, String customerCity, String customerStreet, int printedCopies, boolean cancelled, String paymentMethod, LocalDate creationDate, LocalDate deliveryDate, LocalDate paymentDeadline, InvoiceIssuer invoiceIssuer, Order order, List<InvoiceItem> invoiceItems) {
        this.customerName = customerName;
        this.customerZipCode = customerZipCode;
        this.customerCity = customerCity;
        this.customerStreet = customerStreet;
        this.printedCopies = printedCopies;
        this.cancelled = cancelled;
        this.paymentMethod = paymentMethod;
        this.creationDate = creationDate;
        this.deliveryDate = deliveryDate;
        this.paymentDeadline = paymentDeadline;
        this.invoiceIssuer = invoiceIssuer;
        this.order = order;
        this.invoiceItems = invoiceItems;
    }

    public long getId() {
        return id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerZipCode() {
        return customerZipCode;
    }

    public void setCustomerZipCode(String customerZipCode) {
        this.customerZipCode = customerZipCode;
    }

    public String getCustomerCity() {
        return customerCity;
    }

    public void setCustomerCity(String customerCity) {
        this.customerCity = customerCity;
    }

    public String getCustomerStreet() {
        return customerStreet;
    }

    public void setCustomerStreet(String customerStreet) {
        this.customerStreet = customerStreet;
    }

    public int getPrintedCopies() {
        return printedCopies;
    }

    public void setPrintedCopies(int printedCopies) {
        this.printedCopies = printedCopies;
    }

    public boolean isCancelled() {
        return cancelled;
    }

    public void setCancelled(boolean cancelled) {
        this.cancelled = cancelled;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public LocalDate getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(LocalDate deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public LocalDate getPaymentDeadline() {
        return paymentDeadline;
    }

    public void setPaymentDeadline(LocalDate paymentDeadline) {
        this.paymentDeadline = paymentDeadline;
    }

    public InvoiceIssuer getInvoiceIssuer() {
        return invoiceIssuer;
    }

    public void setInvoiceIssuer(InvoiceIssuer invoiceIssuer) {
        this.invoiceIssuer = invoiceIssuer;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public List<InvoiceItem> getInvoiceItems() {
        return invoiceItems;
    }

    public void setInvoiceItems(List<InvoiceItem> invoiceItems) {
        this.invoiceItems = invoiceItems;
    }
}
