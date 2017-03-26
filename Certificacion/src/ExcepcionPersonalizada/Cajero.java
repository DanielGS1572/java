package ExcepcionPersonalizada;

public class Cajero {
	public static void main(String[] args) {
		Cuenta c = new Cuenta();

		c.ingresar(10);
		try {
			c.extraer(20);
		} catch (SaldoInsuficienteException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}

	}
}
