package Certification;

public class Circus {
	public static void main(String[] args) {
		int x = 9;
		int y = 6;
		for (int z = 0; z < 6; z++, y--) {
			if (x > 2)
				x--;
			label: if (x > 5) {
				System.out.println(x + " ");
				--x;
				break label;
			}
			System.out.println(" z = " + z + " x = " + x);
			 x--;
		}
	}
}
