package br.com.itau.turing.hrpayroll.feignClients;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name="hr-worker", url = "localhost:8001", path = "/workers" )
public interface WorkerFeignClient {

}
