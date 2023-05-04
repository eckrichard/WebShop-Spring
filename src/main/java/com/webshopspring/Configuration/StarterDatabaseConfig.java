package com.webshop.Configuration;

import com.webshop.Model.*;
import com.webshop.Repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

@Configuration
public class StarterDatabaseConfig {
    @Bean
    CommandLineRunner CommandLineRunner(
            CustomerRepository customerRepository,
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
            VATRepository vatRepository
    ){
        return args -> {
            Category category1 = new Category(
                    "Toy"
            );

            Category category2 = new Category(
                    "Play house"
            );

            Category category3 = new Category(
                    "Baby category1",
                    category1
            );

            Category category4 = new Category(
                    "Construction category1",
                    category1
            );

            Category category5 = new Category(
                    "Wooden category1",
                    category1
            );

            Category category6 = new Category(
                    "Plush figure",
                    category1
            );

            Category category7 = new Category(
                    "Bicycles",
                    category1
            );

            Category category8 = new Category(
                    "Months 0-6",
                    category3
            );

            Category category9 = new Category(
                    "Months 6-18",
                    category3
            );

            Category category10 = new Category(
                    "Months 18-24",
                    category3
            );

            Category category11 = new Category(
                    "DUPLO",
                    category4
            );

            Category category12 = new Category(
                    "LEGO",
                    category4
            );

            Category category13 = new Category(
                    "Building items",
                    category4
            );

            Category category14 = new Category(
                    "Building blocks",
                    category5
            );

            Category category15 = new Category(
                    "Toys for skill development",
                    category5
            );

            Category category16 = new Category(
                    "Logic toys",
                    category5
            );

            Category category17 = new Category(
                    "Craftwork toys",
                    category5
            );

            Category category18 = new Category(
                    "Baby taxis",
                    category7
            );

            Category category19 = new Category(
                    "Motors",
                    category7
            );

            Category category20 = new Category(
                    "Tricycle",
                    category7
            );

            categoryRepository.saveAll(
                    List.of(category1, category2, category3, category4,
                            category5, category6, category7, category8,
                            category9, category10, category11, category12,
                            category13, category14, category15, category16,
                            category17, category18, category19, category20)
            );
            
            Customer customer1 = new Customer(
                    "Cody Shelton",
                    "16489665-05899845-10000038",
                    "cshelton",
                    "huti9haj1s",
                    "cshelton@freemail.hu"
            );

            Customer customer2 = new Customer(
                    "Erika Mckenzie",
                    "54255831-15615432-25015126",
                    "erikkka",
                    "gandalf67j",
                    "erikkka@hotmail.com"
            );

            Customer customer3 = new Customer(
                    "Krista Hansen",
                    "25894467-12005362-59815126",
                    "kris",
                    "jag7guFs",
                    "kris.hansen@gmail.com"
            );

            customerRepository.saveAll(
                    List.of(customer1, customer2, customer3)
            );

            CustomerSite site1 = new CustomerSite(
                    "1114",
                    "Budapest",
                    "Bud Spencer street 16.",
                    "061-569-23-99",
                    null,
                    customer2
            );

            CustomerSite site2 = new CustomerSite(
                    "1051",
                    "Budapest",
                    "Andrássy út 22.",
                    "061-457-11-03",
                    "061-457-11-04",
                    customer1
            );

            CustomerSite site3 = new CustomerSite(
                    "3000",
                    "Hatvan",
                    "Vörösmarty tér. 5.",
                    "0646-319-169",
                    "0646-319-168",
                    customer2
            );

            CustomerSite site4 = new CustomerSite(
                    "2045",
                    "Törökbálint",
                    "Main street 17.",
                    "0623-200-156",
                    "0623-200-155",
                    customer3
            );

            customerSiteRepository.saveAll(
                    List.of(site1, site2, site3, site4)
            );

            customer1.setMainCustomerSite(site2);
            customer2.setMainCustomerSite(site1);
            customer3.setMainCustomerSite(site4);

            Invoice invoice1 = new Invoice(
                    "Erika Mckenzie",
                    "3000",
                    "Hatvan",
                    "Second street 5.",
                    2,
                    false,
                    "Cash",
                    LocalDate.of(2008, 1, 30),
                    LocalDate.of(2008, 1, 30),
                    LocalDate.of(2008, 1, 30)
            );

            Invoice invoice2 = new Invoice(
                    "Cody Shelton",
                    "1051",
                    "Budapest",
                    "First street 22.",
                    2,
                    false,
                    "Wire transfer 8",
                    LocalDate.of(2008, 2, 14),
                    LocalDate.of(2008, 2, 15),
                    LocalDate.of(2008, 2, 23)
            );

            invoiceRepository.saveAll(
                    List.of(invoice1, invoice2)
            );

            InvoiceIssuer invoiceIssuer1 = new InvoiceIssuer(
                    "ToysRus",
                    "1119",
                    "Budapest",
                    "Main street 23",
                    "15684995-2-32",
                    "259476332-15689799-10020065"
            );

            InvoiceIssuer invoiceIssuer2 = new InvoiceIssuer(
                    "BabiesRus",
                    "1119",
                    "Budapest",
                    "Main street 23",
                    "68797867-1-32",
                    "259476332-15689799-10020065"
            );

            invoiceIssuerRepository.saveAll(
                    List.of(invoiceIssuer1, invoiceIssuer2)
            );

            invoice1.setInvoiceIssuer(invoiceIssuer1);
            invoice2.setInvoiceIssuer(invoiceIssuer1);

            InvoiceItem invoiceItem1 = new InvoiceItem(
                    "Fisher Price hammer",
                    2,
                    8356,
                    27,
                    invoice1
            );

            InvoiceItem invoiceItem2 = new InvoiceItem(
                    "Maxi Blocks 56 pcs",
                    1,
                    1854,
                    27,
                    invoice1
            );

            InvoiceItem invoiceItem3 = new InvoiceItem(
                    "Colorful baby book",
                    5,
                    1738,
                    27,
                    invoice1
            );

            InvoiceItem invoiceItem4 = new InvoiceItem(
                    "Activity playgim",
                    2,
                    7488,
                    27,
                    invoice2
            );

            InvoiceItem invoiceItem5 = new InvoiceItem(
                    "Baby telephone",
                    3,
                    3725,
                    27,
                    invoice2
            );

            invoiceItemRepository.saveAll(
                    List.of(invoiceItem1, invoiceItem2, invoiceItem3, invoiceItem4, invoiceItem5)
            );

            Order order1 = new Order(
                    LocalDate.of(2020, 1, 18),
                    LocalDate.of(2020, 1, 30),
                    site3
            );

            Order order2 = new Order(
                    LocalDate.of(2020, 2, 13),
                    LocalDate.of(2020, 2, 15),
                    site2
            );

            Order order3 = new Order(
                    LocalDate.of(2020, 2, 15),
                    LocalDate.of(2020, 2, 20),
                    site1
            );

            Order order4 = new Order(
                    LocalDate.of(2020, 2, 15),
                    LocalDate.of(2020, 2, 20),
                    site2
            );

            orderRepository.saveAll(
                    List.of(order1, order2, order3, order4)
            );

            invoice1.setOrder(order1);
            invoice1.setOrder(order2);

            OrderItem orderItem1 = new OrderItem(
                    2, 8356, order1
            );

            OrderItem orderItem2 = new OrderItem(
                    1, 1854, order1
            );

            OrderItem orderItem3 = new OrderItem(
                    5, 1738, order1
            );

            OrderItem orderItem4 = new OrderItem(
                    2, 7488, order2
            );

            OrderItem orderItem5 = new OrderItem(
                    3, 3725, order2
            );

            OrderItem orderItem6 = new OrderItem(
                    1, 4362, order3
            );

            OrderItem orderItem7 = new OrderItem(
                    6, 1854, order3
            );

            OrderItem orderItem8 = new OrderItem(
                    2, 6399, order3
            );

            OrderItem orderItem9 = new OrderItem(
                    5, 1738, order3
            );

            OrderItem orderItem10 = new OrderItem(
                    23, 3725, order4
            );

            OrderItem orderItem11 = new OrderItem(
                    12, 1738, order4
            );

            OrderItem orderItem12 = new OrderItem(
                    10, 27563, order4
            );

            OrderItem orderItem13 = new OrderItem(
                    25, 7488, order4
            );

            orderItemRepository.saveAll(
                    List.of(orderItem1, orderItem2, orderItem3, orderItem4, orderItem5, orderItem6, orderItem7,
                            orderItem8, orderItem9, orderItem10, orderItem11, orderItem12, orderItem13)
            );

            invoiceItem1.setOrderItem(orderItem1);
            invoiceItem1.setOrderItem(orderItem2);
            invoiceItem1.setOrderItem(orderItem3);
            invoiceItem1.setOrderItem(orderItem4);
            invoiceItem1.setOrderItem(orderItem5);

            PaymentMethod paymentMethod1 = new PaymentMethod(
                    "Cash",
                    0
            );
            PaymentMethod paymentMethod2 = new PaymentMethod(
                    "Wire transfer 8",
                    8
            );
            PaymentMethod paymentMethod3 = new PaymentMethod(
                    "Wire transfer 15",
                    15
            );
            PaymentMethod paymentMethod4 = new PaymentMethod(
                    "Wire transfer 30",
                    30
            );
            PaymentMethod paymentMethod5 = new PaymentMethod(
                    "Credit card",
                    0
            );
            PaymentMethod paymentMethod6 = new PaymentMethod(
                    "Collect package",
                    0
            );

            paymentMethodRepository.saveAll(
                    List.of(paymentMethod1, paymentMethod2, paymentMethod3,
                            paymentMethod4, paymentMethod5, paymentMethod6)
            );

            order1.setPaymantMethod(paymentMethod1);
            order1.setPaymantMethod(paymentMethod2);
            order1.setPaymantMethod(paymentMethod1);
            order1.setPaymantMethod(paymentMethod5);

            Product product1 = new Product(
                    "Activity playgim",
                    7488,
                    21,
                    category8,
                            "Requires battery (not part of the package)."
            );

            Product product2 = new Product(
                    "Colorful baby book",
                    1738,
                    58,
                    category8,
                    "Round ball with nice colors."
            );

            Product product3 = new Product(
                    "Baby telephone",
                    3725,
                    18,
                    category9,
                    "Music is good for the ears. Enjoy."
            );

            Product product4 = new Product(
                    "Fisher Price hammer toy",
                    8356,
                    58,
                    category10,
                    null
            );

            Product product5 = new Product(
                    "Mega Bloks 24 pcs",
                    4325,
                    47,
                    category14,
                    null
            );

            Product product6 = new Product(
                    "Maxi Blocks 56 pcs",
                    1854,
                    36,
                    category14,
                    null
            );

            Product product7 = new Product(
                    "Building Blocks 80 pcs",
                    4362,
                    25,
                    category14,
                    null
            );

            Product product8 = new Product(
                    "Lego City harbour",
                    27563,
                    12,
                    category13,
                    "Number of elements: 695."
            );

            Product product9 = new Product(
                    "Lego Duplo Excavator",
                    6399,
                    26,
                    category11,
                    null
            );

            Product product10 = new Product(
                    "Child supervision for 1 hour",
                    800,
                    0,
                    category2,
                    null
            );

            productRepository.saveAll(
                    List.of(product1, product2, product3, product4, product5,
                            product6, product7, product8, product9, product10)
            );

            orderItem1.setProduct(product4);
            orderItem2.setProduct(product6);
            orderItem3.setProduct(product2);
            orderItem4.setProduct(product1);
            orderItem5.setProduct(product3);
            orderItem6.setProduct(product7);
            orderItem7.setProduct(product6);
            orderItem8.setProduct(product9);
            orderItem9.setProduct(product2);
            orderItem10.setProduct(product3);
            orderItem11.setProduct(product2);
            orderItem12.setProduct(product8);
            orderItem13.setProduct(product1);

            Status status1 = new Status(
                    "New"
            );
            Status status2 = new Status(
                    "Processing"
            );
            Status status3 = new Status(
                    "Packaged"
            );
            Status status4 = new Status(
                    "In transit"
            );
            Status status5 = new Status(
                    "Delivered"
            );

            statusRepository.saveAll(
                    List.of(status1, status2, status3, status4, status5)
            );

            order1.setStatus(status5);
            order2.setStatus(status5);
            order3.setStatus(status2);
            order4.setStatus(status3);

            orderItem1.setStatus(status5);
            orderItem2.setStatus(status5);
            orderItem3.setStatus(status5);
            orderItem4.setStatus(status5);
            orderItem5.setStatus(status5);
            orderItem6.setStatus(status3);
            orderItem7.setStatus(status2);
            orderItem8.setStatus(status3);
            orderItem9.setStatus(status1);
            orderItem10.setStatus(status3);
            orderItem11.setStatus(status3);
            orderItem12.setStatus(status3);
            orderItem13.setStatus(status3);

            VAT vat1 = new VAT(
                    0
            );
            VAT vat2 = new VAT(
                    15
            );
            VAT vat3 = new VAT(
                    27
            );
            vatRepository.saveAll(
                    List.of(vat1, vat2, vat3)
            );

            product1.setVat(vat3);
            product2.setVat(vat3);
            product3.setVat(vat3);
            product4.setVat(vat3);
            product5.setVat(vat3);
            product6.setVat(vat3);
            product7.setVat(vat3);
            product8.setVat(vat3);
            product9.setVat(vat3);
            product10.setVat(vat2);

            categoryRepository.saveAll(
                    List.of(category1, category2, category3, category4,
                            category5, category6, category7, category8,
                            category9, category10, category11, category12,
                            category13, category14, category15, category16,
                            category17, category18, category19, category20)
            );

            customerRepository.saveAll(
                    List.of(customer1, customer2, customer3)
            );

            customerSiteRepository.saveAll(
                    List.of(site1, site2, site3, site4)
            );

            invoiceRepository.saveAll(
                    List.of(invoice1, invoice2)
            );

            invoiceIssuerRepository.saveAll(
                    List.of(invoiceIssuer1, invoiceIssuer2)
            );

            invoiceItemRepository.saveAll(
                    List.of(invoiceItem1, invoiceItem2, invoiceItem3, invoiceItem4, invoiceItem5)
            );

            orderRepository.saveAll(
                    List.of(order1, order2, order3, order4)
            );

            orderItemRepository.saveAll(
                    List.of(orderItem1, orderItem2, orderItem3, orderItem4, orderItem5, orderItem6, orderItem7,
                            orderItem8, orderItem9, orderItem10, orderItem11, orderItem12, orderItem13)
            );

            paymentMethodRepository.saveAll(
                    List.of(paymentMethod1, paymentMethod2, paymentMethod3,
                            paymentMethod4, paymentMethod5, paymentMethod6)
            );

            productRepository.saveAll(
                    List.of(product1, product2, product3, product4, product5,
                            product6, product7, product8, product9, product10)
            );
            statusRepository.saveAll(
                    List.of(status1, status2, status3, status4, status5)
            );
            vatRepository.saveAll(
                    List.of(vat1, vat2, vat3)
            );
        };
    }


}
