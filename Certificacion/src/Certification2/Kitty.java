package Certification2;

public class Kitty  extends Feline{
	String name = "kitty";
	Kitty(String n){
		super("");
		name = n;
	}
	public static void main(String [] args){
		Kitty k = new Kitty("niki");
		System.out.println(k.name);
		
	}
}

class Feline{
	String name;
	Feline(String n){
		name = " " + n + " ";
	}
}