package Certification;

public class Oscar {
	public static void main(String[] args) {
		Tx oscar = new Tx();
		System.out.println(oscar.cat());
	}
}

class Tx extends Felix {
	Tx() {
		System.out.println("Tx Called");
	}

	public long cat() {
		return 4;
	}

	public int t() {
		return 2;
	}

	public String b() {
		return "hola";
	}
}

class Felix {
	Felix() {
		System.out.println("Felix Called");
	}

	protected long cat() {
		return 7;
	}

	public int t(int x) {
		return 1;
	}

	public void a() {

	}
}
