package Certification;

import java.io.FileNotFoundException;

class Master {
	String doFileStuff() throws FileNotFoundException {
		return "a";
	}
}

public class Slave extends Master {

	public static void main(String[] args) {
		String s = null;
		try {
			s = new Slave().doFileStuff();
		} catch (FileNotFoundException x) {
			System.out.println("1");
			s = "b";
		}
		System.out.println(s);
	}
	String doFileStuff() throws FileNotFoundException {
		throw new FileNotFoundException();
//		return "c";
		}
}
