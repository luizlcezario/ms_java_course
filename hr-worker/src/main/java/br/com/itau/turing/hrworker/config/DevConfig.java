package br.com.itau.turing.hrworker.config;

import br.com.itau.turing.hrworker.models.Worker;
import br.com.itau.turing.hrworker.repositories.WorkerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

@Configuration
@Profile("default")
public class DevConfig implements CommandLineRunner {
    @Autowired
    private WorkerRepository workerRepository;


    @Override
    public void run(String... args) throws Exception {
        Worker w1 = new Worker(null,"luiz", 500.0);
        Worker w2 = new Worker(null,"Milena", 30.0);

        workerRepository.saveAll(Arrays.asList(w1,w2));
    }
}
