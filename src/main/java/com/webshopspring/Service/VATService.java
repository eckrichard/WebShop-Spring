package com.webshop.Service;

import com.webshop.Model.VAT;
import com.webshop.Repository.VATRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VATService {
    private final VATRepository vatRepository;

    @Autowired
    public VATService(VATRepository vatRepository) {
        this.vatRepository = vatRepository;
    }

    public List<VAT> getVATs(){
        return vatRepository.findAll();
    }

    public VAT getVAT(Long vatId) {
        Optional<VAT> vatOptional = vatRepository.findById(vatId);
        if (!vatOptional.isPresent()){
            return null;
        }
        return vatOptional.get();
    }

    public void addNewVAT(VAT vat) {
        Optional<VAT> vatOptional = vatRepository.findVATByName(vat.getPercentage());
        if (vatOptional.isPresent()){
            throw new IllegalStateException("it's already exist");
        }
        vatRepository.save(vat);
    }

    public VAT deleteVAT(Long id) {
        VAT vat = this.getVAT(id);
        if (vat != null){
            vatRepository.deleteById(id);
            return vat;
        }
        else {
            return null;
        }
    }

    public VAT updateVAT(Long vatId, VAT vat) {
        VAT vatFind = getVAT(vatId);
        if(vatFind != null){
            vatFind.setPercentage(vat.getPercentage());

            vatRepository.save(vatFind);
            return vat;
        }
        return null;
    }
}
