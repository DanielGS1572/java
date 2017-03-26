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
	}

}
