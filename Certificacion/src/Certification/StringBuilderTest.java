package Certification;

public class StringBuilderTest {
	public static void main(String [] args){
		int x= 4;
		StringBuilder sb= new StringBuilder("..fedcba");
		sb.delete(3, 6);
//		sb.insert(3, "az");
//		if(sb.length() > 6) x = sb.indexOf("b");
		System.out.println(sb);
	}
}
