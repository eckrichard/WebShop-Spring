package com.webshop.Controller;

import com.webshop.Model.Category;
import com.webshop.Model.VAT;
import com.webshop.Service.VATService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/vat")
public class VATController {
    private final VATService vatService;

    @Autowired
    public VATController(VATService vatService) {
        this.vatService = vatService;
    }

    @GetMapping
    public List<VAT> getVATs() {
        return vatService.getVATs();
    }

    @GetMapping(path = "{vatId}")
    public ResponseEntity<VAT> getVAT(@PathVariable("vatId") Long vatId) {
        VAT vat = vatService.getVAT(vatId);
        return vat != null ? ResponseEntity.ok(vat) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<VAT> addNewVAT(@RequestBody VAT vat) {
        vatService.addNewVAT(vat);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping(path = "{vatId}")
    public ResponseEntity<VAT> deleteVAT(@PathVariable("vatId") Long vatId) {
        VAT vat = vatService.deleteVAT(vatId);
        return vat != null ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }

    @PutMapping(path = "{vatId}")
    public ResponseEntity<VAT> updateVAT(
            @PathVariable("vatId") Long vatId,
            @RequestBody VAT vat)
    {
        VAT vatFind = vatService.updateVAT(vatId, vat);
        return vatFind != null ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }
}
