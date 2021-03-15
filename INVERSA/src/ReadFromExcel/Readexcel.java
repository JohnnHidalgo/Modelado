package ReadFromExcel;

import jxl.Cell;
import jxl.CellType;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

import java.io.File;
import java.io.IOException;

public class Readexcel {

    private String inputFile;

    public Readexcel(String inputFile) {
        this.inputFile = inputFile;
    }

    public void read() throws IOException{
        File inputWorkbook=new File(inputFile);
        Workbook w;
        try {
            w=Workbook.getWorkbook(inputWorkbook);

            Sheet sheet=w.getSheet(0);
            for (int j=0;j<sheet.getColumns();j++){

                for (int i=0;i<sheet.getRows();i++){
                    Cell cell=sheet.getCell(j,i);
                    CellType type=cell.getType();
                    if(type==CellType.LABEL){
                        System.out.println("Consegui la label :"+cell.getContents());

                    }
                    if(type==CellType.NUMBER){
                        System.out.println("Consegui un numero");
                    }
                }
            }

        }
        catch (BiffException e){
            e.printStackTrace();
        }
    }
    public static void main(String []args) throws IOException{
        Readexcel test=new Readexcel("C://Users/ASUS/Desktop/prueba.xls");
        test.read();

    }
}

