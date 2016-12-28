package Capitulo4.Herencia6;

public class Segunda extends Primera {
	public Segunda(){
		super("texto");		//si se deja super() como no existe constructor por defecto mandará error
		System.out.println("Constructor de la segunda");
	}
}
