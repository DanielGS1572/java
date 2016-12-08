package Capitulo7;

public class Incremento {
	private int total = 0;
	private final int INCREMENTO;
	
	public Incremento( int valorIncremento){
		INCREMENTO = valorIncremento;
	}
	
	public void sumarIncrementoATotal(){
		total += INCREMENTO;
	}
	
	public String toString(){
		System.out.println(java.lang.Math.PI);
		return String.format("Total = %d", total);
	}
	
	public int getInc(){
		return INCREMENTO;
	}
}
