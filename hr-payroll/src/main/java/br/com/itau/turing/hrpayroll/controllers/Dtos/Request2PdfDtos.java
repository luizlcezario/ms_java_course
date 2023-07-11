package br.com.itau.turing.hrpayroll.controllers.Dtos;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Request2PdfDtos {
    private String name;
    private String value;
    private String description;
}
