package HackerRank;

import java.util.Scanner;

public class DayOne {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int entero = scanner.nextInt();
		double doble = scanner.nextDouble();
		scanner.nextLine();
		String cadena = scanner.nextLine();
		scanner.close();
		System.out.println(entero + " entero " + doble + " doble " + cadena + " cadena");
	}

}
