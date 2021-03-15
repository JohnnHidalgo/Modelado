package metodomatricial;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;


public class Ejercicio1 {
	static ArrayList<Double> promedioNotas = new ArrayList<>();
	static ArrayList<Double> edad = new ArrayList<>();
	static ArrayList<Double> numeroMaterias = new ArrayList<>();
	static ArrayList<Double> horasEstudio = new ArrayList<>();
	static ArrayList<Double> recreo = new ArrayList<>();
	static ArrayList<Double> numeroAmigos = new ArrayList<>();
	
	public static void main(String[] args) throws Exception {
		readDataFromCsv();
		informeEjercicio1(promedioNotas, edad, numeroMaterias);		
	}
	
	public static void readDataFromCsv() throws Exception {
		String[] row = new String[6];
		Scanner sc = new Scanner(new File("regresionlineal/datos.csv"));  
		while (sc.hasNext()){
			row = sc.next().split(",", 6);
			promedioNotas.add(Double.parseDouble(row[0]));
			edad.add(Double.parseDouble(row[1]));
			numeroMaterias.add(Double.parseDouble(row[2]));
			horasEstudio.add(Double.parseDouble(row[3]));
			recreo.add(Double.parseDouble(row[4]));
			numeroAmigos.add(Double.parseDouble(row[5]));
		}
		sc.close();
	}
	
	public static void informeEjercicio1(ArrayList<Double> datosy, ArrayList<Double> datosx1, ArrayList<Double> datosx2) {	

		System.out.println("Matriz X :  ");
		System.out.println(Operaciones.makeMatrizEjercicio1(datosx1, datosx2));
		System.out.println("Matriz Xtranspuesta :  ");
		System.out.println(Operaciones.makeMatrizTranspuesta3x3(datosx1, datosx2));
		
		System.out.print("Coeficiente de Correlacion Lineal :  ");
		System.out.println(Operaciones.getCorrelacion(datosy, datosx1));
		System.out.print("Coeficiente de R cuadrado :  ");
		System.out.println(Operaciones.getCorrelacion(datosy, datosx1)*Operaciones.getCorrelacion(datosy, datosx1));
		System.out.println();
		System.out.println();
	}
}
