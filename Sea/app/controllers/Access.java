package controllers;

import java.sql.*;
import java.util.HashMap;
import play.db.DB;

public class Access {

	private Connection con;

	public Access() {

		con = DB.getConnection();
	}

	public HashMap<String, BoatDTO> getBoats() {
		HashMap<String, BoatDTO> map = new HashMap<String, BoatDTO>();
		ResultSet rs;

		try {
			rs = con.createStatement().executeQuery(
					"SELECT * FROM boatinformation");
			while (rs.next()) {
				map.put(rs.getString("registernr"),
						new BoatDTO(rs.getString("registernr"), rs
								.getString("bootsname"), rs
								.getString("segelzeichen"), rs
								.getString("heimathafen"), rs
								.getString("yachtclub"),
								rs.getString("eigner"), rs
										.getString("versicherung"), rs
										.getString("rufzeichen"), rs
										.getString("typ"), rs
										.getString("konstrukteur"), rs
										.getDouble("laenge"), rs
										.getDouble("breite"), rs
										.getDouble("tiefgang"), rs
										.getDouble("masthoehe"), rs
										.getDouble("verdraengung"), rs
										.getString("rigArt"), rs
										.getInt("baujahr"), rs
										.getString("motor"), rs
										.getDouble("tankgroesse"), rs
										.getDouble("wassertankgroesse"), rs
										.getDouble("abwassertankgroesse"), rs
										.getDouble("grosssegelgroesse"), rs
										.getDouble("genuagroesse"), rs
										.getDouble("spi")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return map;
	}

	public BoatDTO getBoat(String key) {
		BoatDTO tmp = null;
		ResultSet rs;
		try {
			rs = con.createStatement().executeQuery(
					"SELECT * FROM boatinformation WHERE registernr='" + key
							+ "'");
			tmp = new BoatDTO(rs.getString("registernr"),
					rs.getString("bootsname"), rs.getString("segelzeichen"),
					rs.getString("heimathafen"), rs.getString("yachtclub"),
					rs.getString("eigner"), rs.getString("versicherung"),
					rs.getString("rufzeichen"), rs.getString("typ"),
					rs.getString("konstrukteur"), rs.getDouble("laenge"),
					rs.getDouble("breite"), rs.getDouble("tiefgang"),
					rs.getDouble("masthoehe"), rs.getDouble("verdraengung"),
					rs.getString("rigArt"), rs.getInt("baujahr"),
					rs.getString("motor"), rs.getDouble("tankgroesse"),
					rs.getDouble("wassertankgroesse"),
					rs.getDouble("abwassertankgroesse"),
					rs.getDouble("grosssegelgroesse"),
					rs.getDouble("genuagroesse"), rs.getDouble("spi"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return tmp;
	}

	public void sendBoat(BoatDTO tmp) {
		try {
			Statement stat = con.createStatement();
			stat.execute("INSERT INTO boatinformation VALUES ('"
					+ tmp.registernr + "', '" + tmp.bootsname + "', '"
					+ tmp.segelzeichen + "', '" + tmp.heimathafen + "', '"
					+ tmp.yachtclub + "','" + tmp.eigner + "','"
					+ tmp.versicherung + "', '" + tmp.rufzeichen + "', '"
					+ tmp.typ + "', '" + tmp.konstrukteur + "', " + tmp.laenge
					+ ", " + tmp.breite + ", " + tmp.tiefgang + ", "
					+ tmp.masthoehe + ", " + tmp.verdraengung + ", '"
					+ tmp.rigArt + "', " + tmp.baujahr + ", '" + tmp.motor
					+ "', " + tmp.tankgroesse + "," + tmp.wassertankgroesse
					+ "," + tmp.abwassertankgroesse + ", "
					+ tmp.grosssegelgroesse + ", " + tmp.genuagroesse + ", "
					+ tmp.spi + ") ON DUPLICATE KEY UPDATE bootsname='"
					+ tmp.bootsname + "', segelzeichen='" + tmp.segelzeichen
					+ "',heimathafen='" + tmp.heimathafen + "',yachtclub='"
					+ tmp.yachtclub + "',eigner='" + tmp.eigner
					+ "',versicherung='" + tmp.versicherung + "',rufzeichen='"
					+ tmp.rufzeichen + "',typ='" + tmp.typ + "',konstrukteur='"
					+ tmp.konstrukteur + "',laenge='" + tmp.laenge
					+ "',breite='" + tmp.breite + "',tiefgang='" + tmp.tiefgang
					+ "',masthoehe='" + tmp.masthoehe + "',verdraengung='"
					+ tmp.verdraengung + "',rigart='" + tmp.rigArt
					+ "',baujahr='" + tmp.baujahr + "',motor='" + tmp.motor
					+ "',tankgroesse='" + tmp.tankgroesse
					+ "',wassertankgroesse='" + tmp.wassertankgroesse
					+ "',abwassertankgroesse='" + tmp.abwassertankgroesse
					+ "',grosssegelgroesse='" + tmp.grosssegelgroesse
					+ "',genuagroesse='" + tmp.genuagroesse + "',spi ='"
					+ tmp.spi + "'");
			stat.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void deleteBoat(String key) {
		try {
			Statement stat = con.createStatement();

			stat.execute("DELETE FROM boatinformation WHERE registernr='" + key
					+ "'");

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
