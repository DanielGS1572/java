package Certification;
//

//public class Animal {
//    public void eat() {
//       System.out.println("Generic Animal Eating Generically");
//    }
// }
// class Horse extends Animal {
//    public void eat() {
//        System.out.println("Horse eating hay ");
//    }
//    public void eat(String s) {
//       System.out.println("Horse eating " + s);
//    }
//}

public class Animal {
	static void doStuff() {
		System.out.print("a ");
	}

	public static void main(String[] args) {
		Animal[] a = { new Animal(), new Dog(), new Animal() };
		for (int x = 0; x < a.length; x++)
			a[x].doStuff(); // invoke the static method
	}
}

class Dog extends Animal {
	static void doStuff() {
		System.out.print("d ");
	}

	// it's a redefinition,
	// not an override
	
}