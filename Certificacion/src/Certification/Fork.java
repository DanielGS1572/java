package Certification;

public class Fork extends Cutlery {

	public static void main(String[] args) {
		Cutlery c1 = new Fork();
		Fork f1 = new Fork();
		Cutlery c2 = c1;
		Cutlery c3 = f1;
		Fork f2 = (Fork) c1;
		Fork f3 = f1;
		String x = new String("test");
		System.out.println(x);
		System.out.println(x.toString());
	}

}

class Cutlery {

}