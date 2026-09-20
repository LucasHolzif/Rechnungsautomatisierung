package de.lucas;

import java.io.IOException;
import java.io.PrintStream;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args)throws IOException {

        System.setOut(new PrintStream(System.out, true, "UTF-8"));


        ExcelReader reader = new ExcelReader();
        List<Kunde> kunden= reader.lesenAus("src/main/resources/kunden.xlsx");

        Rechnungsgenerator b = new Rechnungsgenerator();

        for (Kunde k:kunden){

            b.erstellePDF(k,"src/main/resources/rechnung_"+k.getName() + ".pdf");
        }


    }
}