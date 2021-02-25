package regresionlineal;

import java.util.ArrayList;

public class Regresion {
	public static String getEcuacion(ArrayList<Double> y, ArrayList<Double> x) {
		String ecuacion;
		ecuacion = "y = "+getB0(y, x)+" + "+getB1(y, x)+"x";
		return ecuacion;
	}

	
	public static Double getB0(ArrayList<Double> y, ArrayList<Double> x) {
		Double B0;
		B0 = getPromedio(y) - (getB1(y, x) * getPromedio(x));
		return B0;
	}
	
	
	public static Double getB1(ArrayList<Double> y, ArrayList<Double> x) {
		Double B1;
		B1 = (getSumatoriaDeDosVariables(y, x)-(getPromedio(y)*getSumatoriaUnaVariable(x)))/(getSumatoriaDatoAlCuadrado(x)-(getPromedio(x)*getSumatoriaUnaVariable(x)));
		return B1;
	}
	
	
	public static Double getPromedio(ArrayList<Double> datos) {	
		Double suma= 0.0;
		for (int i=0; i<datos.size();i++) {
			suma=suma+datos.get(i);
		}
		return suma/datos.size();
	}
	
	
	public static Double getSumatoriaDatoAlCuadrado(ArrayList<Double> datos) {
		Double suma= 0.0;
		for (int i=0; i<datos.size();i++) {
			suma=suma+(datos.get(i)*datos.get(i));
		}
		return suma;
	}
	
	public static Double getSumatoriaUnaVariable(ArrayList<Double> datos) {	
		Double suma= 0.0;
		for (int i=0; i<datos.size();i++) {
			suma=suma+(datos.get(i));
		}
		return suma;
	}
	
	public static Double getSumatoriaDeDosVariables(ArrayList<Double> datosy, ArrayList<Double> datosx) {	
		Double suma= 0.0;
		for (int i=0; i<datosy.size();i++) {
			suma=suma+(datosy.get(i)*datosx.get(i));
		}
		return suma;
	}
	
	
	
	public static Double getCovarianza(ArrayList<Double> datosy, ArrayList<Double> datosx) {	
		Double suma= 0.0;
		suma = (getSumatoriaDeDosVariables(datosy,datosx)/datosx.size())-(getPromedio(datosy)*getPromedio(datosx));
		return suma;
	}
	
	
	public static Double getDesviacionTipica(ArrayList<Double> datos) {	
		Double suma= 0.0;
		Double operacion = (getSumatoriaDatoAlCuadrado(datos)/datos.size())-(getPromedio(datos)*getPromedio(datos));
		suma = Math.sqrt(operacion);
		
		return suma;
	}
	
	
	public static Double getCorrelacion(ArrayList<Double> datosy, ArrayList<Double> datosx) {	
		Double suma= 0.0;
		suma = (getCovarianza(datosy, datosx))/(getDesviacionTipica(datosx)*getDesviacionTipica(datosy));
		return suma;
	}
	
	
	public static void informe(ArrayList<Double> datosy, ArrayList<Double> datosx, String y, String x) {	
		System.out.println(y+" / "+x);
		System.out.print("Ecuacion :  ");
		System.out.println(Regresion.getEcuacion(datosy, datosx));
		System.out.print("Coeficiente de Correlacion Lineal :  ");
		System.out.println(Regresion.getCorrelacion(datosy, datosx));
		System.out.print("Coeficiente de R cuadrado :  ");
		System.out.println(Regresion.getCorrelacion(datosy, datosx)*Regresion.getCorrelacion(datosy, datosx));
		System.out.println();
		System.out.println();
	}
	
}
