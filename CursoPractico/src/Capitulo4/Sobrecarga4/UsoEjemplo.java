package Capitulo4.Sobrecarga4;

public class UsoEjemplo {

	public static void main(String[] args) {
		Ejemplo e = new Ejemplo();
		e.muestra();						//aquí no uso System.out
		System.out.println(e.muestra("texto")); //aqui si uso System.out pues regresa un String
	}

}
