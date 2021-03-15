package ModeladoExamen;

public class SumatoriaDos {

    public static void main(String args[]){

        double result=0.0;
        for(int i=1;i<=100;i++){
            for(int j=1;j<=100;j++){
                result+=Math.pow(Math.E,-Math.pow((i*0.01)+2.0,2))*Math.pow(Math.E,-Math.pow((j*0.02)+3.0,2))*(0.02*0.01);
            }
        }
        System.out.println("Resultado es "+result);
    }

}
