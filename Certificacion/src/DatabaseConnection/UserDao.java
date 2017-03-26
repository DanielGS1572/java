package DatabaseConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserDao {
	// this is the URL that is needed to connect to your
	// database. Here we're using MYSQL, a free RDBMS.
	// The database name I've used is 'test'
	String url = "jdbc:mysql://localhost:3306/test";
	Connection con = null;

	public UserDao() {
		try {
			// this is the driver for the MySQL RDBMS,
			// each database system has a different class
			// that is used to connect to the DBMS.
			Class.forName("com.mysql.jdbc.Driver");
		} catch (Exception e) {
			System.out.println("Failed to load MySQL driver.");
			e.printStackTrace();
			return;
		}
		try {
			this.con = DriverManager.getConnection(url, "root", "password");
			System.out.println("Created a database connection.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<User> getUsers() {
		Statement select = null;
		ResultSet result = null;
		List<User> users = new ArrayList<User>();
		try {
			select = this.con.createStatement();
			result = select.executeQuery("SELECT username, password FROM users");
			while (result.next()) {
				// process results one row at a time
				// by mapping the data from the database to
				// the a User object
				String username = result.getString(1);
				String password = result.getString(2);
				users.add(new User(username, password));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeQueryConnection(select);
		}
		return users;
	}

	private void closeQueryConnection(Statement select) {
		try {
			if (select != null) {
				select.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void closeDatabaseConnection() {
		try {
			if (this.con != null) {
				this.con.close();
				System.out.println("Database connection is now safely closed.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
