package DesignPatternsVideo1;

public class Dog extends Animal {
	public void digHole() {
		System.out.println("Dug hole");
	}

	public Dog() {
		super();
		setSound("Bark");
	}
}
