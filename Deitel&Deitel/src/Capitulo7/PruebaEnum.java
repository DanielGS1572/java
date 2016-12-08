package Capitulo7;

import java.util.EnumSet;

public class PruebaEnum {

	public static void main(String[] args) {
//		Libro enumLibro = new Libro();
		// TODO Auto-generated method stub
		for(Libro libro:Libro.values()){
			System.out.printf("%-10s%-45s%s\n",libro,libro.getTitulo(),libro.getAnio());
		}
		System.out.println();
		for(Libro libro:EnumSet.range(Libro.JHTP6, Libro.CPPHTP4)){
			System.out.println(libro);
		}
	}

}
  