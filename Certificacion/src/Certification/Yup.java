package Certification;

public class Yup {
	private static int x = 4;
	private   Integer y = 5;
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public static void main(String[] args) {
		Yup yup = new Yup();
		yup.setX(8);
		yup.setY(8);
		System.out.println(yup.getX() + yup.getY());
	}

}
