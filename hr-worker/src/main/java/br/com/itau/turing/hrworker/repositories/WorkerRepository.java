package br.com.itau.turing.hrworker.repositories;

import br.com.itau.turing.hrworker.models.Worker;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface WorkerRepository extends JpaRepository<Worker, UUID> {
}
