package com.QM.utils;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileInputStream;
import java.io.IOException;

public class ExcelUtil {
    private Workbook wb;
    private Sheet sh;

    public ExcelUtil(String filePath, String sheetName) throws IOException {
        FileInputStream fis = new FileInputStream(filePath);
        wb = new XSSFWorkbook(fis);
        sh = wb.getSheet(sheetName);
    }

    public String getCellData(int rowNum, int colNum) {
        Row row = sh.getRow(rowNum);
        Cell cell = row.getCell(colNum);

        switch (cell.getCellType()) {
            case CellType.STRING:
                return cell.getStringCellValue();
            case CellType.NUMERIC:
                if (DateUtil.isCellDateFormatted(cell)) {
                    return cell.getDateCellValue().toString();
                } else {
                    return String.valueOf(cell.getNumericCellValue());
                }
            case CellType.BOOLEAN:
                return String.valueOf(cell.getBooleanCellValue());
            case CellType.FORMULA:
                return cell.getCellFormula();
            default:
                return "";
        }
    }

    public int getRowCount() {
        return sh.getLastRowNum() + 1;
    }

    public int getColumnCount() {
        return sh.getRow(0).getLastCellNum();
    }


}
