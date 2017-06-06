package db;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBconn {
	static String db = "prac6";
	static String db_user = System.getenv("OPENSHIFT_MYSQL_DB_USERNAME");
	static String db_pwd = System.getenv("OPENSHIFT_MYSQL_DB_PASSWORD");
	static String host = System.getenv("OPENSHIFT_MYSQL_DB_HOST");
	static String port = System.getenv("OPENSHIFT_MYSQL_DB_PORT");
	
	public static Connection getConnection() throws Exception{
		Class.forName("com.mysql.jdbc.Driver");
		String connURL = "jdbc:mysql://"+host+":"+port+"/"+db+"?user="+db_user+"&password="+db_pwd;
		return DriverManager.getConnection(connURL);
	}
}
