package Experiencia1;

import DistribucionNormal.DistribucionFisher;
import DistribucionNormal.DistribucionGeometrica;
import DistribucionNormal.distribucionNormal;

import java.util.ArrayList;
import java.util.List;

public class Ejercicio14 {
    public static void main(String[] args){
        List<Double> totalMinutesList=new ArrayList<>();
        List<Double> listLlegadasEnFalla=new ArrayList<>();
        List<Double> listRepare=new ArrayList<>();
        double acumulado=0.0;
        int tiempoDeLaFalla=1;
        int acumuladoDeLaFalla=0;
        boolean activarAcumulado=true;
        boolean enEstadoDeReparacion=false;
        double tiempoEntreFallas= distribucionNormal.generateNumber();
        int tiempoFallas=0;

        for(int i=0;i<100;i++){
            double fisherGenerate= DistribucionFisher.generateNumber();
            listLlegadasEnFalla.add(fisherGenerate);
        }
        for(int i=0;i<100;i++){
            double geometricGenerate= DistribucionGeometrica.generateGeometricNumbers();
            listRepare.add(geometricGenerate);
        }

        System.out.println("Lista de tiempo entre fallos");
        System.out.println(mostrarvector(listLlegadasEnFalla));
        System.out.println("Lista de tiempo de reparación");
        System.out.println(mostrarvector(listRepare));
        System.out.println("La esperanza del tiempo entre fallas es: ");
        System.out.println(getMedia(listLlegadasEnFalla));

    }



    public static String mostrarvector(List<Double> lista){
        String cad="";
        for(int i=1;i<=lista.size();i++){
            if(i %30==0){
                cad+=lista.get(i-1)+"\n";
            }
            else {
                cad+=lista.get(i-1)+"   ";
            }
        }
        return cad;
    }

    public static int getSumVector(List<Double> vector){
        int sum=0;
        for(int i=0;i<vector.size();i++){
            sum+=vector.get(i);
        }
        return sum;
    }

    public static double getMedia(List<Double> list){
        double sum=0.0;
        for(int i=0;i<list.size();i++){
            sum+=list.get(i);
        }
        return sum/(double)list.size();

    }

}
