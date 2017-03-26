package Certification;

public class Update {

	public static void main(String[] args) {
		int[] a1 = { 1, 2, 3 };

		for (int v : a1)
			System.out.println(v + " first a1 ");
		System.out.println();
		int[] a2 = adjust(a1);
		for (int v : a1)
			System.out.println(v + " second a1 ");
		System.out.println();
		for (int v : a2)
			System.out.println(v + " first a2 ");
	}

	public static int[] adjust(int par[]) {
		par[5] = 4;
		return par;
	}
}
