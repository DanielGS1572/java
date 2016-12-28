package Capitulo4.Protected67b;

import Capitulo4.Protected67a.Persona;
//El metodos protected heredas todos los metodos y atributos de la superclase a pesar 
//que esten en otro paquete.

//Si se instancia el objeto sólo se podrá ver el metodo dentro del mismo paquete
public class Empleado extends Persona {
private int edad;
private long nseg;
	public Empleado(String f, long nseg) {
		super(f);
		this.nseg = nseg;
		// TODO Auto-generated constructor stub
	}
	public void muestraDatos(){
		System.out.println(this.getEdad());	
	}
}
