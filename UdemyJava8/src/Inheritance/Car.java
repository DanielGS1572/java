package Inheritance;

public class Car extends Vehicle{
	private int numberWheels;
	private int numberDoors;
	private boolean changeGears;
	
	public Car(int numberWheels,int numberDoors,boolean changeGears, int speeding ){
		super(speeding);
		this.numberWheels = numberWheels;
		this.numberDoors = numberDoors;
		this.changeGears = changeGears;
		
	}
	public int getNumberWheels() {
		return numberWheels;
	}
	public void setNumberWheels(int numberWheels) {
		this.numberWheels = numberWheels;
	}
	public int getNumberDoors() {
		return numberDoors;
	}
	public void setNumberDoors(int numberDoors) {
		this.numberDoors = numberDoors;
	}
	public boolean isChangeGears() {
		return changeGears;
	}
	public void setChangeGears(boolean changeGears) {
		this.changeGears = changeGears;
	}
	
	public void HandSteering() {
		System.out.println("Hand Steering by car");
		super.HandSteering();
		
	}
}
