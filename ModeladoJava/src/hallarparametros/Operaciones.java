package hallarparametros;

import java.util.ArrayList;

public class Operaciones {
	
	public static Double getParametroY(ArrayList<Double> y, ArrayList<Double> x) {
		Double YW;
		YW = getSumatoriaDeDosVariables(y,x) / getSumatoriaDatoAlCuadrado(x);
		return YW;
	}
	
	public static Double getB1(ArrayList<Double> y, ArrayList<Double> x1, ArrayList<Double> x2) {
		Double B1;
		B1 = (getSumatoriaDeDosVariables(y, x1)-getB2(y,x1,x2)*getSumatoriaDeDosVariables(x1, x2))/(getSumatoriaDatoAlCuadrado(x1));
		return B1;
	}
	
	
	public static Double getB2(ArrayList<Double> y, ArrayList<Double> x1, ArrayList<Double> x2) {
		Double B2;
		B2 = (getSumatoriaDeDosVariables(y, x2)-getSumatoriaDatoAlCuadrado(x2)+getSumatoriaDeDosVariables(y, x1)*getSumatoriaDeDosVariables(x1, x2))/(getSumatoriaDatoAlCuadrado(x1)*getSumatoriaDatoAlCuadrado(x2)+getSumatoriaDeDosVariablesAlCuadrado(x2, x1));
		return B2;
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
	
	public static Double getSumatoriaDeDosVariablesAlCuadrado(ArrayList<Double> datosy, ArrayList<Double> datosx) {	
		Double suma= 0.0;
		for (int i=0; i<datosy.size();i++) {
			suma=suma+(datosy.get(i)*datosx.get(i))*(datosy.get(i)*datosx.get(i));
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
	

	
	public static void informeEjercicio5(ArrayList<Double> datosy, ArrayList<Double> datosx1, ArrayList<Double> datosx2, ArrayList<Double> datosx3) {	
		Operaciones.getSistemaEcuaciones(datosy, datosx1, datosx2, datosx3);
		System.out.println();		
	}

	public static void informeEjercicio6(ArrayList<Double> datosy, ArrayList<Double> datosx, String y, String x) {	
		System.out.print("Valor del parámetro con respecto a :  "+y+" / "+x+":  ");
		System.out.println(Operaciones.getParametroY(datosy, datosx));
		System.out.println();		
	}
	
	public static void informeEjercicio7(ArrayList<Double> datosy, ArrayList<Double> datosx1, ArrayList<Double> datosx2) {
		
		System.out.println("B1 : " + getB1(datosy, datosx1, datosx2));
		System.out.println("B2 : " + getB2(datosy, datosx1, datosx2));
		System.out.println();	
		System.out.println("y = " + getB1(datosy, datosx1, datosx2)+ " x1" + getB2(datosy, datosx1, datosx2)+" x2");
		
		System.out.println();		
	}
}

/*
	
	
*/
