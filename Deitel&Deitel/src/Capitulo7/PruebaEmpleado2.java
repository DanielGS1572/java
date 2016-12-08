package Capitulo7;
import static java.lang.Math.*;
public class PruebaEmpleado2 {
	public static void main(String args[]) {
		System.out.println("Empleados antes de instanciar " + Empleado2.obtenerCuenta());
		Empleado2 e1 = new Empleado2("Susan", "Baker");
		Empleado2 e2 = new Empleado2("Bob", "Blue");

		System.out.println("\nEmpleados despues de instanciar: ");
		System.out.printf("mediante e1.obtenerCuenta(): %d\n", e1.obtenerCuenta());
		System.out.printf("mediante e2.obtenerCuenta(): %d\n", e2.obtenerCuenta());
		System.out.printf("mediante Empleado.obtenerCuenta(): %d\n", 
				Empleado2.obtenerCuenta());
		
		System.gc();
		e1 = null;
		
		System.out.printf( "\nEmpleados despues de System.gc(): %d\n",
		Empleado2.obtenerCuenta() );
		ceil(9.7);
	}
}
