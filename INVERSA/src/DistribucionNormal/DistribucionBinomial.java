package DistribucionNormal;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class DistribucionBinomial {

    public static void main(String[] args){

        Scanner scanner=new Scanner(System.in);
//        System.out.print("Ingrese P: ");
//        double p=scanner.nextDouble();
//        System.out.print("Ingrese N: ");
//        double n=scanner.nextDouble();
        double p=0.4;
        int n=10;
        double[][] matrix=new double[11][3];
        double fx=0.0;
        for(int i=0;i<11;i++){
            double px=combinatoria(n,i)*Math.pow(p,i)*Math.pow(1-p,n-i);
            fx+=px;
            matrix[i][0]=i;
            matrix[i][1]=px;
            matrix[i][2]=fx;
        }
        System.out.println("La matriz es: ");
        showMatrix(matrix);


        DecimalFormatSymbols separadoresPersonalizados = new DecimalFormatSymbols();
        separadoresPersonalizados.setDecimalSeparator('.');

        DecimalFormat formato1 = new DecimalFormat("#.00", separadoresPersonalizados);
        Random random=new Random();
        List<Integer> lista=new ArrayList<>();
        for (int j=0;j<1000;j++){
            double numRandom01=random.nextDouble();
            for(int i=0;i<matrix.length;i++){
                if(formato1.format(matrix[i][1]).equals(formato1.format(numRandom01))){
                    lista.add(i);
                }
            }
        }
        System.out.println(mostrarvector(lista));
    }

    public static String mostrarvector(List<Integer> lista){
        String cad="";
        for(int i=0;i<lista.size();i++){
            cad+=lista.get(i)+" \n";
        }
        return cad;
    }
    public static double factorial(int n){

        if(n<=1.0) return 1;

        else     return (n*factorial(n - 1));

    }

//Calculo de C=   n!/r!(n-r)!

    public static double combinatoria(int n, int r){

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

        public static double getBinomialProbability(int n, int i,int p){
            double px=combinatoria(n,i)*Math.pow(p,i)*Math.pow(1-p,n-i);
            return px;

        }

        public static double getBinomialAcumulateDistribution(int n, int i, int p){
            double fx=0.0;
            for(int c=0;c<=i;c++){
                fx+=i*combinatoria(n,i)*Math.pow(p,i)*Math.pow(1-p,i);
            }
            return fx;

        }


}
