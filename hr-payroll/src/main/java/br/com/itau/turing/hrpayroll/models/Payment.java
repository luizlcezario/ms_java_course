package br.com.itau.turing.hrpayroll.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Payment {
    private String name;
    private Double dailyIncome;
    private Integer days;
    private Double Total;

    public Double getTotal() {
        return days * dailyIncome;
    }

    public Payment(String name, Double dailyIncome, Integer days) {
        this.name = name;
        this.dailyIncome = dailyIncome;
        this.days = days;
        this.Total = days * dailyIncome;
    }
}
