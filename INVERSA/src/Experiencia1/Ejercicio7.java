package Experiencia1;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Ejercicio7 {

    public static void main(String[] args){
        List<Double> listY=new ArrayList<>();
        List<Double> listX=new ArrayList<>();

        double[][] matrix={
                {1.0,0.15,0.15},
                {2.0,0.15,0.30},
                {3.0,0.15,0.45},
                {4.0,0.25,0.70},
                {5.0,0.25,0.95},
                {6.0,0.05,1.00}};

        Random random=new Random();
        List<Integer> lista=new ArrayList<>();
        for (int j=0;j<120;j++){
            int positionSeleccionable=1;
            double numRandom01=random.nextDouble();
            double resultOfSeleccionable=Math.max(numRandom01,matrix[0][2])-Math.min(numRandom01,matrix[0][2]);
            for(int i=0;i<matrix.length;i++){
                if((Math.max(numRandom01,matrix[i][2])-Math.min(numRandom01,matrix[i][2]))<resultOfSeleccionable){
                    positionSeleccionable=(int)matrix[i][0];
                    resultOfSeleccionable=Math.max(numRandom01,matrix[i][2])-Math.min(numRandom01,matrix[i][2]);
                }
            }
//            listX.add(resultOfSeleccionable);
            listY.add(resultOfSeleccionable);
//            lista.add(positionSeleccionable);
            listX.add((double)positionSeleccionable);
            //            listY.add((double)positionSeleccionable);
        }

        System.out.println(mostrarvector(listX));
//        System.out.println(mostrarvector(listY));
/*        JFrame ventana = new JFrame("Grafica");
        ventana.setSize(800, 600);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//      ventana.add(Graficator.graficar(vecgenerados));
        ventana.add(Graficator.graficar2(listY,listX));
        ventana.setVisible(true);*/

    }

    public static String mostrarvector(List<Double> lista){
        String cad="";
        for(int i=1;i<=lista.size();i++){
            if(i % 30==0){
                cad+=lista.get(i-1)+"\n";
            }
            else {
                cad+=lista.get(i-1)+"  ";
            }
        }
        return cad;
    }



}
