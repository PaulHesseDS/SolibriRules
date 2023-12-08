package com.solibri.rule;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {

    public List<List<String>> readExcel(String filePath) {
        List<List<String>> columnData = new ArrayList<>();

        try (FileInputStream file = new FileInputStream(filePath)) {
            XSSFWorkbook workbook = new XSSFWorkbook(file);
            XSSFSheet sheet = workbook.getSheetAt(0);

            // Assuming that the first row contains column headers
            Row headerRow = sheet.getRow(0);
            int numColumns = headerRow.getLastCellNum();

            // Initialize lists for each column
            for (int i = 0; i < numColumns; i++) {
                columnData.add(new ArrayList<>());
            }

            // Iterate through rows starting from the second row (index 1)
            for (int rowIndex = 1; rowIndex <= sheet.getLastRowNum(); rowIndex++) {
                Row row = sheet.getRow(rowIndex);

                // Iterate through each cell in the row
                for (int columnIndex = 0; columnIndex < numColumns; columnIndex++) {
                    Cell cell = row.getCell(columnIndex);
                    String cellValue = (cell == null) ? "" : cell.toString();
                    columnData.get(columnIndex).add(cellValue);
                }
            }

            workbook.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return columnData;
    }
}