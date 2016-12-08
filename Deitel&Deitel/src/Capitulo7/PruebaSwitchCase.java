package Capitulo7;

public class PruebaSwitchCase {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String x = "" ;
		switch(x){
		case "a": {
			System.out.println("a1");
			System.out.println("a2");
			break;
		}
		case "b": 
			System.out.println("b1");
			System.out.println("b2");
			break;
		default:
			System.out.println("xxx");
		}
		
		do{
			System.out.println("1time");
		}while(false);
		
		
		int x2 = 0;
		for(;x2<10;){
			++x2;
			System.out.println(x2);
		}
	}

}
