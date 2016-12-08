package Capitulo7;

public class Fecha {
	private int mes;
	private int dia;
	private int anio;

	public Fecha(int elMes, int elDia, int elAnio) {
		mes = comprobarMes(elMes);
		anio = elAnio;
		dia = comprobarDia(elDia);
		System.out.printf("Constructor de objeto Fehca para la fecha %s\n", this);
	}

	private int comprobarMes(int mesPrueba) {
		if (mesPrueba > 0 && mesPrueba <= 12) {
			return mesPrueba;
		} else {
			System.out.printf("Mes invalido (%d) se establecio en 1", mesPrueba);
			return 1;
		}
	}

	private int comprobarDia(int diaPrueba) {
		int diasPorMes[] = { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
		if (diaPrueba > 0 && diaPrueba <= diasPorMes[mes])
			return diaPrueba;
		if (mes == 2 && diaPrueba == 29 && (anio % 400 == 0 || (anio % 4 == 0 && anio % 100 != 0)))
			return diaPrueba;
	    System.out.printf( "Dia invalido (%d) se establecio en 1.", diaPrueba );
	      return 1;  // mantiene el objeto en estado consistente
	}
	public String toString()
	   {
	      return String.format( "%d/%d/%d", mes, dia, anio );
	   } 
}
