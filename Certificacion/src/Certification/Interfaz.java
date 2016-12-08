package Certification;

public class Interfaz implements Interfaz1{

	@Override
	public void test2a() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void test2b() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void test1a() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void test1b() {
		// TODO Auto-generated method stub
		
	}

}

interface Interfaz1 extends Interfaz2{
	void test1a();
	void test1b();
	
}

interface Interfaz2{
	void test2a();
	void test2b();
}