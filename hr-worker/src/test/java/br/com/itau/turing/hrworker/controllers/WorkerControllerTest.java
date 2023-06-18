package br.com.itau.turing.hrworker.controllers;


import br.com.itau.turing.hrworker.models.Worker;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


@ActiveProfiles("test")
@SpringBootTest
class WorkerControllerTest {

    @Autowired
    private WorkerController workerController;

    @Test
    void testFindAll() {
        ResponseEntity<List<Worker>> workers = workerController.findAll();
        assertEquals(200 , workers.getStatusCodeValue());
        assertEquals(2, workers.getBody().size());
    }
}