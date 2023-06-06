package br.com.itau.turing.hrworker.controllers;

import br.com.itau.turing.hrworker.models.Worker;
import br.com.itau.turing.hrworker.repositories.WorkerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "/workers")
public class HrWorkerController {
    @Autowired
    private WorkerRepository workerRepository;

    @GetMapping
    public ResponseEntity<List<Worker>> findAll() {
        List<Worker> workers =  workerRepository.findAll();
        return ResponseEntity.ok().body(workers);
    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<Worker> findById(@PathVariable UUID id) {
        Worker worker =  workerRepository.findById(id).orElseThrow();
        return ResponseEntity.ok().body(worker);
    }
}
