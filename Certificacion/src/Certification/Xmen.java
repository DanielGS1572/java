package Certification;

public class Xmen extends Heroes {

	public static void main(String[] args) {
		new Xmen();
		System.out.println(s);
	}

	Xmen() {
		super(2);
		s += "x ";

	}
}

class Heroes {
	static String s = "-";

	Heroes() {
		// this(1);
		s += "h1 ";
	}

	Heroes(int x) {
		s += "h2 ";
	}
}
