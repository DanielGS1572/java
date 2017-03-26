package Certification;

public class SuperJuice {
	public static void main(String[] s) {
		System.out.println(regresaValor(3) + "");
		byte a = 3;
		byte b = 12;
		byte c = (byte)( a + b);
	}

	static int regresaValor(int seed) {
		return (int) (Math.random() * seed);
	}
}
