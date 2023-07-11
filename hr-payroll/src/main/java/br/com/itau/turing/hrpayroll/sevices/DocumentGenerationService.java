package br.com.itau.turing.hrpayroll.sevices;

import br.com.itau.turing.hrpayroll.controllers.Dtos.Request2PdfDtos;
import br.com.itau.turing.hrpayroll.controllers.Dtos.ResponsePdfDtos;
import com.itextpdf.html2pdf.ConverterProperties;
import com.itextpdf.html2pdf.HtmlConverter;
import com.itextpdf.html2pdf.resolver.font.DefaultFontProvider;
import com.itextpdf.io.util.HashCode;
import com.itextpdf.kernel.pdf.PdfWriter;
import org.bouncycastle.crypto.generators.BCrypt;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.util.UUID;

@Service
public class DocumentGenerationService {

    @Value("${pdf.path}")
    private String pdfPath;

    @Value("${app.url}")
    private String appUrl;


    public String generatePdf(Request2PdfDtos test) {
        ByteArrayOutputStream pdf = new ByteArrayOutputStream();

        try {
            PdfWriter pdfWriter = new PdfWriter(pdf);
            DefaultFontProvider frontProvider = new DefaultFontProvider(
                    false, true,false
            );
            ConverterProperties converterProperties = new ConverterProperties();

            converterProperties.setFontProvider(frontProvider);

            HtmlConverter.convertToPdf(test.getName(), pdfWriter, converterProperties);
            String fileName = test.getName() + "_" + UUID.randomUUID() + ".pdf";
            FileOutputStream fout = new FileOutputStream(pdfPath + "/" + fileName);
            pdf.writeTo(fout);
            pdf.close();
            pdf.flush();
            fout.close();
            return appUrl + "/static/" + fileName;
        }catch (Exception e) {
           throw  new RuntimeException("Erro ao gerar o pdf");
        }
    }
}
