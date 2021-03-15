package DistribucionNormal;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

public class DistribucionFisher {

    public static double generateNumber(){
        double media=33;
        double sigma=5.0;
        double n=1000;
        double euler=2.7183;
        double pi=3.1416;
        double numaleatorio=Math.random()*(1.0-0.0);
        double c=1.0;
        double acumulado=0.00000;
        double deltaX=(6*sigma)/n;
        double valorvar=0.0;
        while (acumulado<numaleatorio)
        {
            valorvar=(Math.pow(euler,-((Math.pow(((c*deltaX)-media),2))/(2*sigma*sigma)))*deltaX)*(1/Math.pow(2*pi*Math.pow(sigma,2),0.5));;
            acumulado+=valorvar;
            c++;
        }
        DecimalFormatSymbols separadoresPersonalizados = new DecimalFormatSymbols();
        separadoresPersonalizados.setDecimalSeparator('.');
        DecimalFormat df=new DecimalFormat("#.00",separadoresPersonalizados);


        return Double.parseDouble(df.format(c*deltaX));
    }

}
