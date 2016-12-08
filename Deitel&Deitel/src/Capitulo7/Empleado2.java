package Capitulo7;

public class Empleado2 {
	private String apellidoPaterno;
	private String apellidoMaterno;
	private static int cuenta = 0;
	
	public Empleado2(String apellidoPaterno, String apellidoMaterno){
		this.apellidoMaterno = apellidoMaterno;
		this.apellidoPaterno = apellidoPaterno;
		
		cuenta++;
		System.out.printf("Sin descontar:\nApellidoPaterno%s\tApellidoMaterno%s\tCuenta%d",
			apellidoPaterno,apellidoMaterno,cuenta);
	}
	
	protected void finalize(){
		cuenta--;
		System.out.printf("Descontando:\nApellidoPaterno%s\tApellidoMaterno%s\tCuenta",
				apellidoPaterno,apellidoMaterno,cuenta);
	}
	
	public static int obtenerCuenta(){
		return cuenta;
	}
}
