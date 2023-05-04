package com.webshop.Service;

import com.webshop.Model.Customer;
import com.webshop.Repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<Customer> getCustomers(){
        return customerRepository.findAll();
    }

    public Customer getCustomer(Long customerId) {
        Optional<Customer> customerOptional = customerRepository.findById(customerId);
        if (!customerOptional.isPresent()){
            return null;
        }
        return customerOptional.get();
    }

    public void addNewCustomer(Customer customer) {
        Optional<Customer> customerOptional = customerRepository.findCategoryByEmail(customer.getEmail());
        if (customerOptional.isPresent()){
            throw new IllegalStateException("Email already taken");
        }
        customerOptional = customerRepository.findCategoryByLogin(customer.getLogin());
        if (customerOptional.isPresent()){
            throw new IllegalStateException("Username already taken");
        }
        customerRepository.save(customer);
    }

    public Customer deleteCustomer(Long id) {
        Customer customer = this.getCustomer(id);
        if (customer != null){
            customerRepository.deleteById(id);
            return customer;
        }
        else {
            return null;
        }
    }

    public Customer updateCustomer(Long customerId, Customer customer) {
        Customer customerFind = getCustomer(customerId);
        if(customerFind != null){
            customerFind.setName(customer.getName());
            customerFind.setEmail(customer.getEmail());
            customerFind.setLogin(customer.getLogin());
            customerFind.setPassword(customer.getPassword());
            customerFind.setBankAccount(customer.getBankAccount());
            customerFind.setCustomerSites(customer.getCustomerSites());
            customerFind.setMainCustomerSite(customer.getMainCustomerSite());

            customerRepository.save(customerFind);
            return customer;
        }
        return null;
    }
}
