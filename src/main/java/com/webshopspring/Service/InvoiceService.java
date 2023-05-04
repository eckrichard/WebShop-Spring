package com.webshop.Service;

import com.webshop.Model.Category;
import com.webshop.Model.Invoice;
import com.webshop.Repository.InvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InvoiceService {
    private final InvoiceRepository invoiceRepository;

    @Autowired
    public InvoiceService(InvoiceRepository invoiceRepository) {
        this.invoiceRepository = invoiceRepository;
    }

    public List<Invoice> getInvoices(){
        return invoiceRepository.findAll();
    }

    public Invoice getInvoice(Long invoiceId) {
        Optional<Invoice> invoiceOptional = invoiceRepository.findById(invoiceId);
        if (!invoiceOptional.isPresent()){
            return null;
        }
        return invoiceOptional.get();
    }

    public void addNewInvoice(Invoice invoice) {
        invoiceRepository.save(invoice);
    }

    public Invoice deleteInvoice(Long id) {
        Invoice invoice = this.getInvoice(id);
        if (invoice != null){
            invoiceRepository.deleteById(id);
            return invoice;
        }
        else {
            return null;
        }
    }

    public Invoice updateInvoice(Long invoiceId, Invoice invoice) {
        Invoice invoiceFind = getInvoice(invoiceId);
        if(invoiceFind != null){
            invoiceFind.setCustomerName(invoice.getCustomerName());
            invoiceFind.setCustomerZipCode(invoice.getCustomerZipCode());
            invoiceFind.setCustomerCity(invoice.getCustomerCity());
            invoiceFind.setCustomerStreet(invoice.getCustomerStreet());
            invoiceFind.setPrintedCopies(invoice.getPrintedCopies());
            invoiceFind.setCancelled(invoice.isCancelled());
            invoiceFind.setPaymentMethod(invoice.getPaymentMethod());
            invoiceFind.setCreationDate(invoice.getCreationDate());
            invoiceFind.setDeliveryDate(invoice.getDeliveryDate());
            invoiceFind.setPaymentDeadline(invoice.getPaymentDeadline());
            invoiceFind.setInvoiceIssuer(invoice.getInvoiceIssuer());
            invoiceFind.setOrder(invoice.getOrder());

            invoiceRepository.save(invoiceFind);
            return invoice;
        }
        return null;
    }
}
