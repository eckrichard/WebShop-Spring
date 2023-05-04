package com.webshop.Service;

import com.webshop.Model.InvoiceIssuer;
import com.webshop.Repository.InvoiceIssuerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InvoiceIssuerService {
    private final InvoiceIssuerRepository invoiceIssuerRepository;

    @Autowired
    public InvoiceIssuerService(InvoiceIssuerRepository invoiceIssuerRepository) {
        this.invoiceIssuerRepository = invoiceIssuerRepository;
    }

    public List<InvoiceIssuer> getInvoiceIssuers(){
        return invoiceIssuerRepository.findAll();
    }

    public InvoiceIssuer getInvoiceIssuer(Long invoiceIssuerId) {
        Optional<InvoiceIssuer> invoiceIssuerOptional = invoiceIssuerRepository.findById(invoiceIssuerId);
        if (!invoiceIssuerOptional.isPresent()){
            return null;
        }
        return invoiceIssuerOptional.get();
    }

    public void addNewInvoiceIssuer(InvoiceIssuer invoiceIssuer) {
        invoiceIssuerRepository.save(invoiceIssuer);
    }

    public InvoiceIssuer deleteInvoiceIssuer(Long id) {
        InvoiceIssuer invoiceIssuer = this.getInvoiceIssuer(id);
        if (invoiceIssuer != null){
            invoiceIssuerRepository.deleteById(id);
            return invoiceIssuer;
        }
        else {
            return null;
        }
    }

    public InvoiceIssuer updateInvoiceIssuer(Long invoiceIssuerId, InvoiceIssuer invoiceIssuer) {
        InvoiceIssuer invoiceIssuerFind = getInvoiceIssuer(invoiceIssuerId);
        if(invoiceIssuerFind != null){
            invoiceIssuerFind.setName(invoiceIssuer.getName());
            invoiceIssuerFind.setZipCode(invoiceIssuer.getZipCode());
            invoiceIssuerFind.setCity(invoiceIssuer.getCity());
            invoiceIssuerFind.setStreet(invoiceIssuer.getStreet());
            invoiceIssuerFind.setTaxIdentifier(invoiceIssuer.getTaxIdentifier());
            invoiceIssuerFind.setBankAccount(invoiceIssuer.getBankAccount());

            invoiceIssuerRepository.save(invoiceIssuerFind);
            return invoiceIssuer;
        }
        return null;
    }
}
