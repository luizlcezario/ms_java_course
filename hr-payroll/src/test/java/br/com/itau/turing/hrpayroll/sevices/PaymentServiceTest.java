package br.com.itau.turing.hrpayroll.sevices;


import br.com.itau.turing.hrpayroll.feignClients.WorkerFeignClient;
import br.com.itau.turing.hrpayroll.models.Payment;
import br.com.itau.turing.hrpayroll.models.Worker;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;
import java.util.UUID;

class PaymentServiceTest {

    @Mock
    private WorkerFeignClient workerFeignClient;

    private PaymentService paymentService;

    public PaymentServiceTest() {
        MockitoAnnotations.openMocks(this);
        paymentService = new PaymentService(workerFeignClient);
    }

    @Test
    void getPayment() {
        UUID workerId = UUID.randomUUID();
        Worker worker = new Worker(workerId, "luiz", 50.0);
        when(workerFeignClient.findById(workerId)).thenReturn(ResponseEntity.ok(worker));

        Payment payment = paymentService.getPayment(workerId, 10);

        assertEquals("luiz", payment.getName());
        assertEquals(50.0, payment.getDailyIncome());
        assertEquals(10, payment.getDays());
        assertEquals(500.0, payment.getTotal());
    }
}