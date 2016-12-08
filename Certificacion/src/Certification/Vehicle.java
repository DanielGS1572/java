package Certification;

public abstract class Vehicle {
	private String type;

	public abstract void goUpHill(); // Abstract method

	public String getType() { // Non-abstract method
		return type;
	}
}
