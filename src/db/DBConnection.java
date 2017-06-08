package db;

import java.sql.*;

public class DBConnection {

	public static Connection getConnection() throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		String connURL = "jdbc:mysql://localhost/sectestdb?user=sectest&password=1qwer$#@!";
		Connection conn = DriverManager.getConnection(connURL);

		return conn;

	}
}
