package Experiencia1;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.List;

public class Ejercicio8 {

    public static void main(String[] args){
        List<Double> totalMinutesList=new ArrayList<>();
        List<Double> listLlegadas=new ArrayList<>();
        List<Double> listLlegadasEnFalla=new ArrayList<>();
        List<Integer> listProcesamiento=new ArrayList<>();
        List<Integer> fallasEnProduccion=new ArrayList<>();
        int horario=1;
        int acumulado=0;
        int verificarZonaHoraria=0;
        int tiempoDeLaFalla=1;
        int acumuladoDeLaFalla=0;
        boolean activarAcumulado=true;
        boolean vuelveAOperacionDespuesDeLaFalla=false;
        boolean enEstadoDeReparacion=false;
        int tiempoEntreFallas=((int)(Math.random()*(43-33)+33))*60;
        int tiempoFallas=0;
        DecimalFormatSymbols separadoresPersonalizados = new DecimalFormatSymbols();
        separadoresPersonalizados.setDecimalSeparator('.');
        DecimalFormat df=new DecimalFormat("#.00",separadoresPersonalizados);

        while (getSumVector(totalMinutesList)<=10080.0){
//        while (getSumVector(totalMinutesList)<=10080){
            if(acumulado>=tiempoEntreFallas && activarAcumulado==true){
                if(horario % 2==0){
                    //DE PM A AM
                    tiempoFallas=((int)(Math.random()*(17-11)+11))*60;
                }
                else {
                    //DE AM A PM
                    tiempoFallas=((int)(Math.random()*(7-3)+3))*60;
                }
                activarAcumulado=false;
                acumulado=0;
                enEstadoDeReparacion=true;
                tiempoEntreFallas=((int)(Math.random()*(43-33)+33))*60;
            }

            if(enEstadoDeReparacion && activarAcumulado==false){
                if(acumuladoDeLaFalla<tiempoFallas){
                    //AGREGAR TIEMPO DE LLEGADAS A LAS FALLAS
                    double numRandom01=(Math.random()*(6-4))+4.0;//de 4 a 6
                    listLlegadasEnFalla.add(numRandom01);
                    acumuladoDeLaFalla+=numRandom01;
                }
                else {
                    enEstadoDeReparacion=false;
//                    totalMinutesList.add(tiempoDeLaFalla);
//                    tiempoFallas=0;
//                    tiempoDeLaFalla=0;
                    vuelveAOperacionDespuesDeLaFalla=true;
                    acumuladoDeLaFalla=0;
                    System.out.println("Las llegadas que ocurrieron durante la falla ");
                    System.out.println(showVector(listLlegadasEnFalla));
                }
            }
//            else {
            if(vuelveAOperacionDespuesDeLaFalla){
                for(int i=0;i<listLlegadasEnFalla.size();i++){
                   listLlegadas.add(listLlegadasEnFalla.get(i));
                   double numRandom02=Math.random();
                   double[][] matrix={
                           {1.0,0.4,0.45},
                           {2.0,0.3,0.70},
                           {5.0,0.20,0.90},
                           {10.0,0.1,1.0},
                   };

                   int positionSeleccionable=(int)matrix[0][0];
                   for(int j=0;j<matrix.length;j++){
                       double resultOfSeleccionable=Math.max(numRandom02,matrix[0][1])-Math.min(numRandom02,matrix[0][1]);
                       if((Math.max(numRandom02,matrix[j][1])-Math.min(numRandom02,matrix[j][1]))<resultOfSeleccionable){
                           positionSeleccionable=(int)matrix[j][0];
                       }

                   }
                   listProcesamiento.add(positionSeleccionable);
                   totalMinutesList.add((double)positionSeleccionable);

               }
                listLlegadasEnFalla.clear();
                activarAcumulado=true;
                vuelveAOperacionDespuesDeLaFalla=false;
            }
//                else {
            if(activarAcumulado){
                //Llegadas
                double numRandom01=(Math.random()*(7-4)+4);//de 4 a 6
                totalMinutesList.add(numRandom01);
                acumulado+=numRandom01;
                if(getSumVector(totalMinutesList)>10080){
                    break;
                }
                listLlegadas.add(numRandom01);
                totalMinutesList.add(numRandom01);
                acumulado+=numRandom01;

                //Procesamiento
                double numRandom02=Math.random();
                double[][] matrix={
                        {1.0,0.4,0.45},
                        {2.0,0.3,0.70},
                        {5.0,0.20,0.90},
                        {10.0,0.1,1.0},
                };

                int positionSeleccionable=1;
                double resultOfSeleccionable=Math.max(numRandom02,matrix[0][1])-Math.min(numRandom02,matrix[0][1]);
                for(int i=0;i<matrix.length;i++){
                    if((Math.max(numRandom02,matrix[i][1])-Math.min(numRandom02,matrix[i][1]))<resultOfSeleccionable){
                        positionSeleccionable=(int)matrix[i][0];
                        resultOfSeleccionable=Math.max(numRandom02,matrix[i][1])-Math.min(numRandom02,matrix[i][1]);
                    }
                }
                listProcesamiento.add(positionSeleccionable);
                totalMinutesList.add((double)positionSeleccionable);
                acumulado+=positionSeleccionable;

            }

          //      }

            //}

            //Fallas
            if(acumulado >= 288){
                horario++;
            }
            System.out.println("La suma parcial total es "+getSumVector(totalMinutesList));
            System.out.println("El acumulado es  "+acumulado);

        }
        System.out.println("Vector de llegadas: ");
        System.out.println(showVector(listLlegadas));

        System.out.println("Vector de procesamiento: ");
        System.out.println(mostrarvector(listProcesamiento));

        System.out.println("Tiempo total invertido");
        System.out.println(showVector(totalMinutesList));

        System.out.println("LLegadas "+listLlegadas.size());


    }



    public static String mostrarvector(List<Integer> lista){
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

    public static String showVector(List<Double> lista){
        DecimalFormatSymbols separadoresPersonalizados = new DecimalFormatSymbols();
        separadoresPersonalizados.setDecimalSeparator('.');
        DecimalFormat df=new DecimalFormat("#.00",separadoresPersonalizados);
        String cad="";
        for(int i=0;i<lista.size();i++){
            if(i %30==0){
                cad+=df.format(lista.get(i))+"\n";
            }
            else {
                cad+=df.format(lista.get(i))+"   ";
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

}
