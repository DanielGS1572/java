package Certificacion;


public class Kitty  extends Feline{
	String name = "kitty";
	Kitty(String n){	//Debe existir un constructor de tipo Feline para solucinar el problema
//		super("");	
		name = n;
	}
	public static void main(String [] args){
		Kitty k = new Kitty("niki");
		System.out.println(k.name);		//Se puede acceder a una variable estatica
//		name; //pero no se puede llamarla directamente
		
	}
}

class Feline{
	String name;
	Feline(String n){
		name = " " + n + " ";
	}
	Feline(){
		
	}
}