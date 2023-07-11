package br.com.itau.turing.hrpayroll.controllers.Dtos;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ResponsePdfDtos {
    private String pdfName;
    private String pdfUrl;
}
