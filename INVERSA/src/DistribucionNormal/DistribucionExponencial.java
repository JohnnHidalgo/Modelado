package DistribucionNormal;

import Graficas.Graficator;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class DistribucionExponencial {

    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
//        System.out.print("Lambda: ");
//        double lambda=scanner.nextInt();
        Random random=new Random();
        List<Double> listY=new ArrayList<>();
        List< Double> listX=new ArrayList<>();
//        double unosobrelamba=1/81.89;
        double unosobrelamba=12.0;
        System.out.println("Uno sobre lambda "+unosobrelamba);
        for (int i=0;i<1000;i++){
            double aleatorio=random.nextDouble()*unosobrelamba;
            System.out.println("Numero aleatorio: "+aleatorio);
            double x=(-(12)*Math.log(aleatorio/12));
//            double x=(-12.0*Math.log(aleatorio));
            listX.add(x);
            listY.add(aleatorio);
        }

        System.out.println(mostrarvector(listX));

        JFrame ventana = new JFrame("Grafica");
        ventana.setSize(800, 600);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        ventana.add(Graficator.graficar(vecgenerados));
        ventana.add(Graficator.graficar2(listY,listX));
        ventana.setVisible(true);


    }
    public static String mostrarvector(List<Double> lista){
        String cad="";
        for(int i=0;i<lista.size();i++){
                cad+=lista.get(i)+"\n";
        }
        return cad;
    }

    public static double generateExponentialNumber(double lambda){
        double unosobrelamba=lambda;
        double aleatorio=(Math.random()*unosobrelamba);
        double x=(-(12)*Math.log(aleatorio/12))+1;
//            double x=(-12.0*Math.log(aleatorio));
        return x;
    }

}
