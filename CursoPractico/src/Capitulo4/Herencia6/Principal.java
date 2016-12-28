package Capitulo4.Herencia6;

public class Principal {

	// Cuando existe Herencia primero se manda llamar el constructor de la
	// superclase.
	// Esto se debe a que cada constructo Java implicitamente manda llamar el
	// constructor de la clase padre
	// con super().
	// En lugar de llamar al constructor por defecto y se quisiera que fuera
	// alguno en particular debe
	// ser super(argumentos)

	// super() debe ser la primer linea de codigo del constructor de una subclase
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Segunda s = new Segunda();
	}

}
