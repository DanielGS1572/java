package Capitulo3.Colecciones8;

public class PracticaInvierteCadenas {
	public static void main(String args[]){
		String cad=args[0];
		
		String caraux="";
		for(int i=cad.length()-1;i>=0;i--){
			caraux+=cad.charAt(i);
		}
		
		System.out.println(caraux);
	}
}
