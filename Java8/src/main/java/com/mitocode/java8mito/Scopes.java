package com.mitocode.java8mito;

public class Scopes {

	private static double atributo1;
	private double atributo2;

	public double probarLocalVariable() {
		final double n3 = 3;
		Operacion op = new Operacion() {

			@Override
			public double promedio(double n1, double n2) {
				// n3 = n1+ n2; //no se puede usar n3 en una funcion anonima,
				// éste debe ser final
				return n3 + n2 + n1; // como es final unicamente se puede usar,
										// mas no modificar
			}

		};

		Operacion operacion = (x, y) -> {
			// n3 = x + y; //el mismo caso para cuando la clase anonima no es un
			// lambda
			return n3 + x + y;
		};
		return operacion.promedio(1, 1);
	}

	public double probarAtributosStaticVariables(){
		 Operacion operacion = (x,y)-> {
			 atributo1 =  x + y;			//no hay problema con las variables globales (ya sean estaticas o no)
			 atributo2 =  x + y;
			 return atributo2;
		 };
		 return operacion.promedio(3, 2);
	 }

	public static void main(String[] args) {
		Scopes app = new Scopes();
		System.out.println(app.probarAtributosStaticVariables());
	}
}
