package Capitulo7;

public class PruebaVarArgs {
	public static double promedio(double... valores){
		double total = 0;
		for(double var:valores){
			total += var;
		}
		return total/valores.length;
	}
	
	public static void main(String args[]) {
		double d1 = 10.0;
		double d2 = 20.0;
		double d3 = 30.0;
		double d4 = 40.0;
		
		System.out.printf("El promedio de d1 y d2 es %.1f\n",
				promedio(d1,d2));
		System.out.printf("El promedio de d1,d2,d3 es %.1f\n",
				promedio(d1,d2,d3));
		System.out.printf("El promedio de d1,d2,d3,d4 es %.1f\n",
				promedio(d1,d2,d3,d4));
	}
}
