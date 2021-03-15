package Experiencia1;

import java.util.ArrayList;
import java.util.List;

public class Ejercicio3 {

    public static void main(String[] args){
        List<Double> listN=new ArrayList();
        int[] vector={1,2,3,4,5,6};
        int sum=0;
        for(int i=0;i<50000;i++){

            int dado1=vector[(int)(Math.random()*5)+1];
            System.out.println("Dado 1 "+dado1);
            int dado2=vector[(int)(Math.random()*5)+1];
            System.out.println("Dado 2 "+dado2);
            int dado3=vector[(int)(Math.random()*5)+1];
            System.out.println("Dado 3 "+dado3);
            int dado4=vector[(int)(Math.random()*5)+1];
            System.out.println("Dado 4 "+dado4);
            int dado5=vector[(int)(Math.random()*5)+1];
            System.out.println("Dado 5 "+dado5);

            sum=((int)(Math.random()*5)+1)+((int)(Math.random()*5)+1)+((int)(Math.random()*5)+1)+((int)(Math.random()*5)+1)+((int)(Math.random()*5)+1);
            System.out.println("La suma es: "+sum);
        }

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
}
