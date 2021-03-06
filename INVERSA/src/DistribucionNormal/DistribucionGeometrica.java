package DistribucionNormal;

import Graficas.Graficator;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DistribucionGeometrica {
    public static void main(String args[]) {
        double p = 0.9;
        double[][] matrix = new double[11][3];
        double fx = 0.0;
        List<Double> listY=new ArrayList<>();
        List<Double> listX=new ArrayList<>();
        double contadors=0.0;
        for (int i = 1; i < 11; i++) {
            double px = p * Math.pow(1 - p, i - 1);
            fx += px;
            listY.add(px);
            listX.add(contadors);
            matrix[i][0] = i;
            matrix[i][1] = px;
            matrix[i][2] = fx;
            contadors++;
        }
        System.out.println("La matriz es: ");
        showMatrix(matrix);

        Random random = new Random();
        List<Integer> lista = new ArrayList<>();
        for (int j = 0; j < 2500; j++) {
            int positionSeleccionable = 0;
            double numRandom01 = random.nextDouble();
            double resultOfSeleccionable = Math.max(numRandom01, matrix[0][1]) - Math.min(numRandom01, matrix[0][1]);
            for (int i = 0; i < matrix.length; i++) {
                if ((Math.max(numRandom01, matrix[i][1]) - Math.min(numRandom01, matrix[i][1])) < resultOfSeleccionable) {
                    positionSeleccionable = i;
                    resultOfSeleccionable = matrix[i][1];
                }
/*                 if(formato1.format(matrix[i][1]).equals(formato1.format(numRandom01))){
                    lista.add(i);
                }*/
            }
            lista.add(positionSeleccionable);
        }
        System.out.println(mostrarvector(lista));

        // Creamos la ventana
        JFrame ventana = new JFrame("Grafica");
        ventana.setSize(800, 600);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        ventana.add(Graficator.graficar(vecgenerados));
        ventana.add(Graficator.graficar2(listY,listX));
        ventana.setVisible(true);



    }

    public static String mostrarvector(List<Integer> lista) {
        String cad = "";
        for (int i = 0; i < lista.size(); i++) {
            if (i % 30 == 0) {
                cad += lista.get(i) + "\n";
            } else
                cad += lista.get(i) + "   ";
        }
        return cad;
    }

    public static double factorial(double n) {
        if (n <= 1.0) return 1;

        else return (n * factorial(n - 1));

    }

//Calculo de C=   n!/r!(n-r)!

    public static double combinatoria(double n, double r) {

        return (factorial(n) / (factorial(r) * factorial(n - r)));

    }

    public static void showMatrix(double m[][]) {

        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[0].length; j++) {
                System.out.print(m[i][j] + "\t");
            }
            System.out.println();
        }
    }


    public static double generateGeometricNumbers(){
        double p = 0.6;
        double[][] matrix = new double[101][3];
        double fx = 0.0;
        double contadors=0.0;
        for (int i = 1; i < 100; i++) {
            double px = p * Math.pow(1 - p, i - 1);
            fx += px;
            matrix[i][0] = i;
            matrix[i][1] = px;
            matrix[i][2] = fx;
            contadors++;
        }
        Random random = new Random();
        List<Integer> lista = new ArrayList<>();
            int positionSeleccionable = 0;
            double numRandom01 = random.nextDouble();
            double resultOfSeleccionable = Math.max(numRandom01, matrix[0][1]) - Math.min(numRandom01, matrix[0][1]);
            for (int i = 0; i < matrix.length; i++) {
                if ((Math.max(numRandom01, matrix[i][1]) - Math.min(numRandom01, matrix[i][1])) < resultOfSeleccionable) {
                    positionSeleccionable = i;
                    resultOfSeleccionable = matrix[i][1];
                }
            }
            return positionSeleccionable;

    }
}