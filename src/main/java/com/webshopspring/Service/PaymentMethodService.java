package com.webshop.Service;

import com.webshop.Model.PaymentMethod;
import com.webshop.Repository.PaymentMethodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PaymentMethodService {
    private final PaymentMethodRepository paymentMethodRepository;

    @Autowired
    public PaymentMethodService(PaymentMethodRepository paymentMethodRepository) {
        this.paymentMethodRepository = paymentMethodRepository;
    }

    public List<PaymentMethod> getPaymentMethods(){
        return paymentMethodRepository.findAll();
    }

    public PaymentMethod getPaymentMethod(Long paymentMethodId) {
        Optional<PaymentMethod> paymentMethodOptional = paymentMethodRepository.findById(paymentMethodId);
        if (!paymentMethodOptional.isPresent()){
            return null;
        }
        return paymentMethodOptional.get();
    }

    public void addNewPaymentMethod(PaymentMethod paymentMethod) {
        Optional<PaymentMethod> paymentMethodOptional = paymentMethodRepository.
                findPaymentMethodByName(paymentMethod.getMethod());
        if (paymentMethodOptional.isPresent()){
            throw new IllegalStateException("it's already exist");
        }
        paymentMethodRepository.save(paymentMethod);
    }

    public PaymentMethod deletePaymentMethod(Long id) {
        PaymentMethod paymentMethod = this.getPaymentMethod(id);
        if (paymentMethod != null){
            paymentMethodRepository.deleteById(id);
            return paymentMethod;
        }
        else {
            return null;
        }
    }

    public PaymentMethod updatePaymentMethod(Long paymentMethodId, PaymentMethod paymentMethod) {
        PaymentMethod paymentMethodFind = getPaymentMethod(paymentMethodId);
        if(paymentMethodFind != null){
            paymentMethodFind.setMethod(paymentMethod.getMethod());
            paymentMethodFind.setDeadline(paymentMethod.getDeadline());

            paymentMethodRepository.save(paymentMethodFind);
            return paymentMethod;
        }
        return null;
    }
}
