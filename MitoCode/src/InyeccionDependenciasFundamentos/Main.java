package InyeccionDependenciasFundamentos;

public class Main {

	public static void main(String[] args) {
		Messi m = new Messi(new Barcelona());
		m.mostrarEquipo();
		
		Messi m2 = new Messi(new Juventus());			//Recibe como parametro una clase que implementa la interfaz
		m2.mostrarEquipo();

	}

}
