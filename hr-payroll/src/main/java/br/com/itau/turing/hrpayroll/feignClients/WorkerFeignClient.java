package br.com.itau.turing.hrpayroll.feignClients;


import br.com.itau.turing.hrpayroll.models.Worker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.UUID;

@Component
@FeignClient(name = "hr-worker", path = "/workers")
public interface WorkerFeignClient {
	@GetMapping( value = "/{id}")
	ResponseEntity<Worker> findById(@PathVariable UUID id);
}
