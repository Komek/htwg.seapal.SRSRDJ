package fassade;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Access {

	private final String hostname = "localhost";
	private final String dbname = "seapal";
	private final String user = "root";
	private final String passwort = "";
	private Connection connect = null;
	
	public Connection getDBConnection(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connect = DriverManager.getConnection("jdbc:mysql://" + hostname
					+ "/" + dbname + "?user=" + user + "&password=" + passwort
					+ "");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return connect;
		
	}
	
}
