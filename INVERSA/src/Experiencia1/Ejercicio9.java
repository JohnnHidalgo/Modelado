package Experiencia1;

import DistribucionNormal.DistribucionExponencial;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class Ejercicio9 {
    public static void main(String args[]){
        double numTotalMin=0.0;
        //CAJA ESTANDAR 1
        //CAJA RAPIDA 2
        //CAJA ESPECIAL 3
        List<String> processmentOfStandarBox=new ArrayList<>();
        List<String> processmentOfEspecialBox=new ArrayList<>();
        List<String> processmentOfFastBox=new ArrayList<>();
        List<Integer> articlesList=new ArrayList<>();
        int[] stateOFTheboxesStandar={0,0,0,0,0,0};
        int[] stateOFTheFastBoxes={0,0};
        int stateOfTheEspecialBox=0;
        int typeOfarticles=0;
        List<Integer> listOfClientsLLegadas=new ArrayList<>();
        DecimalFormat df = new DecimalFormat("#.00");
        while (numTotalMin<600.0){
            //Llegadas
            int clientLlegada=(int)(Math.random()*(3))+1;
            listOfClientsLLegadas.add(clientLlegada);
            int typeOfBox=0;
            int numberOfArticles=(int) DistribucionExponencial.generateExponentialNumber(12.0);
            articlesList.add(numberOfArticles);
            System.out.println(numberOfArticles);

            //DEFINIENDO A QUE CAJA VA EL CLIENTE
            if(numberOfArticles<=5){

                if(numberOfArticles<=2){

                    typeOfBox=(int)(Math.random()*(3))+1;
                    System.out.println("SI");
                }
                else {
                    typeOfBox=(int)(Math.random()*(2))+1;
                }

            }
            else{
                typeOfBox=1;
            }

            if(typeOfBox==1){
                int numberOfBoxStandard=(int)(Math.random()*(6));
                System.out.println("El cliente fue a la caja estandar nro: "+(numberOfBoxStandard+1));
                stateOFTheboxesStandar[numberOfBoxStandard]++;
                numTotalMin+=(6.0/60.0)*(double)numberOfArticles;
                processmentOfStandarBox.add(df.format((6.0/60.0)*(double)numberOfArticles));

            }
            else
                if(typeOfBox==2){
                    int numberOfBoxFast=(int)(Math.random()*2);
                    System.out.println("El cliente fue a la caja rapida nro: "+(numberOfBoxFast+1));
                    stateOFTheFastBoxes[numberOfBoxFast]++;
                    numTotalMin+=(5.0/60.0)*(double)numberOfArticles;
                    processmentOfFastBox.add(df.format((5.0/60.0)*(double)numberOfArticles));
                    System.out.println("El resultado del procesamiento es: "+((5.0/60.0)*(double)numberOfArticles)+1);


                }
                else {
                    if(typeOfBox==3){
                        System.out.println("El cliente fue a la caja especial");
                        numTotalMin+=(double)((6)*numberOfArticles);
                        stateOfTheEspecialBox++;
                        processmentOfEspecialBox.add(df.format(6.0*(double)numberOfArticles));
                    }
                }

                System.out.println("Los minutos totales "+numTotalMin);
//                totaltimeList.add();
        }
        System.out.println("La lista de llegadas de clientes sigue lo siguiente: ");
        System.out.println(mostrarvectorInteger(listOfClientsLLegadas));
        System.out.println("La lista de articulos demandados por los clientes sigue lo siguiente: ");
        System.out.println(mostrarvectorInteger(articlesList));
        System.out.println("La lista de procesamiento de clientes en caja estandar sigue lo siguiente: ");
        System.out.println(mostrarvector(processmentOfStandarBox));
        System.out.println("La lista de procesamiento de clientes en caja rapida sigue lo siguiente: ");
        System.out.println(mostrarvector(processmentOfFastBox));
        System.out.println("La lista de procesamiento de clientes en caja especial sigue lo siguiente: ");
        System.out.println(mostrarvector(processmentOfEspecialBox));


        System.out.println("El total de clientes en caja estandar sigue lo siguiente: ");
        System.out.println(showVector(stateOFTheboxesStandar));
        System.out.println("El total de clientes en caja rapida sigue lo siguiente: ");
        System.out.println(showVector(stateOFTheFastBoxes));
        System.out.println("El total de clientes en caja estandar sigue lo siguiente: \n"+stateOfTheEspecialBox);


    }

    public static String mostrarvector(List<String> lista){
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
    public static String mostrarvectorInteger(List<Integer> lista){
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

    public static String showVector(int vector[]){
        String cad="{ ";
        for (int i=0;i<vector.length;i++){
            if(i==vector.length-1){
                cad+=vector[i]+" }";
            }
            else {
                cad+=vector[i]+" ";
            }
        }
        return cad;
    }
    public static int getSumVector(List<Integer> vector){
        int sum=0;
        for(int i=0;i<vector.size();i++){
            sum+=vector.get(i);
        }
        return sum;
    }


}
