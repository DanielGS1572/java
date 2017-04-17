package Inheritance;

public class Vehicle {

	private int speeding;

	public void HandSteering() {
		System.out.println("Hand Steering by vehicle");
	}
	public Vehicle(int speeding){
		this.speeding = speeding;
	}
	public void Speeding() {
		System.out.println("you are going to: " + getSpeeding());
	}

	public int getSpeeding() {
		return speeding;
	}

	public void setSpeeding(int speeding) {
		this.speeding = speeding;
	}

}
