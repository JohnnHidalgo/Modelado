package DistribucionNormal;

import Graficas.Graficator;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import javax.swing.*;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;

public class DistribucionUniforme {

    public static void main(String[]args){
        Scanner scanner=new Scanner(System.in);
//        System.out.print("a: ");
//        int a=scanner.nextInt();
//        System.out.print("b: ");
//        int b=scanner.nextInt();
        double a=16;
        double b=48;
        double matrixExcel[][]=new double[150][1];
        Random random=new Random();
        List<Double> numAleatoriosX=new ArrayList<>();
        List<Double> numAleatoriosY=new ArrayList<>();
        for(int i=0;i<150;i++){
            double numaleatorii=(Math.random()*(b-a))+a;
            numAleatoriosX.add(numaleatorii);
            double fx=((numaleatorii-a)/(b-a));
 //           numAleatoriosY.add(fx);
            double y=1/(b-a);
            numAleatoriosY.add(y);
            matrixExcel[i][0]=numaleatorii;
//            System.out.println(fx);
            System.out.println(numaleatorii);
        }
        escribir(matrixExcel);

        double matrixGenerate[][]=generateMatrixByVectors(numAleatoriosX,numAleatoriosY);
        grafo("Grafica Uniforme: Verificación de documentos",matrixGenerate,"Grafica uniforme","X","Y","DistribucionUniformeGraphic.jpg");


        JFrame ventana = new JFrame("Grafica");
        ventana.setSize(800, 600);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        ventana.add(Graficator.graficar(vecgenerados));
        ventana.add(Graficator.graficar2(numAleatoriosY,numAleatoriosX));
        ventana.setVisible(true);



    }

    public static void escribir(double[][] aux) {
        //Blank workbook
        XSSFWorkbook workbook = new XSSFWorkbook();
        //Create a blank sheet
        XSSFSheet sheet = workbook.createSheet("YEstimados");
        //This data needs to be written (Object[])
        Map<String, Object[]> data = new TreeMap<String, Object[]>();
//        data.put("1", new Object[]{"",""});
//        data.put("2", new Object[] {1, "Amit", "Shukla"});
//        data.put("3", new Object[] {2, "Lokesh", "Gupta"});
//        data.put("4", new Object[] {3, "John", "Adwards"});
//        data.put("5", new Object[] {4, "Brian", "Schultz"});
        for (int i = 0; i < aux.length; i++) {
//            for (int j = 0; j < aux[0].length; j++) {
            int pos = i + 1;
            data.put(pos + "", new Object[]{aux[i][0] + ""});
//            }
        }
//        System.out.println(data.containsKey("120"));
        //Iterate over data and write to sheet
        Set<String> keyset = data.keySet();
        int rownum = 0;
        for (String key : keyset) {
            Row row = sheet.createRow(rownum++);
            Object[] objArr = data.get(key);
            int cellnum = 0;
            for (Object obj : objArr) {
                Cell cell = row.createCell(cellnum++);
                if (obj instanceof String)
                    cell.setCellValue((String) obj);
                else if (obj instanceof Integer)
                    cell.setCellValue((Integer) obj);
            }
        }
        try {
            //Write the workbook in file system
            FileOutputStream out = new FileOutputStream(new File("datas.xlsx"));
            workbook.write(out);
            out.close();

//            System.out.println("howtodoinjava_demo.xlsx written successfully on disk.");

        }catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static double[][] generateMatrixByVectors(List<Double> xgenerate,List<Double> yGenerate){
        double [][]matrixgenerate=new double[xgenerate.size()][2];
        for(int i=0;i<xgenerate.size();i++){
            matrixgenerate[i][0]=xgenerate.get(i);
            matrixgenerate[i][1]=yGenerate.get(i);
        }
        return matrixgenerate;
    }

    public static void grafo(String serieNom, double[][] data, String title, String titleX, String titleY, String nomArch) {
        XYSeries series = new XYSeries(serieNom);
//        series.add(1, 10);
//        series.add(2, 20);
//        series.add(3, 10);
        for (double[] datum : data) {
            series.add(datum[0], datum[1]);
        }
        XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(series);


        JFreeChart chart = ChartFactory.createXYAreaChart(title, titleX, titleY, dataset, PlotOrientation.VERTICAL,
                true, true, false);
        chart.getXYPlot().getRangeAxis().setRange(0.0,1.0);
        try {
            ChartUtilities.saveChartAsJPEG(new File(nomArch), chart, 600,400);
        } catch (IOException e) {
            System.err.println("Error creando grafico.");
        }
    }



}
