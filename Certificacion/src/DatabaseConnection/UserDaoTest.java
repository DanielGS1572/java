package DatabaseConnection;

import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
public class UserDaoTest
{
	UserDao sut;
	@Before
	public void beforeEachUnitTest ()
	{
	sut = new UserDao();
	}
	@After
	public void afterEachUnitTest ()
	{
	sut.closeDatabaseConnection();
	}
	@Test
	public void testDatabase ()
	{
	List<User> users = sut.getUsers();
	for (User user : users)
	{
	System.out.println("Username " 
			 + user.getUsername()  
			 + " Password "  
			 + user.getPassword());
	}
	}
}