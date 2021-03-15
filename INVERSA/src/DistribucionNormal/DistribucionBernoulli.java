package DistribucionNormal;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DistribucionBernoulli {

    public static void main(String[] args){
        double p=0.4;
        double[][] matrix=new double[2][3];
        double fx=0.0;
        for(int i=0;i<2;i++){
            double px=(Math.pow(p,i)*Math.pow(1-p,1-i));
            fx+=px;
            matrix[i][0]=i;
            matrix[i][1]=px;
            matrix[i][2]=fx;
        }
        System.out.println("La matriz es: ");
        showMatrix(matrix);

        Random random=new Random();
        List<Integer> lista=new ArrayList<>();
        for (int j=0;j<1000;j++){
            int positionSeleccionable=0;
            double numRandom01=random.nextDouble();
            double resultOfSeleccionable=Math.max(numRandom01,matrix[0][1])-Math.min(numRandom01,matrix[0][1]);
            for(int i=0;i<matrix.length;i++){
                if((Math.max(numRandom01,matrix[i][1])-Math.min(numRandom01,matrix[i][1]))<resultOfSeleccionable){
                    positionSeleccionable=i;
                    resultOfSeleccionable=matrix[i][1];
                }
            }
            lista.add(positionSeleccionable);
        }
        System.out.println(mostrarvector(lista));


    }

    public static String mostrarvector(List<Integer> lista){
        String cad="";
        for(int i=0;i<lista.size();i++){
            if (i%30==0){
                cad+=lista.get(i)+"\n";
            }
            else
                cad+=lista.get(i)+"   ";
        }
        return cad;
    }

    public static void showMatrix(double m[][]){

        for (int i=0;i<m.length;i++){
            for (int j=0;j<m[0].length;j++){
                System.out.print(m[i][j]+"\t");
            }
            System.out.println();
        }
    }

}
