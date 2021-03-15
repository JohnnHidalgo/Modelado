package PruebaChiCuadrado;

import java.math.BigInteger;

public class EjercicioPoisson {

    public static void main(String args[]){

        double numIntervalos=Math.sqrt(299);

        double[][] matrix={
                {0.0,5.0},
                {1.0,4.0},
                {2.0,4.0},
                {3.0,3.0},
                {4.0,3.0},
                {5.0,3.0},
                {6.0,1.0},
                {7.0,3.0},
                {9.0,2.0},
                {10.0,2.0},
                {11.0,2.0},
                {12.0,5.0},
                {13.0,2.0},
                {14.0,2.0},
                {15.0,1.0},

        };
        System.out.println(numIntervalos);
        System.out.println(factorial(100));
        System.out.println(getFactorial(100));

    }

    public static double getMedia(double matrix[][]){
        double sum=0;
        for(int i=0;i<matrix.length;i++){
            sum+=matrix[i][0];
        }
        return sum/matrix.length;
    }

    public static double getFxPoisson(double lambda,int i){
            double px=(Math.pow(Math.E,-lambda)*Math.pow(lambda,i))/factorial(i);
        return px;
    }

    public static double factorial(double n){

        if(n<=1.0) return 1;

        else
            return (n*factorial(n - 1));

    }

    public static double getT(double matrix[][]){
        double sum=0;
        double tamanio=98;
        for(int i=0;i<matrix.length;i++){
            sum+=Math.pow(matrix[i][1]-tamanio*matrix[i][2],2)/(tamanio*matrix[i][2]);
        }
        return sum;
    }

    public static BigInteger getFactorial(int number){
        BigInteger aux = BigInteger.ONE;
        for (int i = 1; i <= number; i++) {
            aux = aux.multiply(BigInteger.valueOf(i));
//            aux *= i;
        }
//        if (number == 0)
//            return 1;
//        return number * factorial(number - 1);
        return aux;
    }

}
