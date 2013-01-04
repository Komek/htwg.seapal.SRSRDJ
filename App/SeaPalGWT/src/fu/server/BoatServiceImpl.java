package fu.server;

import java.sql.*;
import fu.client.BoatDTO;
import fu.client.BoatService;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

@SuppressWarnings("serial")
public class BoatServiceImpl extends RemoteServiceServlet implements
		BoatService {
	private final String url = "jdbc:mysql://localhost/seapal";
	private final String user = "root";
	private final String password = "";
	private Connection conn = null;

	public BoatServiceImpl() {
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			conn = DriverManager.getConnection(url, user, password);

		} catch (InstantiationException | IllegalAccessException
				| ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public String send(BoatDTO boat) throws IllegalArgumentException {
		String ret = null;
		String query = "INSERT INTO boatinformation (Registernr,Bootsname,Segelzeichen,Heimathafen,Yachtclub,Eigner,Versicherung,Rufzeichen,"
				+ "Typ,Konstrukteur,Laenge,Breite,Tiefgang,Masthoehe,Verdraengung,RigArt,Baujahr,Motor,Tankgroesse,Wassertankgroesse,Abwassertankgroesse,"
				+ "Grosssegelgroesse,Genuagroesse,Spi) values ('"
				+ boat.registernr
				+ "','"
				+ boat.bootsname
				+ "','"
				+ boat.segelzeichen
				+ "','"
				+ boat.heimathafen
				+ "','"
				+ boat.yachtclub
				+ "','"
				+ boat.eigner
				+ "','"
				+ boat.versicherung
				+ "','"
				+ boat.rufzeichen
				+ "','"
				+ boat.typ
				+ "','"
				+ boat.konstrukteur
				+ "','"
				+ boat.laenge
				+ "','"
				+ boat.breite
				+ "','"
				+ boat.tiefgang
				+ "','"
				+ boat.masthoehe
				+ "','"
				+ boat.verdraengung
				+ "','"
				+ boat.rigart
				+ "','"
				+ boat.baujahr
				+ "','"
				+ boat.motor
				+ "','"
				+ boat.tankgroesse
				+ "','"
				+ boat.wassertankgroesse
				+ "','"
				+ boat.abwassertankgroesse
				+ "','"
				+ boat.grosssegelgroesse
				+ "','"
				+ boat.genaugroesse
				+ "','"
				+ boat.spi
				+ "') ON DUPLICATE KEY UPDATE bootsname='"
				+ boat.bootsname
				+ "',"
				+ "segelzeichen='"
				+ boat.segelzeichen
				+ "',"
				+ "heimathafen='"
				+ boat.heimathafen
				+ "',"
				+ "yachtclub='"
				+ boat.yachtclub
				+ "',"
				+ "eigner='"
				+ boat.eigner
				+ "',"
				+ "versicherung='"
				+ boat.versicherung
				+ "',"
				+ "rufzeichen='"
				+ boat.rufzeichen
				+ "',"
				+ "typ='"
				+ boat.typ
				+ "',"
				+ "konstrukteur='"
				+ boat.konstrukteur
				+ "',"
				+ "laenge='"
				+ boat.laenge
				+ "',"
				+ "breite='"
				+ boat.breite
				+ "',"
				+ "tiefgang='"
				+ boat.tiefgang
				+ "',"
				+ "masthoehe='"
				+ boat.masthoehe
				+ "',"
				+ "verdraengung='"
				+ boat.verdraengung
				+ "',"
				+ "rigart='"
				+ boat.rigart
				+ "',"
				+ "baujahr='"
				+ boat.baujahr
				+ "',"
				+ "motor='"
				+ boat.motor
				+ "',"
				+ "tankgroesse='"
				+ boat.tankgroesse
				+ "',"
				+ "wassertankgroesse='"
				+ boat.wassertankgroesse
				+ "',"
				+ "abwassertankgroesse='"
				+ boat.abwassertankgroesse
				+ "',"
				+ "grosssegelgroesse='"
				+ boat.grosssegelgroesse
				+ "',"
				+ "genuagroesse='"
				+ boat.genaugroesse
				+ "',"
				+ "spi='"
				+ boat.spi + "'";
		try {
			PreparedStatement statement = conn.prepareStatement(query);
			statement.executeUpdate();
			ret = "ok";
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ret;
	}
}
