package br.com.itau.turing.hrworker.models;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "tb_worker")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Worker implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "uuid")
    @Column(columnDefinition = "uuid")
    private UUID id;

    private String name;

    @Column(name = "daily_income")
    private Double dailyIncome;
}
