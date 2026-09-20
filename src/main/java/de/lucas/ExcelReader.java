package de.lucas;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ExcelReader {

    public List<Kunde> lesenAus(String dateipfad)throws IOException {

        List<Kunde> kunden = new ArrayList<>();

        FileInputStream file = new FileInputStream("src/main/resources/kunden.xlsx");
        Workbook workbook = new XSSFWorkbook(file);

        Sheet sheet = workbook.getSheetAt(0);

        int nummer = 1380991;

        for (Row row : sheet) {

            if (row.getRowNum() == 0) {
                continue;
            }
            Cell nameCell = row.getCell(0);
            String name = nameCell.getStringCellValue();

            Cell leistungCell = row.getCell(1);
            String leistung = leistungCell.getStringCellValue();

            Cell betragCell = row.getCell(2);
            double betrag;
            if(betragCell.getCellType()== CellType.NUMERIC){
                betrag=betragCell.getNumericCellValue();
            } else{
                betrag = Double.parseDouble(betragCell.getStringCellValue());
            }


            Cell datumCell = row.getCell(3);
            String datum;
            if (datumCell.getCellType() == CellType.NUMERIC) {
                datum = datumCell.getLocalDateTimeCellValue().toLocalDate().toString();
            } else {
                datum = datumCell.getStringCellValue();
            }


            Kunde k = new Kunde(name,leistung,betrag,datum,nummer);
            kunden.add(k);
            nummer++;
        }

        return kunden;
    }
}
