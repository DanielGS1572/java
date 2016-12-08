package Capitulo7;

public class PruebaIncremento {

	public static void main(String[] args) {

		
		Incremento valor = new Incremento( 5 );
		System.out.println("antes de incrementar " + valor + "\n" + valor.getInc() + "\n");
		
		for(int i = 1; i <= 3; i++){
			valor.sumarIncrementoATotal();
			System.out.println(" Despues de incrementar " + i + " "+ valor);
		}

	}

}
