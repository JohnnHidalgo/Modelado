package Experiencia1;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Ejercicio1 {

    public static void main(String[] args){
        Random random=new Random();
        List<Double> listN=new ArrayList();
        List<Double> listNmin=new ArrayList<>();
        for(int j=0;j<10000;j++)
        {
            double contador=1.0;
           for(int i=0;i<10000;i++){
                double acumulate=0.0;
                while (acumulate<=1.0){
                    double value=random.nextDouble();
                    acumulate+=value;
                    contador++;
                }
                listN.add(contador);
            }
            listNmin.add(getNMin(listN));
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

    public static double getNMin(List<Double> listN){
        double min=listN.get(0);
        for(int i=0;i<listN.size();i++){
            if(listN.get(i)<min){
                min=listN.get(i);
            }
        }
        return min;
    }

}
