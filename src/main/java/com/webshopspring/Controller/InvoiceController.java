package com.webshop.Controller;

import com.webshop.Model.Invoice;
import com.webshop.Service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/invoice")
public class InvoiceController {
    private final InvoiceService invoiceService;

    @Autowired
    public InvoiceController(InvoiceService invoiceService) {
        this.invoiceService = invoiceService;
    }

    @GetMapping
    public List<Invoice> getInvoices() {
        return invoiceService.getInvoices();
    }

    @GetMapping(path = "{invoiceId}")
    public ResponseEntity<Invoice> getInvoice(@PathVariable("invoiceId") Long invoiceId) {
        Invoice invoice = invoiceService.getInvoice(invoiceId);
        return invoice != null ? ResponseEntity.ok(invoice) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Invoice> addNewInvoice(@RequestBody Invoice invoice) {
        invoiceService.addNewInvoice(invoice);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping(path = "{invoiceId}")
    public ResponseEntity<Invoice> deleteInvoice(@PathVariable("invoiceId") Long invoiceId) {
        Invoice invoice = invoiceService.deleteInvoice(invoiceId);
        return invoice != null ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }

    @PutMapping(path = "{categoryId}")
    public ResponseEntity<Invoice> updateInvoice(
            @PathVariable("categoryId") Long invoiceId,
            @RequestBody Invoice invoice)
    {
        Invoice invoiceFind = invoiceService.updateInvoice(invoiceId, invoice);
        return invoiceFind != null ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }
}
