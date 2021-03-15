package PruebaChiCuadrado;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.util.Iterator;

public class readxlss {
    public static double[][] leerExcel(String archivo) {
        double[][] aux;
        try {
            FileInputStream fil = new FileInputStream(new File(archivo));
            XSSFWorkbook workboo = new XSSFWorkbook(fil);
            XSSFSheet shee = workboo.getSheetAt(0);
            Iterator<Row> rows = shee.iterator();
            int i = 0, j = 0;
            while (rows.hasNext()) {
                Row row = rows.next();
                Iterator<Cell> cellIterator = row.cellIterator();
                while (cellIterator.hasNext()) {

                    Cell cell = cellIterator.next();
                    switch (cell.getCellType()) {
                        case Cell.CELL_TYPE_NUMERIC:
                            // System.out.print(cell.getNumericCellValue() + "\t");
                            break;
                        case Cell.CELL_TYPE_STRING:
                            // System.out.print(cell.getStringCellValue() + "\t");
                            break;
                    }
                    j++;
                }
                i++;
            }
            fil.close();
            aux = new double[i][j / i];
            // aux = null;
            // System.out.println("i: "+ i + " j: "+ j/i);
            FileInputStream file = new FileInputStream(new File(archivo));
            XSSFWorkbook workbook = new XSSFWorkbook(file);
            XSSFSheet sheet = workbook.getSheetAt(0);
            Iterator<Row> rowIterator = sheet.iterator();
            i = 0;
            j = 0;
            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();
                Iterator<Cell> cellIterator = row.cellIterator();
                j = 0;
                while (cellIterator.hasNext()) {
                    Cell cell = cellIterator.next();
                    switch (cell.getCellType()) {
                        case Cell.CELL_TYPE_NUMERIC:
                            aux[i][j] = cell.getNumericCellValue();
                            // System.out.print(cell.getNumericCellValue() + "\t");
                            break;
                        case Cell.CELL_TYPE_STRING:
                            aux[i][j] = Double.parseDouble(cell.getStringCellValue());
                            // System.out.print(cell.getStringCellValue() + "\t");
                            break;
                    }

                    j++;
                }
                i++;
                // System.out.println("");
            }
            file.close();
        } catch (Exception e) {
            aux = null;
            e.printStackTrace();
        }
        return aux;
    }

    public static double[][] leerExcels(String archivo, String hoja) {
        double[][] aux;
        try {
            FileInputStream fil = new FileInputStream(new File(archivo));
            XSSFWorkbook workboo = new XSSFWorkbook(fil);
            XSSFSheet shee = workboo.getSheet(hoja);
            Iterator<Row> rows = shee.iterator();
            int i = 0, j = 0;
            while (rows.hasNext()) {
                Row row = rows.next();
                Iterator<Cell> cellIterator = row.cellIterator();
                while (cellIterator.hasNext()) {

                    Cell cell = cellIterator.next();
                    switch (cell.getCellType()) {
                        case Cell.CELL_TYPE_NUMERIC:
                            // System.out.print(cell.getNumericCellValue() + "\t");
                            break;
                        case Cell.CELL_TYPE_STRING:
                            // System.out.print(cell.getStringCellValue() + "\t");
                            break;
                    }
                    j++;
                }
                i++;
            }
            fil.close();
            aux = new double[i][j / i];
            // aux = null;
            // System.out.println("i: "+ i + " j: "+ j/i);
            FileInputStream file = new FileInputStream(new File(archivo));
            XSSFWorkbook workbook = new XSSFWorkbook(file);
            XSSFSheet sheet = workbook.getSheet(hoja);
            Iterator<Row> rowIterator = sheet.iterator();
            i = 0;
            j = 0;
            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();
                Iterator<Cell> cellIterator = row.cellIterator();
                j = 0;
                while (cellIterator.hasNext()) {
                    Cell cell = cellIterator.next();
                    switch (cell.getCellType()) {
                        case Cell.CELL_TYPE_NUMERIC:
                            aux[i][j] = cell.getNumericCellValue();
                            // System.out.print(cell.getNumericCellValue() + "\t");
                            break;
                        case Cell.CELL_TYPE_STRING:
                            aux[i][j] = Double.parseDouble(cell.getStringCellValue());
                            System.out.print(cell.getStringCellValue() + "\t");
                            break;
                    }

                    j++;
                }
                i++;
                // System.out.println("");
            }
            file.close();
        } catch (Exception e) {
            aux = null;
            e.printStackTrace();
        }
        return aux;
    }
}
