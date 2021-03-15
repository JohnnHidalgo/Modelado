package DistribucionNormal;

import Graficas.Graficator;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class DistibucionGamma {

    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        System.out.print("Alpha: ");
        int alpha=scanner.nextInt();
        System.out.print("Beta: ");
        double beta=scanner.nextInt();
        double factorialalpha=factorialFunction(alpha);
        Random random=new Random();
        List<Double> listY=new ArrayList<>();
        List<Double> listX=new ArrayList<>();
        double c=1.0;
        double sigma=Math.sqrt(alpha/Math.pow(beta,2));
        double acumulado=0.00000;
        double deltaX=(6*sigma)/1000;
        for (int i=0;i<1000;i++){
            double aleatorio=random.nextDouble();
            c++;
            System.out.println("El acumulado es "+aleatorio);
            while (acumulado<aleatorio)
            {
                double valorvar=((Math.pow(beta,alpha))/factorialalpha)*Math.pow(/*c*/aleatorio*deltaX,alpha-1)*Math.pow(Math.E,-beta*c*deltaX);
//               acumulado+=(Math.pow(euler,-(Math.pow(((c*deltaX)-media)/sigma,2)))*deltaX)*(1/Math.pow(2*pi*Math.pow(sigma,2),0.5));
                acumulado+=valorvar;
//                System.out.println("Acumulado "+acumulado);
//                System.out.println("Numero generado "+numaleatorio);
//                acumulado+=Math.pow(Math.E,Math.pow(-((deltaX-media)/sigma),2))*(6*sigma/n)/Math.sqrt(2*Math.PI*Math.pow(sigma,2));
//                acumulado+=(6*sigma)/10000*Math.pow(-0.5*Math.pow((c*(6*sigma/10000))),2);
                //c++;
            }
            System.out.println("Las medias son "+c*deltaX);
            listX.add(acumulado);
            listY.add(c*deltaX);
        }
        JFrame ventana = new JFrame("Grafica");
        ventana.setSize(800, 600);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        ventana.add(Graficator.graficar(vecgenerados));
        ventana.add(Graficator.graficar2(listY,listX));
        ventana.setVisible(true);
    }


    public static int factorialFunction(int gamma){
        int cont=gamma-1;
        int result=gamma;
        while (cont>0){
            result=result*cont;
            cont--;
        }
        System.out.println("Resultado factorial "+result);
        return result;
    }
}
