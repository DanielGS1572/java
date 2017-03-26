package Certification;

class Dogx {
}

class Beagle extends Dogx {
}

public class Kennel {

	public static void main(String[] args) {
		Beagle b1 = new Beagle();

		Dogx dog1 = new Dogx();
		Dogx dog2 = b1;

//		Beagle b2 = (Beagle) dog1; // Al hacer este casteo manda error @runtime,
									// pues es
									// la clase padre INTENTANDO CASTEAR A UNA HIJA
		Beagle b3 = (Beagle) dog2;

//		Beagle b4 = dog2; // Como la referencia es de tipo Dog es el mismo
		// caso que no se puede asignar un tipo Dog a un tipo Beagle (no se esta
		// casteando) AL CASTEARLO YA NO MANDA ERROR
	}

}
