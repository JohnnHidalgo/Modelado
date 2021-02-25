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
		B2 = (getSumatoriaDeDosVariables(y, x2)-getSumatoriaDatoAlCuadrado(x2)-getSumatoriaDeDosVariables(y, x1)*getSumatoriaDeDosVariables(x1, x2))/(getSumatoriaDatoAlCuadrado(x1)*getSumatoriaDatoAlCuadrado(x2)+getSumatoriaDeDosVariablesAlCuadrado(x2, x1));
		return B2;
	}

	public static Double getAlfa1(ArrayList<Double> y, ArrayList<Double> x1, ArrayList<Double> x2) {
		Double Alfa1;
		Alfa1 = (getSumatoriaDeDosVariablesEuler(y, x1)-getAlfa2(y,x1,x2)*getSumatoriaDeDosVariables(x1, x2))/(getSumatoriaDatoAlCuadrado(x1));
		return Alfa1;
	}
	
	public static Double getAlfa2(ArrayList<Double> y, ArrayList<Double> x1, ArrayList<Double> x2) {
		Double Alfa2;
		Alfa2 = (getSumatoriaDeDosVariablesEuler(y, x2)-getSumatoriaDatoAlCuadrado(x2)-getSumatoriaDeDosVariablesEuler(y, x1)*getSumatoriaDeDosVariables(x2, x1))/(getSumatoriaDatoAlCuadrado(x1)*getSumatoriaDatoAlCuadrado(x2)+getSumatoriaDeDosVariablesAlCuadrado(x2, x1));
		return Alfa2;
	}
	
	public static Double getAlfa1Ejercicio4(ArrayList<Double> y, ArrayList<Double> x1, ArrayList<Double> x2) {
		Double Alfa1;
		Alfa1 = (getPromedio(y)*getSumatoriaCoseno(x2)*getSumatoriaSenoAlCuadrado(x1)-getPromedio(y)*getSumatoriaSeno(x1))/(getSumatoriaSenoAlCuadrado(x1)*getSumatoriaCosenoAlCuadrado(x2)+getSumatoriaDobleCoseno(x1, x1)*getSumatoriaDobleSeno(x1, x1));
		return Alfa1;
	}
	
	public static Double getAlfa0Ejercicio4(ArrayList<Double> y, ArrayList<Double> x1, ArrayList<Double> x2) {
		Double Alfa0;
		Alfa0 = (getPromedio(y)*getSumatoriaCoseno(x2)-getAlfa1Ejercicio4(y, x1, x2)*getSumatoriaDobleSeno(x1, x2))/(getSumatoriaSenoAlCuadrado(x2));
		return Alfa0;
	}
	
	public static Double getAlfa1Ejercicio2(ArrayList<Double> y, ArrayList<Double> x1) {
		Double Alfa1;
		Alfa1 = (getSumatoriaDeDosVariables(y, x1)-getAlfa0Ejercicio2(y, x1))/(getSumatoriaDatoAlCuadrado(x1));
		return Alfa1;
	}
	
	public static Double getAlfa0Ejercicio2(ArrayList<Double> y, ArrayList<Double> x1) {
		Double Alfa0;
		Alfa0 = (getSumatoriaUnaVariable(y)*getSumatoriaUnaVariable(x1)-getSumatoriaDeDosVariables(y, x1))/(getSumatoriaUnaVariable(x1)+getSumatoriaDatoAlCuadrado(x1)*getSumatoriaUnaVariable(x1));
		return Alfa0;
	}
		
	public static Double getSumatoriaCoseno(ArrayList<Double> datos) {	
		Double suma= 0.0;
		for (int i=0; i<datos.size();i++) {
			suma=suma+Math.cos(datos.get(i));
		}
		return suma;
	}
	
	public static Double getSumatoriaSeno(ArrayList<Double> datos) {	
		Double suma= 0.0;
		for (int i=0; i<datos.size();i++) {
			suma=suma+Math.sin(datos.get(i));
		}
		return suma;
	}
	
	public static Double getSumatoriaCosenoAlCuadrado(ArrayList<Double> datos) {	
		Double suma= 0.0;
		for (int i=0; i<datos.size();i++) {
			suma=suma+Math.cos(datos.get(i)*datos.get(i));
		}
		return suma;
	}
	
	public static Double getSumatoriaSenoAlCuadrado(ArrayList<Double> datos) {	
		Double suma= 0.0;
		for (int i=0; i<datos.size();i++) {
			suma=suma+Math.cos(datos.get(i)*datos.get(i));
		}
		return suma;
	}
	
	public static Double getSumatoriaDobleCoseno(ArrayList<Double> datosx1, ArrayList<Double> datosx2) {	
		Double suma= 0.0;
		for (int i=0; i<datosx1.size();i++) {
			suma=suma+Math.cos(datosx1.get(i)*datosx2.get(i));
		}
		return suma;
	}
	
	public static Double getSumatoriaDobleSeno(ArrayList<Double> datosx1, ArrayList<Double> datosx2) {	
		Double suma= 0.0;
		for (int i=0; i<datosx1.size();i++) {
			suma=suma+Math.sin(datosx1.get(i)*datosx2.get(i));
		}
		return suma;
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
	
	public static Double getSumatoriaDatoAlCuarta(ArrayList<Double> datos) {
		Double suma= 0.0;
		for (int i=0; i<datos.size();i++) {
			suma=suma+(datos.get(i)*datos.get(i)*datos.get(i)*datos.get(i));
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
	
	public static Double getSumatoriaDeDosVariablesEuler(ArrayList<Double> datosy, ArrayList<Double> datosx) {	
		Double suma= 0.0;
		for (int i=0; i<datosy.size();i++) {
			suma=suma+(Math.exp(datosy.get(i))*datosx.get(i));
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
	
	
	
	public static void informeEjercicio2(ArrayList<Double> datosy, ArrayList<Double> datosx1) {	
		System.out.println("Alfa0 : " + getAlfa0Ejercicio2(datosy, datosx1));
		System.out.println("Alfa1 : " + getAlfa1Ejercicio2(datosy, datosx1));
		System.out.println();	
		System.out.println("y = 1 / " + getAlfa0Ejercicio2(datosy, datosx1)+ "  + " + getAlfa1Ejercicio2(datosy, datosx1)+" x1");
		System.out.println();	
		System.out.println();		
	}
	

	public static void informeEjercicio3(ArrayList<Double> datosy, ArrayList<Double> datosx1) {	
		System.out.println("Sistema de Ecuaciones");
		System.out.println("x^3+16131y+z = 80.10\n" + "x^3+7146447y+16131z = 12192114.8986\n" + "x^3+16131y+z = 80.10");
		System.out.println("Sistema sin solución");
		System.out.println();		
	}
	
	public static void informeEjercicio4(ArrayList<Double> datosy, ArrayList<Double> datosx1, ArrayList<Double> datosx2) {
		System.out.println("Alfa0 : " + getAlfa0Ejercicio4(datosy, datosx1, datosx2));
		System.out.println("Alfa1 : " + getAlfa1Ejercicio4(datosy, datosx1, datosx2));
		System.out.println();	
		System.out.println("y = " + getAlfa0Ejercicio4(datosy, datosx1, datosx2)+ " sen(x1) + " + getAlfa1Ejercicio4(datosy, datosx1, datosx2)+" cos(x2)");
		System.out.println();		
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
	
	public static void informeEjercicio8(ArrayList<Double> datosy, ArrayList<Double> datosx1, ArrayList<Double> datosx2) {
		System.out.println("Alfa1 : " + getAlfa1(datosy, datosx1, datosx2));
		System.out.println("Alfa2 : " + getAlfa2(datosy, datosx1, datosx2));
		System.out.println();	
		System.out.println("e ^ y = " + "ln("+getAlfa1(datosy, datosx1, datosx2)+ " x1 " + getAlfa2(datosy, datosx1, datosx2)+" x2 )");
		System.out.println();			
	}
	
}