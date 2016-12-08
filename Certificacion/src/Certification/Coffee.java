package Certification;

//class Coffee {

//	enum CoffeeSize {
//		BIG, HUGE, OVERWHELMING
//	}
//
//	CoffeeSize size;
//}
//
//public class EnmuTest {
//
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		Coffee drink = new Coffee();
//		drink.size = Coffee.CoffeeSize.BIG;
//		System.out.println(drink.size);
//
//	}
//
//}

//###########################################################################################################################################################

// Definición de primer enum
//enum CoffeSize {
//	// la forma en la que se llama el enum no es la normal como una clase
//	// [CoffeSize (valor)]
//	BIG(8), HUGE(12), OVERWHELMING(16);
//	// ver como el constructor del enum no tiene modificador de acceso
//	// y es para uso interno de la propia clase
//	CoffeSize(int large) {
//		this.large = large;
//	}
//
//	private int large;
//
//	public int getOunces() {
//		return large;
//	}
//}

// Definición de segundo enum
enum CoffeSize {
	BIG(8), 
	HUGE(10){
		public String getLidCode(){
			return "X";
		}
	}, OVERWHELMING(16) {
// Se hace override del metodo que se ha definido en la clase despuecito de la clase enum
		public String getLidCode() {
			return "A";
		}
	}; //ver que debe llevar punto y coma por el override, si es el ultimo enum. solo por coma cuando no es el ultimo
// a lo anterior se le llama constan specific class body
	CoffeSize(int ounces) {
		this.ounces = ounces;
	}

	private int ounces;

	public int getOunces() {
		return ounces;
	}

	public String getLidCode() {
		return "B";
	}
}

class Coffee {
	CoffeSize size;

	public static void main(String[] args) {
		// ver como se puede crear un objeto de un metodo que esta dentro de la
		// misma clase objeto
		Coffee drink1 = new Coffee();
		drink1.size = CoffeSize.BIG;

		Coffee drink2 = new Coffee();
		drink2.size = CoffeSize.OVERWHELMING;

		System.out.println(drink2.size.getOunces());
		for (CoffeSize cs : CoffeSize.values()) {
			System.out.println(cs + "  " + cs.getLidCode());
		}
	}

}