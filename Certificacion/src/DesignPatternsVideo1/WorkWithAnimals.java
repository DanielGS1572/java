package DesignPatternsVideo1;

public class WorkWithAnimals {

	public static void main(String[] args) {
		Dog fido = new Dog();
		
		fido.setName("fido");
		System.out.println(fido.getName());
		
		fido.digHole();
		fido.setWeight(-1);
		changeName(fido);
		System.out.println(fido.getName() + " name changed?");
	}
	
	public static void changeName(Dog fido){
		Dog marcus = new Dog();
		marcus.setName("Marcus");
		fido = marcus;				//Aqui no se esta modificando la referencia, solo se cambia si se hace fido.setName
		System.out.println(fido.getName() + " fido2");
		
		Animal doggy = new Dog();
		Animal kitty = new Cat();
		
		System.out.println("Doggy says: " + doggy.getSound());
		System.out.println("Kitty says: " + kitty.getSound());
		
		Animal[] animals = new Animal[4];
		animals[0] = doggy;
		animals[1] = kitty;
		
		System.out.println("Doggy array says: " + animals[0].getSound());
		System.out.println("Kitty array says: " + animals[1].getSound());
		
		
		Giraffe giraffe = new Giraffe();
		giraffe.setName("Mark");
		System.out.println(giraffe.getName());
	}

}
