package metodomatricial;

import java.util.ArrayList;

public class Operaciones {

	public static Double sumatorioaLn(ArrayList<Double> datos) {	
		Double suma= 0.0;
		for (int i=0; i<datos.size();i++) {
			suma=suma+(Math.log(datos.get(i)));
		}
		return suma;
	}
	public static Double sumatorioaLnCuadrado(ArrayList<Double> datos) {	
		Double suma= 0.0;
		for (int i=0; i<datos.size();i++) {
			suma=suma+(Math.log(datos.get(i))*Math.log(datos.get(i)));
		}
		return suma;
	}	
	public static Double sumatorioaLnDosVariable(ArrayList<Double> datosx, ArrayList<Double> datosy) {	
		Double suma= 0.0;
		for (int i=0; i<datosx.size();i++) {
			suma=suma+(Math.log(datosx.get(i))*Math.log(datosy.get(i)));
		}
		return suma;
	}	
	
	public static Double[][] makeMatrizEjercicio1(ArrayList<Double> datosx1, ArrayList<Double> datosx2) {
		Double[][] matriz = new Double[3][3]; 
		matriz[0][0]=1.0;
		matriz[0][1]=sumatorioaLn(datosx1);
		matriz[0][2]=sumatorioaLn(datosx2);
		System.out.println(matriz[0][0]+"\t"+matriz[0][1]+"\t"+matriz[0][2]);
		matriz[1][0]=sumatorioaLn(datosx1);
		matriz[1][1]=sumatorioaLnCuadrado(datosx1);
		matriz[1][2]=sumatorioaLn(datosx2);

		System.out.println(matriz[1][0]+"\t"+matriz[1][1]+"\t"+matriz[1][2]);
		matriz[2][0]=sumatorioaLnDosVariable(datosx1, datosx2);
		matriz[2][1]=sumatorioaLnDosVariable(datosx1, datosx2);
		matriz[2][2]=sumatorioaLnCuadrado(datosx2);

		System.out.println(matriz[2][0]+"\t"+matriz[2][1]+"\t"+matriz[2][2]);
		return matriz;
	}
	
	public static Double[][] makeMatrizTranspuesta3x3(ArrayList<Double> datosx1, ArrayList<Double> datosx2) {
		Double[][] matrizTranspuesta = new Double[3][3]; 
		Double[][] matriz = makeMatrizEjercicio1(datosx1, datosx2); 
		System.out.println();
		System.out.println();
		System.out.println();
		for(int j=0;j<3;j++) {
			for(int i=0;i<3;i++) {
				matrizTranspuesta[i][j]= matriz[j][i];
				System.out.print(matrizTranspuesta[i][j]+"\t");
			}
			System.out.println();
		}		
		return matrizTranspuesta;
	}
	
	public static Double amakeMatrizTranspuesta3x3(ArrayList<Double> datosx1, ArrayList<Double> datosx2) {
		Double[][] matrizTranspuesta = new Double[3][3]; 
		Double[][] matriz = makeMatrizEjercicio1(datosx1, datosx2); 
		for(int j=0;j<3;j++) {
			for(int i=0;i<3;i++) {
				matrizTranspuesta[i][j]= matriz[j][i];
			}
		}		
		return matrizTranspuesta[0][1];
	}
	
	
	public static Double[][] getMatriz3x3(ArrayList<Double> datos) {
		Double suma[][] = null;
		
		for (int i=0; i<3;i++) {
			
			
		}
		
		return suma;
	}
	
	public static Double[][] getTranspuesta(ArrayList<Double> datos) {
		Double suma[][] = null;
		for (int i=0; i<datos.size();i++) {
			//suma=suma+datos.get(i);
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
	
}
