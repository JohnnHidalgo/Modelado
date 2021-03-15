package PruebaTConColas;

import java.util.Scanner;

public class PruebaT {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner leer=new Scanner(System.in);
        double x[]=new double[84];
        double x2[]=new double[64];
        x[0]=103.25;x[1]=91.19;x[2]=97.19;x[3]=82.38;x[4]=98.13;x[5]=102.22;x[6]=112.18;
        x[7]=114.11;x[8]=101.71;x[9]=101.60;x[10]=99.45;x[11]=96.59;x[12]=100.12;
        x[13]=88.56;x[14]=98.06;x[15]=96.92;x[16]=99.06;x[17]=99.78;x[18]=102.49;
        x[19]=103.43;x[20]=103.21;x[21]=99.21;x[22]=98.87;x[23]=101.90;x[24]=102.30;
        x[25]=77.57;x[26]=88.13;x[27]=98.86;x[28]=108.46;x[29]=102.41;x[30]=110.79;
        x[31]=110.60;x[32]=108.93;x[33]=106.29;x[34]=101.02;x[35]=103.38;x[36]=91.89;
        x[37]=61.26;x[38]=98.85;x[39]=102.65;x[40]=112.70;x[41]=113.35;x[42]=113.20;
        x[43]=112.25;x[44]=104.45;x[45]=105.02;x[46]=100.07;x[47]=102.96;x[48]=103.81;
        x[49]=88.54;x[50]=96.61;x[51]=103.58;x[52]=111.38;x[53]=117.75;x[54]=128.45;
        x[55]=131.22;x[56]=123.98;x[57]=114.35;x[58]=97.86;x[59]=94.38;x[60]=90.15;
        x[61]=87.28;x[62]=99.65;x[63]=104.37;x[64]=116.94;x[65]=118.01;x[66]=124.32;
        x[67]=126.15;x[68]=117.76;x[69]=115.63;x[70]=108.16;x[71]=109.86;x[72]=104.94;
        x[73]=91.77;x[74]=100.24;x[75]=99.93;x[76]=117.80;x[77]=120.96;x[78]=132.44;
        x[79]=126.09;x[80]=118.10;x[81]=113.33;x[82]=104.63;x[83]=101.60;

        x2[0]=93.26;x2[1]=84.67;x2[2]=92.10;x2[3]=92.78;x2[4]=94.72;x2[5]=95.45;x2[6]=104.92;
        x2[7]=110.04;x2[8]=107.96;x2[9]=107.97;x2[10]=104.01;x2[11]=112.11;x2[12]=111.19;
        x2[13]=95.50;x2[14]=111.52;x2[15]=107.20;x2[16]=106.85;x2[17]=103.56;x2[18]=111.76;
        x2[19]=108.86;x2[20]=102.82;x2[21]=108.10;x2[22]=100.76;x2[23]=103.96;x2[24]=102.62;
        x2[25]=84.03;x2[26]=107.51;x2[27]=102.00;x2[28]=102.00;x2[29]=99.75;x2[30]=104.14;
        x2[31]=104.20;x2[32]=97.19;x2[33]=109.83;x2[34]=101.48;x2[35]=99.57;x2[36]=105.34;
        x2[37]=94.22;x2[38]=101.87;x2[39]=97.93;x2[40]=101.08;x2[41]=99.33;x2[42]=106.17;
        x2[43]=103.73;x2[44]=105.97;x2[45]=119.29;x2[46]=118.17;x2[47]=122.59;x2[48]=122.30;
        x2[49]=108.15;x2[50]=122.67;x2[51]=119.30;x2[52]=122.15;x2[53]=123.20;x2[54]=127.10;
        x2[55]=126.78;x2[56]=124.82;x2[57]=129.09;x2[58]=122.30;x2[59]=126.65;x2[60]=128.00;
        x2[61]=121.96;x2[62]=131.51;x2[63]=127.63;



        double y,n1,n2,s1,s2,u,desv,d0=0,nivel=95;String k="";
        y=prom(x2);u=prom(x);
        System.out.println(y+" media real");
        System.out.println(u+" media simulado");
        n1=84;n2=64;
        s1=sum(x2,y);
        s2=sum(x,u);
        desv=desvmedia(s1,s2,n1,n2);
        //desv=desvvarianza(n1,s1,n2,s2);
        //System.out.println(s1+" desviacion 1");
        //System.out.println(s2+" desviacion 2");
        System.out.println(desv+" desviacion");
        k=pruebaT(desv,y,u,n1,n2,d0,nivel);
        System.out.println(k);
		/*
		 * System.out.println("Ingrese la media muestral");
		y=leer.nextDouble();
		System.out.println("Ingrese la desviacion tipica");
		s=leer.nextDouble();
		System.out.println("Ingrese el tamanio de la muestra");
		n=leer.nextDouble();
		System.out.println("Ingrese el promedio");
		u=leer.nextDouble();
		*/

    }
    public static double prom(double x[]) {
        double cont=0,prom=0;
        for(int i=0;i<x.length;i++) {
            prom+=x[i];
            cont++;
        }
        return prom/cont;
    }
    public static String pruebaT(double desv,double y1,double y2,double n1,double n2,double d0,double nivel) {
        String resp="";double t=0;double alfa=0,alfamedios=0;
        t=(y1-y2)/(desv*Math.sqrt((1/n1)+(1/n2)));
        System.out.println(t+" es el valor de T");

        if(nivel==95) {
            alfa=1.796;alfamedios=2.201;
        }
        else if(nivel==97.5)alfa=2.365;


        if(t<0){
            t*=-1;
            if(t>alfamedios) resp+="Se rechaza la hipotesis nula de que son iguales";
        }else if(t>alfamedios) resp+="Se rechaza la hipotesis nula de que son iguales";



        if(t>alfa)resp+="Se rechaza la hipotesis nula porque cae en la cola derecha";
        else if(t<alfa) {
            resp+="Se rechaza la hipotesis nula porque cae en la cola izquierda";
        }
        return resp;
    }
    public static double desvmedia(double s1,double s2,double n1,double n2) {
        double s=0;
        s=Math.sqrt((s1+s2)/(n1+n2-2));
        return s;
    }
    public static double desvvarianza(double s1,double n1,double s2,double n2) {
        double desv=0;
        desv=Math.sqrt((((n1-1)*Math.pow(s1, 2))+((n2-1)*Math.pow(s2, 2)))/(n1+n2-2));
        return desv;
    }
    public static double sum(double x[],double media) {
        double sum=0,proc;
        for(int i=0;i<x.length;i++) {
            sum+=Math.pow((x[i]-media), 2);
        }

        return sum;
    }
}
