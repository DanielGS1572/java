package Certification;

public class Electronic implements Device {
	private long x[] = new long [10];
	Boolean []ba[];
	public void doIt(int x) {
		System.out.println(x);
	}

	public static void main(String[] args) {
		Phone3 x = new Phone3();
		x.doIt();
	}

}

abstract class Phone1 extends Electronic {

}

abstract class Phone2 extends Electronic {
	public abstract void doIt(int x);
}

class Phone3 extends Electronic implements Device {
	public void doStuff() {

	}

	public void doIt() {
		super.doIt(3);
		System.out.println("b");
//		System.out.println(x);
//		return ;
	}
}

interface Device {
	public void doIt(int x);
}

