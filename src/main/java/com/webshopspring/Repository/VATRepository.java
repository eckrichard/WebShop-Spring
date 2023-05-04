package com.webshop.Repository;

import com.webshop.Model.Category;
import com.webshop.Model.VAT;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VATRepository extends JpaRepository<VAT, Long> {
    @Query("SELECT vat FROM VAT vat where vat.percentage = ?1")
    Optional<VAT> findVATByName(int percentage);
}
