package Capitulo3.Colecciones8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
//Revisar porque no compara
public class ArrayListGestion {
	public static void main(String[] args) throws IOException {
		ArrayList temperaturas = new ArrayList();
		String opcion;
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		do {
			System.out.println("Elegir opción:\n");
			System.out.println("1.- Añadir temperatura");
			System.out.println("2.- Mostrar temperatura media");
			System.out.println("3.- Mostrar temperaturas extremas");
			System.out.println("4.- Salir");
			opcion = bf.readLine();

			switch (Integer.parseInt(opcion)) {
			case 1:
				double temp;
				System.out.println("Introduce la temperatura");
				temp = Double.parseDouble(bf.readLine());
				almacenaTemperatura(temp, temperaturas);
				break;
			case 2:
				muestraMedia(temperaturas);
				break;
			case 3:
				muestraMaxima(temperaturas);
				break;

			}
		} while (!opcion.equals("4"));

	}

	static void almacenaTemperatura(double d, ArrayList temperatura) {
		temperatura.add(d);
	}

	static void muestraMedia(ArrayList temperatura) {
		double media = 0.0;
		for (Object barre : temperatura) {
			media += (Double) barre;
		}
		media /= temperatura.size();
		System.out.println("La media es; " + media);
	}

	static void muestraMaxima(ArrayList temperaturas) {
		double maxima = 0.0;
		 
		double min = 0.0;
		for (Object temp : temperaturas) {
			double aux = ((Double) temp).doubleValue();
			System.out.println(aux + " aux " + maxima + " max ");
			System.out.println(aux < maxima);
			if (aux < maxima) { // Ver como se hace el
															// casteo de un
															// Object a Double
															// para despues
															// convertirlo a
															// tipo primitivo
				
				maxima = aux;
				System.out.println("maxima " + maxima);
			} 
			if(aux > min){
				min = aux;
			}
		}
		System.out.println("la máxima es: " + maxima + "\nLa mínima es: " + min);
	}
}
