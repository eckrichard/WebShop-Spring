package com.webshop.Service;

import com.webshop.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StarterDatabaseService {
    private final CustomerRepository customerRepository;
    private final CategoryRepository categoryRepository;
    private final CustomerSiteRepository customerSiteRepository;
    private final InvoiceRepository invoiceRepository;
    private final InvoiceIssuerRepository invoiceIssuerRepository;
    private final InvoiceItemRepository invoiceItemRepository;
    private final OrderRepository orderRepository;
    private final OrderItemRepository orderItemRepository;
    private final PaymentMethodRepository paymentMethodRepository;
    private final ProductRepository productRepository;
    private final StatusRepository statusRepository;
    private final VATRepository vatRepository;

    @Autowired
    public StarterDatabaseService(CustomerRepository customerRepository,
                                  CategoryRepository categoryRepository,
                                  CustomerSiteRepository customerSiteRepository,
                                  InvoiceRepository invoiceRepository,
                                  InvoiceIssuerRepository invoiceIssuerRepository,
                                  InvoiceItemRepository invoiceItemRepository,
                                  OrderRepository orderRepository,
                                  OrderItemRepository orderItemRepository,
                                  PaymentMethodRepository paymentMethodRepository,
                                  ProductRepository productRepository,
                                  StatusRepository statusRepository,
                                  VATRepository vatRepository) {
        this.customerRepository = customerRepository;
        this.categoryRepository = categoryRepository;
        this.customerSiteRepository = customerSiteRepository;
        this.invoiceRepository = invoiceRepository;
        this.invoiceIssuerRepository = invoiceIssuerRepository;
        this.invoiceItemRepository = invoiceItemRepository;
        this.orderRepository = orderRepository;
        this.orderItemRepository = orderItemRepository;
        this.paymentMethodRepository = paymentMethodRepository;
        this.productRepository = productRepository;
        this.statusRepository = statusRepository;
        this.vatRepository = vatRepository;
    }
}
