package Experiencia1;

import Graficas.Graficator;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Ejercicio11 {
    public static void main(String args[])
    {
        List<Double> xList=new ArrayList<>();
        List<Double> yList=new ArrayList<>();
        List<Integer> dataList=new ArrayList<>();
        double[][] matrix={
                {1,4,0.15},
                {2,3,0.45},
                {3,2,0.30},
                {4,1,0.10},
        };

        for(int j=0;j<1000;j++){
            int positionSeleccionable=1;
            double numRandom01=Math.random();
            double resultOfSeleccionable=Math.max(numRandom01,matrix[0][2])-Math.min(numRandom01,matrix[0][2]);
            for(int i=0;i<matrix.length;i++){
                if((Math.max(numRandom01,matrix[i][2])-Math.min(numRandom01,matrix[i][2]))<resultOfSeleccionable){
                    positionSeleccionable=(int)matrix[i][0];
                    resultOfSeleccionable=Math.max(numRandom01,matrix[i][2])-Math.min(numRandom01,matrix[i][2]);
                }
            }
            dataList.add(positionSeleccionable);
            xList.add((double)positionSeleccionable);
            yList.add(numRandom01);

        }
        System.out.println(mostrarvector(dataList));
        // Creamos la ventana
        JFrame ventana = new JFrame("Grafica");
        ventana.setSize(800, 600);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        ventana.add(Graficator.graficar(vecgenerados));
        ventana.add(Graficator.graficar2(xList,yList));
        ventana.setVisible(true);

    }


    public static String mostrarvector(List<Integer> lista){
        String cad="";
        for(int i=1;i<=lista.size();i++){
            if(i % 40==0){
                cad+=lista.get(i-1)+"\n";
            }
            else {
                cad+=lista.get(i-1)+"  ";
            }
        }
        return cad;
    }



}
