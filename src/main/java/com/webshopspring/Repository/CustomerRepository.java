package com.webshop.Repository;

import com.webshop.Model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    @Query("SELECT c FROM Customer c where  c.email = ?1")
    Optional<Customer> findCategoryByEmail(String email);

    @Query("SELECT c FROM Customer c where  c.login = ?1")
    Optional<Customer> findCategoryByLogin(String login);
}
