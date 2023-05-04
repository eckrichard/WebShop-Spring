package com.webshop.Repository;

import com.webshop.Model.CustomerSite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerSiteRepository extends JpaRepository<CustomerSite, Long> {
    @Query("SELECT c FROM CustomerSite c where  c.zipcode = ?1 and c.city = ?2 and c.street = ?3")
    Optional<CustomerSite> findCustomerSite(String zipCode, String city, String street);
}
