package Certification;

abstract class Ball implements Bounceable {
	public void bounce() {
	} // Implement Bounceable's methods

	public void setBounceFactor(int bf) {
	}

	public void moveIt() {
	} // Implement Moveable's method

}

interface Bounceable extends Moveable, Spherical {
	void bounce();

	void setBounceFactor(int bf);
}

interface Moveable {
	void moveIt();
}

interface Spherical {
	void doSphericalThing();
}

abstract class test {
	public void x() {

	}
}

class Foo {
	void go(int x) {
	}
}

class Bar extends Foo {
	String go(String z) { // Not legal! Can't change only the return type return
							// null;
		return "a";
	}
}

class Alpha {
	Alpha doStuff(char c) {
		return new Alpha();
	}
}

class Beta extends Alpha {
	Alpha doStuff(char c) {
		return new Alpha();
	}

}

	
