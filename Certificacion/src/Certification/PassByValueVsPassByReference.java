package Certification;

public class PassByValueVsPassByReference {
	
	
	public static void main(String[] args) {
		DogTest aDog = new DogTest("Max");
		testingPassedBy(aDog);
		System.out.println(aDog.getName() + " Nombre");
		
	}
	public static void testingPassedBy(DogTest dTest){
//		dTest = new DogTest("Foo");
//		System.out.println(dTest.getName() + " Nombre2" );
		dTest.setName("LOL");
		System.out.println(dTest.getName() + " Nombre3" );
	}
}


class DogTest{
	public String name;

	public DogTest(String name){
		this.setName(name);
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}