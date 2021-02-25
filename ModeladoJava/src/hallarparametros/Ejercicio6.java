package hallarparametros;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Ejercicio6 {
	static ArrayList<Double> promedioNotas = new ArrayList<>();
	static ArrayList<Double> edad = new ArrayList<>();
	static ArrayList<Double> numeroMaterias = new ArrayList<>();
	static ArrayList<Double> horasEstudio = new ArrayList<>();
	static ArrayList<Double> recreo = new ArrayList<>();
	static ArrayList<Double> numeroAmigos = new ArrayList<>();
	
	public static void main(String[] args) throws Exception {
		readDataFromCsv();
		Operaciones.informe(promedioNotas, edad, "Promedio Notas", "Edad");		
		Operaciones.informe(promedioNotas, edad, "Promedio Notas", "Edad");		
		Operaciones.informe(promedioNotas, numeroMaterias, "Promedio Notas", "Numero Materias");
		Operaciones.informe(promedioNotas, horasEstudio, "Promedio Notas", "Horas de Estudio");
		Operaciones.informe(promedioNotas, recreo, "Promedio Notas", "Recreo");
		Operaciones.informe(promedioNotas, numeroAmigos, "Promedio Notas", "Nu]mero Amigos");
	
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
	
}
