package Capitulo3.Colecciones8;

public class TipoGenericoUso {
	public static void main (String args[]){
		TipoGenerico<String> tipo = new TipoGenerico<String>();
		
		tipo.setData("String introducido");
		System.out.println(tipo.getData());
	}
}
