package de.lucas;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

import java.io.IOException;

public class Rechnungsgenerator {

    public void erstellePDF(Kunde kunde, String dateiname)throws IOException {

        PDDocument document = new PDDocument();

        PDPage page = new PDPage();
        document.addPage(page);

        PDPageContentStream contentStream = new PDPageContentStream(document, page);

        double mwst = Math.round(kunde.getBetrag() * 0.19*100.0)/100.0;
        double brutto = Math.round((kunde.getBetrag() + mwst)*100.0)/100.0;


        contentStream.beginText();
        contentStream.setFont(PDType1Font.HELVETICA, 12);
        contentStream.newLineAtOffset(50, 760);
        contentStream.showText("DeinUnternehmen123GmbH");
        contentStream.endText();

        contentStream.beginText();
        contentStream.newLineAtOffset(50, 740);
        contentStream.showText("Musterstraße 12, 12345 Musterstadt");
        contentStream.endText();

        contentStream.beginText();
        contentStream.newLineAtOffset(50, 680);
        contentStream.showText(kunde.getName());
        contentStream.endText();

        contentStream.beginText();
        contentStream.newLineAtOffset(50, 660);
        contentStream.showText(kunde.getLeistung());
        contentStream.endText();

        contentStream.beginText();
        contentStream.newLineAtOffset(50, 640);
        contentStream.showText("Nettobetrag: "+ String.valueOf(kunde.getBetrag()));
        contentStream.endText();

        contentStream.beginText();
        contentStream.newLineAtOffset(50, 620);
        contentStream.showText("MwSt(19%): "+ mwst);
        contentStream.endText();

        contentStream.beginText();
        contentStream.newLineAtOffset(50, 600);
        contentStream.showText("Gesamtbetrag: " + brutto);
        contentStream.endText();

        contentStream.beginText();
        contentStream.newLineAtOffset(50, 580);
        contentStream.showText(kunde.getDatum());
        contentStream.endText();

        contentStream.beginText();
        contentStream.newLineAtOffset(50, 560);
        contentStream.showText("Rechungsnummer:" +String.valueOf(kunde.getRechnungsnummer()));
        contentStream.endText();

        contentStream.close();
        document.save(dateiname);
        document.close();
    }
}
