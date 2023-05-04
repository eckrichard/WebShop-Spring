package com.webshop.Controller;

import com.webshop.Model.PaymentMethod;
import com.webshop.Service.PaymentMethodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/paymentmethod")
public class PaymentMethodController {
    private final PaymentMethodService paymentMethodService;

    @Autowired
    public PaymentMethodController(PaymentMethodService paymentMethodService) {
        this.paymentMethodService = paymentMethodService;
    }

    @GetMapping
    public List<PaymentMethod> getPaymentMethods() {
        return paymentMethodService.getPaymentMethods();
    }

    @GetMapping(path = "{paymentMethodId}")
    public ResponseEntity<PaymentMethod> getPaymentMethod(
            @PathVariable("paymentMethodId") Long paymentMethodId) {
        PaymentMethod category = paymentMethodService.getPaymentMethod(paymentMethodId);
        return category != null ? ResponseEntity.ok(category) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<PaymentMethod> addNewPaymentMethod(@RequestBody PaymentMethod paymentMethod) {
        paymentMethodService.addNewPaymentMethod(paymentMethod);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping(path = "{paymentMethodId}")
    public ResponseEntity<PaymentMethod> deletePaymentMethod(
            @PathVariable("paymentMethodId") Long paymentMethodId) {
        PaymentMethod category = paymentMethodService.deletePaymentMethod(paymentMethodId);
        return category != null ? ResponseEntity.noContent().build() :
                ResponseEntity.notFound().build();
    }

    @PutMapping(path = "{paymentMethodId}")
    public ResponseEntity<PaymentMethod> updatePaymentMethod(
            @PathVariable("paymentMethodId") Long paymentMethodId,
            @RequestBody PaymentMethod paymentMethod)
    {
        PaymentMethod paymentMethodFind = paymentMethodService.
                updatePaymentMethod(paymentMethodId, paymentMethod);
        return paymentMethodFind != null ? ResponseEntity.ok().build() :
                ResponseEntity.notFound().build();
    }
}
