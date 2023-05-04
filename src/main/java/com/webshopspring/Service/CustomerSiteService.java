package com.webshop.Service;

import com.webshop.Model.CustomerSite;
import com.webshop.Repository.CustomerSiteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerSiteService {
    private final CustomerSiteRepository customerSiteRepository;

    @Autowired
    public CustomerSiteService(CustomerSiteRepository customerSiteRepository) {
        this.customerSiteRepository = customerSiteRepository;
    }

    public List<CustomerSite> getCustomerSites(){
        return customerSiteRepository.findAll();
    }

    public CustomerSite getCustomerSite(Long customerSiteId) {
        Optional<CustomerSite> customerSiteOptional = customerSiteRepository.findById(customerSiteId);
        if (!customerSiteOptional.isPresent()){
            return null;
        }
        return customerSiteOptional.get();
    }

    public void addNewCustomerSite(CustomerSite customerSite) {
        Optional<CustomerSite> customerSiteOptional = customerSiteRepository.findCustomerSite(
                customerSite.getZipcode(), customerSite.getCity(), customerSite.getStreet());
        if (customerSiteOptional.isPresent()){
            throw new IllegalStateException("It's already exist");
        }
        customerSiteRepository.save(customerSite);
    }

    public CustomerSite deleteCustomerSite(Long id) {
        CustomerSite customerSite = this.getCustomerSite(id);
        if (customerSite != null){
            customerSiteRepository.deleteById(id);
            return customerSite;
        }
        else {
            return null;
        }
    }

    public CustomerSite updateCustomerSite(Long customerSiteId, CustomerSite customerSite) {
        CustomerSite customerSiteFind = getCustomerSite(customerSiteId);
        if(customerSiteFind != null){
            customerSiteFind.setZipcode(customerSite.getZipcode());
            customerSiteFind.setCity(customerSite.getCity());
            customerSiteFind.setStreet(customerSite.getStreet());
            customerSiteFind.setTel(customerSite.getTel());
            customerSiteFind.setFax(customerSite.getFax());
            customerSiteFind.setCustomer(customerSite.getCustomer());

            customerSiteRepository.save(customerSiteFind);
            return customerSite;
        }
        return null;
    }
}
