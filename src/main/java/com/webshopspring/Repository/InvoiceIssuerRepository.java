package com.webshop.Repository;

import com.webshop.Model.InvoiceIssuer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InvoiceIssuerRepository extends JpaRepository<InvoiceIssuer, Long> {
}
