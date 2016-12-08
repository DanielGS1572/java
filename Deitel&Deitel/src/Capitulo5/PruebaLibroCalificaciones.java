package Capitulo5;

public class PruebaLibroCalificaciones {
	public static void main (String [] args){
		LibroCalificaciones miLibroCalificaciones = new LibroCalificaciones("Java");
		
		miLibroCalificaciones.mostrarMensaje();
		miLibroCalificaciones.introducirCalif();
		miLibroCalificaciones.mostrarReporteCalif();
	}
}
