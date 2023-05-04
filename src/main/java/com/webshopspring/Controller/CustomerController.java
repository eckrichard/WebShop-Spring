package com.webshop.Controller;

import com.webshop.Model.Customer;
import com.webshop.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/custumer")
public class CustomerController {
    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    public List<Customer> getCategories() {
        return customerService.getCustomers();
    }

    @GetMapping(path = "{customerId}")
    public ResponseEntity<Customer> getStudents(@PathVariable("customerId") Long customerId) {
        Customer customer = customerService.getCustomer(customerId);
        return customer != null ? ResponseEntity.ok(customer) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Customer> addNewCategory(@RequestBody Customer customer) {
        customerService.addNewCustomer(customer);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping(path = "{customerId}")
    public ResponseEntity<Customer> deleteCategory(@PathVariable("customerId") Long customerId) {
        Customer customer = customerService.deleteCustomer(customerId);
        return customer != null ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }

    @PutMapping(path = "{customerId}")
    public ResponseEntity<Customer> updateStudent(
            @PathVariable("customerId") Long customerId,
            @RequestBody Customer customer)
    {
        Customer custumerFind = customerService.updateCustomer(customerId, customer);
        return custumerFind != null ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }
}
