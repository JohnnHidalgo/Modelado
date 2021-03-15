package DistribucionNormal;

import Graficas.Graficator;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class DistribucionWeibull {

    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        System.out.print("Alpha: ");
        double alpha=scanner.nextInt();
        System.out.print("Beta: ");
        double beta=scanner.nextInt();
        Random random=new Random();
        List<Double> listY=new ArrayList<>();
        List<Double> listX=new ArrayList<>();
        for (int i=0;i<1000;i++){
            double aleatorio=random.nextDouble()*1.0;
            double x=0.0;
            if(Math.log(aleatorio)<0){
                x=(beta*Math.pow(-Math.log(aleatorio),1/alpha));

            }
            else {
                x=(beta*Math.pow(Math.log(aleatorio),1/alpha));
            }
            System.out.println("X: "+x);
            if(x<=0){
                listY.add(0.0);
            }else {
                listY.add(aleatorio);
            }
            listX.add(x);
        }
        JFrame ventana = new JFrame("Grafica");
        ventana.setSize(800, 600);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        ventana.add(Graficator.graficar(listY));
        ventana.add(Graficator.graficar2(listY,listX));
        ventana.setVisible(true);

        JFrame ventana2 = new JFrame("Grafica");
        ventana2.setSize(800, 600);
        ventana2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana2.add(Graficator.graficar(listY));
//        ventana.add(Graficator.graficar2(listY,listX));
        ventana2.setVisible(true);
    }
}
