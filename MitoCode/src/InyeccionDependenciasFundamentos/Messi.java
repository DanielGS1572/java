package InyeccionDependenciasFundamentos;

public class Messi {
	private IEquipo equipo; 		//si se tienen mas dependencias se tendrian que estar implementando cada una
//	de esta forma Spring nos ayuda a llevar esto a cabo

	public Messi(IEquipo equipo) {
		this.equipo = equipo;
	}
	
	public void mostrarEquipo(){
		equipo.mostrar(); 				// ver que se ocupa el metodo de la interfaz implementado
	}
}
