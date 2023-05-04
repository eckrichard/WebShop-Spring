package com.webshop.Service;

import com.webshop.Model.InvoiceItem;
import com.webshop.Repository.InvoiceItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InvoiceItemService {
    private final InvoiceItemRepository invoiceItemRepository;

    @Autowired
    public InvoiceItemService(InvoiceItemRepository invoiceItemRepository) {
        this.invoiceItemRepository = invoiceItemRepository;
    }

    public List<InvoiceItem> getInvoiceItems(){
        return invoiceItemRepository.findAll();
    }

    public InvoiceItem getInvoiceItem(Long invoiceItemId) {
        Optional<InvoiceItem> invoiceItemOptional = invoiceItemRepository.findById(invoiceItemId);
        if (!invoiceItemOptional.isPresent()){
            return null;
        }
        return invoiceItemOptional.get();
    }

    public void addNewInvoiceItem(InvoiceItem invoiceItem) {
        invoiceItemRepository.save(invoiceItem);
    }

    public InvoiceItem deleteInvoiceItem(Long id) {
        InvoiceItem invoiceItem = this.getInvoiceItem(id);
        if (invoiceItem != null){
            invoiceItemRepository.deleteById(id);
            return invoiceItem;
        }
        else {
            return null;
        }
    }

    public InvoiceItem updateInvoiceItem(Long invoiceItemId, InvoiceItem invoiceItem) {
        InvoiceItem invoiceItemFind = getInvoiceItem(invoiceItemId);
        if(invoiceItemFind != null){
            invoiceItemFind.setName(invoiceItem.getName());
            invoiceItemFind.setAmount(invoiceItem.getAmount());
            invoiceItemFind.setPrice(invoiceItem.getPrice());
            invoiceItemFind.setVatPercentage(invoiceItem.getVatPercentage());
            invoiceItemFind.setInvoice(invoiceItem.getInvoice());
            invoiceItemFind.setOrderItem(invoiceItem.getOrderItem());

            invoiceItemRepository.save(invoiceItemFind);
            return invoiceItem;
        }
        return null;
    }
}
