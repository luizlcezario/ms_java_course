package br.com.itau.turing.hrpayroll.controllers;

import br.com.itau.turing.hrpayroll.controllers.Dtos.Request2PdfDtos;
import br.com.itau.turing.hrpayroll.controllers.Dtos.ResponsePdfDtos;
import br.com.itau.turing.hrpayroll.models.Payment;
import br.com.itau.turing.hrpayroll.sevices.DocumentGenerationService;
import br.com.itau.turing.hrpayroll.sevices.PaymentService;
import com.itextpdf.html2pdf.ConverterProperties;
import com.itextpdf.html2pdf.HtmlConverter;
import com.itextpdf.html2pdf.resolver.font.DefaultFontProvider;
import com.itextpdf.kernel.pdf.PdfWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.HTML;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.util.UUID;

@RestController
@RequestMapping("/payments")
public class PaymentController {
    @Autowired
    private PaymentService paymentService;

    @Autowired
    private DocumentGenerationService documentGenerationService;

    @GetMapping("/{id}/days/{days}")
    public ResponseEntity<Payment> getPayment(@PathVariable UUID id, @PathVariable Integer days) {
        Payment payment = paymentService.getPayment(id, days);
        return ResponseEntity.ok(payment);
    }

    @PostMapping("/pdf")
    public  ResponseEntity<ResponsePdfDtos> createPdf(@RequestBody Request2PdfDtos test) {
        documentGenerationService.generatePdf(test);
    }
}
