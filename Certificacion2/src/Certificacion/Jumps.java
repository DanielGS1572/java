package Certificacion;

public class Jumps {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Wooper w = new Wooper();
		System.out.println(w.jump(7) + " ss");
		w.printJumps(5);
	}

}

class Wooper{
	public int jump(int i){
		System.out.println(i + " xx");
		System.out.println(printJumps(i++) + " a") ; return i;
	}
	public int printJumps(int i){
		System.out.println(i + " yy");
		System.out.println("Jump: " + i++ + " b"); return i;
	}
}

