package Capitulo3.Colecciones8;

import java.util.Enumeration;
import java.util.Hashtable;
// Hashtable no se puede recorrer con la instrucción for, si no con un objeto de tipo Enumeration
// Cuando se recuperan los valores los regresa de forma inversa (primero regresa el ultimo valor introducido
public class Hashtble {
	public static void main(String[] args) {
		Hashtable tb = new Hashtable();
		
		tb.put("a21", "Daniel");
		System.out.println("antes se llamaba: " + tb.put("a21", "Luis"));
		tb.put("a22","Pedro");
		tb.put("a23","Toño");
		
		Enumeration en = tb.keys();
		System.out.println(en.nextElement());
		System.out.println(en.nextElement());
		System.out.println(en.hasMoreElements());
		System.out.println(en.nextElement());
		System.out.println(en.hasMoreElements());
		
		System.out.println();
		System.out.println();
		
		en = tb.keys();			//el chiste es obtener las claves a partir de un objeto Enumeration y luego obtener los valores del hashtable
		do{
			String clave = (String)en.nextElement();
			System.out.println(tb.get(clave));
		}while(en.hasMoreElements());
	}
}
