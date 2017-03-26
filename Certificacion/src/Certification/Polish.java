package Certification;

public class Polish {

	public static void main(String[] args) {
int x = 4;
StringBuilder sb = new StringBuilder("..fedcba");
//..fazba
sb.delete(3, 6);
sb.insert(3, "az");
System.out.println(sb);
if(sb.length() > 6){
	x = sb.indexOf("b");
	System.out.println(x);
}
sb.delete((x-3), (x-2));
System.out.println(sb);
	}

}
