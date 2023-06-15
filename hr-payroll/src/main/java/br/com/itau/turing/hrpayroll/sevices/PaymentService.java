package br.com.itau.turing.hrpayroll.sevices;

import br.com.itau.turing.hrpayroll.feignClients.WorkerFeignClient;
import br.com.itau.turing.hrpayroll.models.Payment;
import br.com.itau.turing.hrpayroll.models.Worker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class PaymentService {
    @Autowired
    private final WorkerFeignClient workerFeignClient;

    public PaymentService(WorkerFeignClient workerFeignClient) {
        this.workerFeignClient = workerFeignClient;
    }

    public Payment getPayment(UUID workerId, int days) {
        Worker worker = workerFeignClient.findById(workerId).getBody();
        Payment payment = new Payment(worker.getName(), worker.getDailyIncome(), days);
        return payment;
    }
}
