package Certificacion;

public class RTExcept {
	public static void throwit() {
		System.out.println("thowit ");
		throw new RuntimeException();
	}

	public static void main(String[] args) {
//		try {
			System.out.println("hello ");
			throwit();
			RTExcept3 x = new RTExcept3();
//			x.xx();
//		} catch (Exception re) {
//			System.out.println("caught ");
//
//		} finally {
//			System.out.println("finally");
//		}
//		System.out.println("after");
	}

}
class RTExcept2 extends Exception{
	public RTExcept2 (String s){
		super(s);
	}
}

class RTExcept3{
	public void xx()  throws RTExcept2{
		
	}
}