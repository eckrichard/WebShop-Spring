package com.webshop.Controller;

import com.webshop.Model.InvoiceIssuer;
import com.webshop.Service.InvoiceIssuerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/invoiceissuer")
public class InvoiceIssuerController {
    private final InvoiceIssuerService invoiceIssuerService;

    @Autowired
    public InvoiceIssuerController(InvoiceIssuerService invoiceIssuerService) {
        this.invoiceIssuerService = invoiceIssuerService;
    }

    @GetMapping
    public List<InvoiceIssuer> getInvoiceIssuers() {
        return invoiceIssuerService.getInvoiceIssuers();
    }

    @GetMapping(path = "{invoiceIssuerId}")
    public ResponseEntity<InvoiceIssuer> getInvoiceIssuer(
            @PathVariable("invoiceIssuerId") Long invoiceIssuerId) {
        InvoiceIssuer invoiceIssuer = invoiceIssuerService.getInvoiceIssuer(invoiceIssuerId);
        return invoiceIssuer != null ? ResponseEntity.ok(invoiceIssuer) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<InvoiceIssuer> addNewCategory(@RequestBody InvoiceIssuer invoiceIssuer) {
        invoiceIssuerService.addNewInvoiceIssuer(invoiceIssuer);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping(path = "{invoiceIssuerId}")
    public ResponseEntity<InvoiceIssuer> deleteInvoiceIssuer(
            @PathVariable("invoiceIssuerId") Long invoiceIssuerId) {
        InvoiceIssuer invoiceIssuer = invoiceIssuerService.deleteInvoiceIssuer(invoiceIssuerId);
        return invoiceIssuer != null ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }

    @PutMapping(path = "{invoiceIssuerId}")
    public ResponseEntity<InvoiceIssuer> updateInvoiceIssuer(
            @PathVariable("invoiceIssuerId") Long invoiceIssuerId,
            @RequestBody InvoiceIssuer invoiceIssuer)
    {
        InvoiceIssuer invoiceIssuerFind = invoiceIssuerService.updateInvoiceIssuer(invoiceIssuerId, invoiceIssuer);
        return invoiceIssuerFind != null ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }
}
