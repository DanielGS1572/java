package Strategy;
//Es mala idea usar interfaces para obligar el uso de un metodo
//La idea es crear clases que implementen la interfaz y asi crear propiedades para desacoplar codigo (a traves de la composición, que en lugar
//de heredar, la clase se compone de objetos con la correcta "habilidad"). De esta forma se puede cambiar el comportamiento en tiempo de ejecución

// Se usa cuando una accion tiene diferentes configuraciones, por ejempo volar, no volar, volar con alas, volar super rapido. Es decir usar 
// una de varios comportamientos de forma dinamica

// si se usan muchos ifs es conveniente usar strategy pattern
public class AnimalPlay {

	public static void main(String[] args) {

		Animal sparky = new Dog();
		Animal tweety = new Bird();

		System.out.println("Dog: " + sparky.tryToFly());

		System.out.println("Bird: " + tweety.tryToFly());

		// This allows dynamic changes for flyingType

		sparky.setFlyingAbility(new ItFlys());

		System.out.println("Dog: " + sparky.tryToFly());

	}

}