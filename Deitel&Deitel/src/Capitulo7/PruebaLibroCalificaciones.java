package Capitulo7;

public class PruebaLibroCalificaciones {
	public static void main(String[]args){
		int arregloCalif[] = {87,68,94,100,83,78,85,91,76,87};
		
		LibroCalificaciones miLibroCalificaciones = new LibroCalificaciones("CS101",arregloCalif);
		miLibroCalificaciones.mostrarMensaje();
		miLibroCalificaciones.procesarCalificaciones();
	}
}
