package br.com.itau.turing.hrpayroll.models;


import lombok.*;

import java.io.Serializable;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Setter
@Getter
public class Worker implements Serializable {
    private static final long serialVersionUID = 1L;
    private UUID id;

    private String name;

    private Double dailyIncome;
}
