package ModeladoExamen;

public class Sumatoria1 {

    public static void main(String args[]){

        double result=0.0;
        for(int j=3;j<=5;j++){
            for(int i=2;i<=3;i++){
                result+=Math.pow(Math.E,-Math.pow(i*0.02,2))*Math.pow(Math.E,-Math.pow(j*0.01,2))*(0.02*0.01);

            }
        }
        System.out.println("Resultado es "+result);
    }
}
