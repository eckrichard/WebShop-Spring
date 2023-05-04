package com.webshop.Repository;

import com.webshop.Model.Category;
import com.webshop.Model.PaymentMethod;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PaymentMethodRepository extends JpaRepository<PaymentMethod, Long> {
    @Query("SELECT pM FROM PaymentMethod pM where  pM.method = ?1")
    Optional<PaymentMethod> findPaymentMethodByName(String method);
}
