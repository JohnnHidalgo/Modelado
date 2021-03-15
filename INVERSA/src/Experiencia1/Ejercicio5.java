package Experiencia1;

import Graficas.Graficator;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Ejercicio5 {
    public static void main(String[] args){
        Random random=new Random();
        List<Double> listX=new ArrayList();
        List<Double> listY=new ArrayList();
        List<Double> listX1=new ArrayList();
        List<Double> listY1=new ArrayList();
        List<Double> listX2=new ArrayList();
        List<Double> listY2=new ArrayList();
        for (int i=0;i<200;i++){
            double numAleatorio1=random.nextDouble();
            double numAleatorio2=random.nextDouble();
            double rcuadrado=-Math.log10(numAleatorio1);
            double circule=2*Math.PI*numAleatorio2;
            double x=Math.pow(-2*Math.log10(numAleatorio1),0.5)*Math.cos(2*Math.PI*numAleatorio2);
            double y=Math.pow(-2*Math.log10(numAleatorio1),0.5)*Math.sin(2*Math.PI*numAleatorio2);
            listX.add(x);
            listY.add(y);
            listX1.add(numAleatorio1);
            listY1.add(rcuadrado);
            listX2.add(numAleatorio2);
            listY2.add(circule);
        }

        JFrame ventana = new JFrame("Grafica 1");
        ventana.setSize(800, 600);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        ventana.add(Graficator.graficar(vecgenerados));
        ventana.add(Graficator.graficar2(listY,listX));
        ventana.setVisible(true);

        JFrame ventana1 = new JFrame("Grafica 2");
        ventana1.setSize(800, 600);
        ventana1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        ventana.add(Graficator.graficar(vecgenerados));
        ventana1.add(Graficator.graficar2(listY1,listX1));
        ventana1.setVisible(true);

        JFrame ventana2 = new JFrame("Grafica 3");
        ventana2.setSize(800, 600);
        ventana2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        ventana.add(Graficator.graficar(vecgenerados));
        ventana2.add(Graficator.graficar2(listY2,listX2));
        ventana2.setVisible(true);
        System.out.println(showVectors(listY,listX));

    }

    public static double getHalf(List<Double> list){
        double sum=0.0;
        for (int i=0;i<list.size();i++){
            sum+=list.get(i);
        }
        return sum/list.size();

    }
    public static double factorial(double n){

        if(n<=1.0) return 1;

        else     return (n*factorial(n - 1));

    }

//Calculo de C=   n!/r!(n-r)!

    public static double combinatoria(double n, double r){

        return (factorial(n) / (factorial(r)*factorial(n-r)));

    }

    public static void showMatrix(double m[][]){

        for (int i=0;i<m.length;i++){
            for (int j=0;j<m[0].length;j++){
                System.out.print(m[i][j]+"\t");
            }
            System.out.println();
        }
    }
    public static String showVectors(List<Double> listX,List<Double> listY){
        String cad="";
        for(int i=0;i<listX.size();i++){
            cad+="x: "+listX.get(i)+" y: "+listY.get(i)+" \n";
        }
        return cad;
    }

}
