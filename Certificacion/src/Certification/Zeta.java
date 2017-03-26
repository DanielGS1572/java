package Certification;

public class Zeta {

	public static void main(String[] args) {
	int x = 1;
	if((4 > x)  ^ ((++x +2) > 3)){
		System.out.println("entra 1");
		x++;
	}
	if((4 > ++x )  ^ ! (++x==5)){
		System.out.println("entra 2");
		x++;
	}
	
	System.out.println(x);
	
	
	}

}
