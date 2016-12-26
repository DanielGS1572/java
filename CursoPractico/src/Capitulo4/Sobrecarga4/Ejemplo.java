package Capitulo4.Sobrecarga4;

//La sobrecarga de metodos es que un metodo acepte por parametro algo diferente o que incluso 
//regrese un tipo de dato. Lo que define la sobrecarga es la cantidad de parámetros que recibe
public class Ejemplo {
	public void muestra() {
		System.out.println("Texto predeterminado");
	}

	public String muestra(String s) {
		return "texto más algo " + s;
	}
}
