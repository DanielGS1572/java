package Capitulo4.Sobreescritura69;

public class Segunda extends Primera{
	// Al hacer una sobreescritura el metodo del padre se omite por completo
	public void imprimir(String mensaje){
		System.out.println("el mensaje es");
		System.out.println(mensaje);
	}
	public void imprimir(String mensaje){
		System.out.println("el mensaje es");
		System.out.println(mensaje);
	}
}
