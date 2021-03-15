package Experiencia1;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Ejercicio2 {

    public static void main(String[] args){
        Random random=new Random();
        List<Double> listN=new ArrayList();
        List<Double> listNmin=new ArrayList<>();
        for(int j=0;j<1000;j++)
        {
            for(int i=0;i<1000;i++){
                double contador=1.0;
                double acumulate=random.nextDouble();
                System.out.println("El acumulado inicial es "+acumulate);
                while (acumulate>Math.pow(Math.E,-3)){
//                      System.out.println("El acumulado parcial "+acumulate);
                    acumulate*=random.nextDouble();
                    contador++;
//                    double value=random.nextDouble();
                }
                listN.add(contador);
            }
            listNmin.add(getNMax(listN));
            listN.clear();
        }
        double esperanceN=getHalf(listNmin);
        System.out.println(mostrarvector(listNmin));
        System.out.println("La esperanza es: "+esperanceN);

    }

    public static double getHalf(List<Double> list){
        double sum=0.0;
        for (int i=0;i<list.size();i++){
            sum+=list.get(i);
        }
        return sum/list.size();

    }
    public static String mostrarvector(List<Double> lista){
        String cad="";
        for(int i=0;i<lista.size();i++){
            cad+=lista.get(i)+"\n";
        }
        return cad;
    }

    public static double getNMax(List<Double> listN){
        double min=listN.get(0);
        for(int i=0;i<listN.size();i++){
            if(listN.get(i)>min){
                min=listN.get(i);
            }
        }
        return min;
    }


}
