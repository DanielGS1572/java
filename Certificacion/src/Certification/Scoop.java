package Certification;

public class Scoop {
	static int x;
	static int thrower() throws Exception{return 42;}
	public static void main(String[] args) {
		int y;
		try{
			x = thrower();
		} catch(Exception e){
			
		}
	}

}
