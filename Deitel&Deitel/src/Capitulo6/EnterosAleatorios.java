package Capitulo6;

import java.util.Random;

public class EnterosAleatorios {

	public static void main(String[] args) {
		Random numeroAleatorio = new Random();
		int frecuencia[] = new int[7];
		
		for(int tiro= 1; tiro<= 6000; tiro++){
			++frecuencia[1+numeroAleatorio.nextInt(6)];
		}
		System.out.println("Cara\tOcurrecnias");
		for(int cara=1; cara<frecuencia.length; cara++){
			System.out.printf("%4d%8d\n",cara,frecuencia[cara]);
		}
	}

}
