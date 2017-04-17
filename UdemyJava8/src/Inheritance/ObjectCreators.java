package Inheritance;

public class ObjectCreators {

	public static void main(String[] args) {
		Car astra = new Car(4,4,true,4);
		System.out.println(astra.getSpeeding());
		astra.setSpeeding(40);
		astra.HandSteering();
	}

}
