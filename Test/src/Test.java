import java.awt.List;
import java.util.ArrayList;

public class Test {
	public static void main (String [] args){
		ArrayList<HelperClas> myList = new ArrayList<HelperClas>();
		
		myList.add(new HelperClas(1,"test","test",1,1));
		myList.add(new HelperClas(2,"test","test",1,1));
		myList.add(new HelperClas(3,"test","test",1,1));
		
		System.out.println(myList.get(2).getId());
	}
}
