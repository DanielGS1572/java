package Certification;

public class Horse {
	public static void main(String[] args) {
		Horse2 horse = new Horse2();
		horse.tie("test");
	}
}

class Horse2 {

	Halter myHalter = new Halter();

	public void tie(String aRope) {
		myHalter.tie(aRope);
	}

}

class Halter {
	public void tie(String aRope) {
		System.out.println(aRope);
	}
}