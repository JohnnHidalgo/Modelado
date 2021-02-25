package hallarparametros;

import java.util.ArrayList;

public class Operaciones {
	
	public static String getEcuacion(ArrayList<Double> y, ArrayList<Double> x) {
		String ecuacion;
		ecuacion = "y = "+getB0(y, x)+" + "+getB1(y, x)+"x";
		return ecuacion;
	}


	public static Double getParametroY(ArrayList<Double> y, ArrayList<Double> x) {
		Double YW;
		YW = getSumatoriaDeDosVariables(y,x) / getSumatoriaDatoAlCuadrado(x);
		return YW;
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
	
	
	
	public static void informeEjercicio6(ArrayList<Double> datosy, ArrayList<Double> datosx, String y, String x) {	
		System.out.print("Valor del parámetro con respecto a :  "+y+" / "+x+":  ");
		System.out.println(Operaciones.getParametroY(datosy, datosx));
		System.out.println();		
	}	

}
