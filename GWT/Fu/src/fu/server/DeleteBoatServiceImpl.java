package fu.server;

import java.sql.*;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import fu.client.DeleteBoatService;

public class DeleteBoatServiceImpl extends RemoteServiceServlet implements DeleteBoatService {
	private static final long serialVersionUID = 1L;
	private final String url = "jdbc:mysql://localhost/seapal";
	private final String user = "root";
	private final String password = "";
	private Connection conn = null;
	
	public DeleteBoatServiceImpl(){
		try {
			System.setSecurityManager(null);
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			conn = DriverManager.getConnection(url, user, password);

		} catch (InstantiationException | IllegalAccessException
				| ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public String deleteBoat(String key) {
		String query = "DELETE FROM boatinformation WHERE registernr = '" + key+"'";
		Statement st;
		try {
			st = conn.createStatement();
			st.execute(query);
			st.close();
			return "ok";
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
