package fu.server;

import java.sql.*;
import java.util.Collection;
import java.util.ArrayList;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import fu.client.BoatDTO;
import fu.client.SelectBoatService;

public class SelectBoatServiceImpl extends RemoteServiceServlet implements
		SelectBoatService {
	private static final long serialVersionUID = 1L;
	private final String url = "jdbc:mysql://localhost/seapal";
	private final String user = "root";
	private final String password = "";
	private Connection conn = null;

	public SelectBoatServiceImpl() {
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

	public Collection<BoatDTO> selectBoat() throws IllegalArgumentException {
		Collection<BoatDTO> boats = new ArrayList<BoatDTO>();
		BoatDTO tmp;
		String query = "SELECT * FROM boatinformation";
		Statement st;
		try {
			st = conn.createStatement();
			ResultSet rs = st.executeQuery(query);
			while (rs.next()) {
				tmp = new BoatDTO();
				tmp.registernr = rs.getString(1);
				tmp.bootsname = rs.getString(2);
				tmp.segelzeichen = rs.getString(3);
				tmp.heimathafen = rs.getString(4);
				tmp.yachtclub = rs.getString(5);
				tmp.eigner = rs.getString(6);
				tmp.versicherung = rs.getString(7);
				tmp.rufzeichen = rs.getString(8);
				tmp.typ = rs.getString(9);
				tmp.konstrukteur = rs.getString(10);
				tmp.laenge = rs.getDouble(11);
				tmp.breite = rs.getDouble(12);
				tmp.tiefgang = rs.getDouble(13);
				tmp.masthoehe = rs.getDouble(14);
				tmp.verdraengung = rs.getDouble(15);
				tmp.rigart = rs.getString(16);
				tmp.baujahr = rs.getInt(17);
				tmp.motor = rs.getString(18);
				tmp.tankgroesse = rs.getInt(19);
				tmp.wassertankgroesse = rs.getInt(20);
				tmp.abwassertankgroesse = rs.getInt(21);
				tmp.grosssegelgroesse = rs.getDouble(22);
				tmp.genaugroesse = rs.getDouble(23);
				tmp.spi = rs.getDouble(24);
				boats.add(tmp);
			}
			st.close();
			return boats;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return boats;
	}
}
