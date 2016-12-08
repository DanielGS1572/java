package Capitulo7;

public class InicArreglo {
	public static void main(String args[]){
		int[][] arreglo1 = {{1,2,3},{4,5,6}};
		int arreglo2[][] = {{1,2},{3},{4,5}};
		
		System.out.println("Los valores del primer arreglo son:");
		imprimeArreglo(arreglo1);
		System.out.println("\nLos valores del segundo arreglo son: ");
		imprimeArreglo(arreglo2);
	}
	
	private static void imprimeArreglo(int[][] arreglo){
		for(int fila = 0; fila < arreglo.length; fila++){
			for(int columna = 0; columna < arreglo[fila].length; columna++ ){
				System.out.printf("%d", arreglo[fila][columna]);
			}
			System.out.println();
		}
	}
}
