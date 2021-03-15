package CoeficienteDeterminacionAjustado;

import java.util.ArrayList;
import java.util.List;

public class CoeficienteDeterminacionAjustado {

    public static List<Double> hallarYEstimadas(Double[][]xMatrix,Double[][] betasMatrix){
        ArrayList<Double> Yestimadas=new ArrayList<>();
        for (int i=0;i<xMatrix.length;i++){
            Double yestimada=0.0;
            for (int j=0;j<xMatrix[0].length;j++){
                    yestimada+=xMatrix[i][j]*betasMatrix[j][0];
            }
            Yestimadas.add(yestimada);
        }
        return Yestimadas;
    }

    public static double getMedia(Double [][]yMatrix){
        double suma=0;
        int contador=0;
        for(int i=0;i<yMatrix.length;i++){
            for(int j=0;j<yMatrix[0].length;j++){
                suma+=yMatrix[i][j];
            }
            contador++;
        }
        return suma/contador;
    }

    public static double getMediaEstimadas(List<Double> estimadasY){
        double suma=0;
        for(int i=0;i<estimadasY.size();i++){
            suma+=estimadasY.get(i);
        }
        return suma/estimadasY.size();
    }


    public static double getSEC(List<Double> YestimadasList,double mediaYestimadas){
        double suma=0;
        for(int i=0;i<YestimadasList.size();i++){
//            suma+=Math.pow(((YestimadasList.get(i))-mediaYestimadas),2);
            suma+=((YestimadasList.get(i))-mediaYestimadas);

        }
        return suma;
    }


    public static double getSTC(double mediaY, Double[][] yMatrix){
        double suma=0;
        for (int i=0;i<yMatrix.length;i++){
            for (int j=0;j<yMatrix[0].length;j++){
                suma+=Math.pow(yMatrix[i][j]-mediaY,2);
            }
        }
        return suma;
    }

    public static double getVarianzaErrores(double mediaY, List<Double> errores){
        double suma=0;
        for (int i=0;i<errores.size();i++){
                suma+=Math.pow(errores.get(i)-mediaY,2);
        }
        double res=suma/errores.size();
        return res;
    }


    public static List<Double> getErroresList(Double[][] yMatrix, List<Double> estimadasY){
        List<Double> erroresList=new ArrayList<>();
        for(int i=0;i<estimadasY.size();i++){
//            erroresList.add(Math.pow(yMatrix[i][0]-estimadasY.get(i),2));
            erroresList.add(yMatrix[i][0]-estimadasY.get(i));
        }
        return erroresList;
    }


    public static double getSRC(Double[][] yMatrix,List<Double> estimadasY){
        double suma=0;
        List<Double> erroresList=getErroresList(yMatrix,estimadasY);
        for(Double i:erroresList){
            suma+=i;
        }
        return suma;
    }


}
