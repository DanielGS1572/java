package DesignPatternsVideo1;

public class Giraffe extends Creature implements Living{
	private String name;
	@Override
	public void setName(String newName) {
		// TODO Auto-generated method stub
		name = newName;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}

	@Override
	public void setWeight(double newWeight) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public double getWeight() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setHeight(double newHeight) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public double getHeight() {
		// TODO Auto-generated method stub
		return 0;
	}

}
