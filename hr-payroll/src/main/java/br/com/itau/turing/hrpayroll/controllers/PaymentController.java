package br.com.itau.turing.hrpayroll.controllers;

import br.com.itau.turing.hrpayroll.models.Payment;
import br.com.itau.turing.hrpayroll.sevices.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/payments")
public class PaymentController {
    @Autowired
    private PaymentService paymentService;

    @GetMapping("/{id}/days/{days}")
    public ResponseEntity<Payment> getPayment(@PathVariable UUID id, @PathVariable Integer days) {
        Payment payment = paymentService.getPayment(id, days);
        return ResponseEntity.ok(payment);
    }
}
