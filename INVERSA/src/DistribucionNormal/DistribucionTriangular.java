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
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.*;

public class DistribucionTriangular {
    public static void main(String args[]){
        Random random=new Random();
        List<Double> vecgenerados=new ArrayList<>();
        List<Double> xGenerados=new ArrayList<>();
        double a=8.0;
        double c=24.0;
        double b=40.0;

        double x=0;
        double x1=0;
        double[][] matrixForExcel=new double[265][2];
        for(int i=0;i<265;i++){
//            double numaleatorio=(Math.random()*(b-a))+a;
            double numaleatorio=(Math.random());
//            x=numaleatorio;
            x=Math.pow(numaleatorio*(b-a)*(c-a),0.5)+a;
//            x1=-Math.pow(numaleatorio*(b-a)*(c-a),0.5)+a;
//            if(x>c){
                x1=b-Math.pow((1-numaleatorio)*(b-a)*(b-c),0.5);
  //              x=Math.pow(numaleatorio*(b-a)*(c-a),0.5)+a;
//            }
//            if(x1>c){
  //              x1=b+Math.pow((1-numaleatorio)*(b-a)*(b-c),0.5);

//            }
  //          else {
    //        }
//            if(numaleatorio>=c && numaleatorio<=b){
//                x=b-Math.pow((1-numaleatorio)*(b-a)*(b-c),0.5);
//            }
//            vecgenerados.add(numaleatorio);
            vecgenerados.add(generateY(x,a,b,c));
            vecgenerados.add(generateY(x1,a,b,c));
            xGenerados.add(x);
            xGenerados.add(x1);
            matrixForExcel[i][0]=x;
//            matrixForExcel[i+1][0]=x1;
            matrixForExcel[i][1]=x1;
        }
        double[][] matrixGenerate=generateMatrixByVectors(xGenerados,vecgenerados);
        grafo("Grafica Solicitud de prestamo",matrixGenerate,"Grafica Triangular","X","Y","DistribucionTriangularGraphic.jpg");

//        escribirByVector(xGenerados);
//        escribir(matrixForExcel);
//       Double suma1=sumatotal(vecgenerados);
//        System.out.println("Suma total "+suma1);
//        System.out.println(mostrarVector(vecgenerados));
        System.out.println(mostrarVector(xGenerados));

        // Creamos la ventana
        JFrame ventana = new JFrame("Grafica");
        ventana.setSize(800, 600);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        ventana.add(Graficator.graficar(vecgenerados));
        ventana.add(Graficator.graficar2(vecgenerados,xGenerados));
        ventana.setVisible(true);


    }

    public static void escribirByVector(List<Double> vec){
        double matrix[][]=new double[530][1];
        for (int i=0;i<vec.size();i++){
            matrix[i][0]=vec.get(i);
        }
        escribir(matrix);
    }
    public static String mostrarVector(List<Double> vec){
        String cad="";
        for (int i=0;i<vec.size();i++){
            cad+=vec.get(i)+"\n";
        }
        return cad;
    }

    /*    public static void mostrarVector(double[] vec){
            String cad="";
            for(int i=0;i<vec.length;i++){
                if(i%10==0){
                    cad+="\n";
                }
                else {
                    cad+="\t"+vec[i];
                }
            }
            System.out.println(cad);
        }*/
    public static Double sumatotal(List<Double> sumaTotal){
        Double sum=0.0;
        for (int i=0;i<sumaTotal.size();i++){
            sum+=sumaTotal.get(i);
        }
        return sum;

    }

    public static double generateNumber(){
        double media=33;
        double sigma=5.0;
        double n=1000;
        double euler=2.7183;
        double pi=3.1416;
        double numaleatorio=Math.random()*(1.0-0.0);
        double c=1.0;
        double acumulado=0.00000;
        double deltaX=(6*sigma)/n;
        double valorvar=0.0;
        while (acumulado<numaleatorio)
        {
            valorvar=(Math.pow(euler,-((Math.pow(((c*deltaX)-media),2))/(2*sigma*sigma)))*deltaX)*(1/Math.pow(2*pi*Math.pow(sigma,2),0.5));
            acumulado+=valorvar;
            c++;
        }
        DecimalFormatSymbols separadoresPersonalizados = new DecimalFormatSymbols();
        separadoresPersonalizados.setDecimalSeparator('.');
        DecimalFormat df=new DecimalFormat("#.00",separadoresPersonalizados);


        return Double.parseDouble(df.format(c*deltaX));
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
            data.put(pos + "", new Object[]{aux[i][0] + "",aux[i][1]+""});
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


    public static double generateY(double x,double a,double b, double c){
        double y=0;
        if(a<=x && x<c){
            y=(2*(x-a)/((b-a)*(c-a)));
        }
        if(x>=c && x<=b){
            y=(2*(b-x))/((b-a)*(b-c));
        }
        return y;
    }
////////////////////////////////////////////////////////////////////////////////////////////////////



    public static double getProbabilityOfInterval(double li,double ls,int c){
        int limSup=(int)ls;
        double Fx=0.0;
        for(int i=0;i<limSup;i++){
            Fx=((2.0*Math.pow(ls,2.0))/1032.0)-((16*ls)/516.0)-((2.0*Math.pow(li,2.0))/1032.0)+((16*li)/516);
            if(i>=c){
                Fx=((2.0*Math.pow(ls,2.0))/512.0)-((48*ls)/256.0)-((2.0*Math.pow(li,2.0))/512.0)+((48*li)/256);
            }
        }
        return Fx;
    }

    public static double getCInBaseOfFEandFO(double[][] matrixFEandFO,int m){
        double c=0.0;
        for(int i=0;i<m;i++){
            c+=(Math.pow((matrixFEandFO[i][3]-matrixFEandFO[i][1]),2.0)/matrixFEandFO[i][3]);
        }
        return c;
    }

    public static double getFE(double[][] matrixFEandFO,double n){
        double fe=0.0;
        for (int i=0;i<matrixFEandFO.length;i++){
            double fx=matrixFEandFO[i][2];
            fe=fx*n;
        }
        return fe;

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
        series.add(8,0);
        series.add(40,0);
        XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(series);
        JFreeChart chart = ChartFactory.createXYAreaChart(title, titleX, titleY, dataset, PlotOrientation.VERTICAL,
                true, true, false);
        chart.getXYPlot().getRangeAxis().setRange(0.0,0.8);
        try {
            ChartUtilities.saveChartAsJPEG(new File(nomArch), chart, 600,400);
        } catch (IOException e) {
            System.err.println("Error creando grafico.");
        }
    }

}