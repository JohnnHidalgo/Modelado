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
	
	
	
	public static void getSistemaEcuaciones(ArrayList<Double> datosy, ArrayList<Double> datosx1, ArrayList<Double> datosx2, ArrayList<Double> datosx3) {	
		System.out.println("Sistema de Ecuaciones");

		System.out.println("1\t771\t218\t94\t80.10");
		System.out.println("771\t16131\t4542\t1948\t61758.14");
		System.out.println("218\t4542\t1288\t555\t17462.094");
		System.out.println("94\t1948\t555\t376.5\t7529.5270");
		
		System.out.println("----------------------------------------");
		
		System.out.println("1\t0\t0\t0\t265023635099387870 / 3308830158406125");
		System.out.println("0\t1\t0\t0\t-1164717768428549 / 13235320633624500");
		System.out.println("0\t0\t1\t0\t4152939800623079 / 13235320633624500");
		System.out.println("0\t0\t0\t1\t-352315631 / 60136220500");
		
		System.out.println("----------------------------------------");
		
		System.out.println("Alfa1 = 265023635099387870 / 3308830158406125");
		System.out.println("Alfa2= -1164717768428549 / 13235320633624500");
		System.out.println("Alfa3 = 4152939800623079 / 13235320633624500");
		System.out.println("Alfa4 = -352315631 / 60136220500");
		System.out.println("----------------------------------------");
		
	}
	
	public static void informeEjercicio6(ArrayList<Double> datosy, ArrayList<Double> datosx, String y, String x) {	
		System.out.print("Valor del parámetro con respecto a :  "+y+" / "+x+":  ");
		System.out.println(Operaciones.getParametroY(datosy, datosx));
		System.out.println();		
	}
	
	public static void informeEjercicio5(ArrayList<Double> datosy, ArrayList<Double> datosx1, ArrayList<Double> datosx2, ArrayList<Double> datosx3) {	
		Operaciones.getSistemaEcuaciones(datosy, datosx1, datosx2, datosx3);
		System.out.println();		
	}

}
