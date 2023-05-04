package com.webshop.Controller;

import com.webshop.Model.Category;
import com.webshop.Model.InvoiceItem;
import com.webshop.Service.InvoiceItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/invoiceitem")
public class InvoiceItemController {
    private final InvoiceItemService invoiceItemService;

    @Autowired
    public InvoiceItemController(InvoiceItemService invoiceItemService) {
        this.invoiceItemService = invoiceItemService;
    }

    @GetMapping
    public List<InvoiceItem> getCategories() {
        return invoiceItemService.getInvoiceItems();
    }

    @GetMapping(path = "{invoiceItemId}")
    public ResponseEntity<InvoiceItem> getCategory(
            @PathVariable("invoiceItemId") Long invoiceItemId) {
        InvoiceItem invoiceItem = invoiceItemService.getInvoiceItem(invoiceItemId);
        return invoiceItem != null ? ResponseEntity.ok(invoiceItem) :
                ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<InvoiceItem> addNewCategory(@RequestBody InvoiceItem invoiceItem) {
        invoiceItemService.addNewInvoiceItem(invoiceItem);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping(path = "{invoiceItemId}")
    public ResponseEntity<InvoiceItem> deleteCategory(
            @PathVariable("invoiceItemId") Long invoiceItemId) {
        InvoiceItem invoiceItem = invoiceItemService.deleteInvoiceItem(invoiceItemId);
        return invoiceItem != null ? ResponseEntity.noContent().build() :
                ResponseEntity.notFound().build();
    }

    @PutMapping(path = "{invoiceItemId}")
    public ResponseEntity<InvoiceItem> updateCategory(
            @PathVariable("invoiceItemId") Long invoiceItemId,
            @RequestBody InvoiceItem invoiceItem)
    {
        InvoiceItem invoiceItemFind = invoiceItemService.updateInvoiceItem(invoiceItemId, invoiceItem);
        return invoiceItemFind != null ? ResponseEntity.ok().build() :
                ResponseEntity.notFound().build();
    }
}
