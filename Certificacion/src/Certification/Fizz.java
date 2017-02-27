package Certification;

public class Fizz {
	int x = 5;
	public static void main (String[] args){
//		private static final Fizz f1 = new Fizz();
		Fizz f2 = new Fizz();
//		Fizz f3 = FizzSwitch(f1,f2);
//		if(f1 == f3) f1=f2;
	}
	
	static Fizz FizzSwitch(Fizz x, Fizz y){
		final Fizz z = x;
		z.x = 6;
		return z;
	}
}
