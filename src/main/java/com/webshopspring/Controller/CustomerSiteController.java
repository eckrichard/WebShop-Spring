package com.webshop.Controller;

import com.webshop.Model.CustomerSite;
import com.webshop.Service.CustomerSiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/custumersite")
public class CustomerSiteController {
    private final CustomerSiteService customerSiteService;

    @Autowired
    public CustomerSiteController(CustomerSiteService customerSiteService) {
        this.customerSiteService = customerSiteService;
    }

    @GetMapping
    public List<CustomerSite> getCustomerSites() {
        return customerSiteService.getCustomerSites();
    }

    @GetMapping(path = "{customerSiteId}")
    public ResponseEntity<CustomerSite> getCustomerSite(@PathVariable("customerSiteId") Long customerSiteId) {
        CustomerSite customerSite = customerSiteService.getCustomerSite(customerSiteId);
        return customerSite != null ? ResponseEntity.ok(customerSite) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<CustomerSite> addNewCustomerSite(@RequestBody CustomerSite customerSite) {
        customerSiteService.addNewCustomerSite(customerSite);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping(path = "{customerSiteId}")
    public ResponseEntity<CustomerSite> deleteCustomerSite(@PathVariable("customerSiteId") Long customerSiteId) {
        CustomerSite customerSite = customerSiteService.deleteCustomerSite(customerSiteId);
        return customerSite != null ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }

    @PutMapping(path = "{customerSiteId}")
    public ResponseEntity<CustomerSite> updateCustomerSite(
            @PathVariable("customerSiteId") Long customerSiteId,
            @RequestBody CustomerSite customerSite)
    {
        CustomerSite customerSiteFind = customerSiteService.updateCustomerSite(customerSiteId, customerSite);
        return customerSiteFind != null ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }
}
