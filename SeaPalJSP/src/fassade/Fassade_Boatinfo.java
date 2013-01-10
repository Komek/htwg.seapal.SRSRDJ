package fassade;

import java.util.HashMap;
import java.util.Map;
import backend.Boot;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Fassade_Boatinfo {

	private Connection connect = null;
	private PreparedStatement preparedStatement = null;
	private Access access;
	private ResultSet result;
	private Map<String, Boot> boote = new HashMap<String, Boot>();

	public Fassade_Boatinfo() {
		access = new Access();
		connect = access.getDBConnection();
		try {
			preparedStatement = connect.prepareStatement("Select * From boatinformation");
			result = preparedStatement.executeQuery();
			while(result.next()){
				boote.put(result.getString("registernr"), new Boot(result.getString("registernr"),
						result.getString("bootsname"), result.getString("segelzeichen"), result.getString("heimathafen"),
						result.getString("yachtclub"), result.getString("eigner"), result.getString("versicherung"),
						result.getString("rufzeichen"), result.getString("typ"), result.getString("konstrukteur"),
						result.getDouble("laenge"), result.getDouble("breite"), result.getDouble("tiefgang"),
						result.getDouble("masthoehe"), result.getDouble("verdraengung"), result.getString("rigArt"),
						result.getInt("baujahr"),result.getString("motor"), result.getDouble("tankgroesse"),
						result.getDouble("wassertankgroesse"), result.getDouble("abwassertankgroesse"),
						result.getDouble("grosssegelgroesse"), result.getDouble("genuagroesse"),
						result.getDouble("spi")));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public Map<String, BootDTO> getBootsUebersicht() {
		Map<String, BootDTO> bootsDTOs = new HashMap<String, BootDTO>();
		for (String key : boote.keySet()) {
			BootDTO bootDTO = new BootDTO();
			bootDTO.registernr = boote.get(key).getRegisternr();
			bootDTO.abwassertankgroesse = boote.get(key)
					.getAbwassertankgroesse();
			bootDTO.baujahr = boote.get(key).getBaujahr();
			bootDTO.bootsname = boote.get(key).getBootsname();
			bootDTO.breite = boote.get(key).getBreite();
			bootDTO.eigner = boote.get(key).getEigner();
			bootDTO.genuagroesse = boote.get(key).getGenuagroesse();
			bootDTO.grosssegelgroesse = boote.get(key).getGrosssegelgroesse();
			bootDTO.heimathafen = boote.get(key).getHeimathafen();
			bootDTO.konstrukteur = boote.get(key).getKonstrukteur();
			bootDTO.laenge = boote.get(key).getLaenge();
			bootDTO.masthoehe = boote.get(key).getMasthoehe();
			bootDTO.motor = boote.get(key).getMotor();
			bootDTO.rigArt = boote.get(key).getRigArt();
			bootDTO.rufzeichen = boote.get(key).getRufzeichen();
			bootDTO.segelzeichen = boote.get(key).getSegelzeichen();
			bootDTO.spi = boote.get(key).getSpi();
			bootDTO.tankgroesse = boote.get(key).getTankgroesse();
			bootDTO.tiefgang = boote.get(key).getTiefgang();
			bootDTO.typ = boote.get(key).getTyp();
			bootDTO.verdraengung = boote.get(key).getVerdraengung();
			bootDTO.versicherung = boote.get(key).getVersicherung();
			bootDTO.wassertankgroesse = boote.get(key).getWassertankgroesse();
			bootDTO.versicherung = boote.get(key).getVersicherung();
			bootDTO.yachtclub = boote.get(key).getYachtclub();
			bootsDTOs.put(key, bootDTO);
		}
		
		return bootsDTOs;
	}

	public BootDTO getBoot(String key) {
		BootDTO bootDTO = new BootDTO();
		bootDTO.registernr = boote.get(key).getRegisternr();
		bootDTO.abwassertankgroesse = boote.get(key).getAbwassertankgroesse();
		bootDTO.baujahr = boote.get(key).getBaujahr();
		bootDTO.bootsname = boote.get(key).getBootsname();
		bootDTO.breite = boote.get(key).getBreite();
		bootDTO.eigner = boote.get(key).getEigner();
		bootDTO.genuagroesse = boote.get(key).getGenuagroesse();
		bootDTO.grosssegelgroesse = boote.get(key).getGrosssegelgroesse();
		bootDTO.heimathafen = boote.get(key).getHeimathafen();
		bootDTO.konstrukteur = boote.get(key).getKonstrukteur();
		bootDTO.laenge = boote.get(key).getLaenge();
		bootDTO.masthoehe = boote.get(key).getMasthoehe();
		bootDTO.motor = boote.get(key).getMotor();
		bootDTO.rigArt = boote.get(key).getRigArt();
		bootDTO.rufzeichen = boote.get(key).getRufzeichen();
		bootDTO.segelzeichen = boote.get(key).getSegelzeichen();
		bootDTO.spi = boote.get(key).getSpi();
		bootDTO.tankgroesse = boote.get(key).getTankgroesse();
		bootDTO.tiefgang = boote.get(key).getTiefgang();
		bootDTO.typ = boote.get(key).getTyp();
		bootDTO.verdraengung = boote.get(key).getVerdraengung();
		bootDTO.versicherung = boote.get(key).getVersicherung();
		bootDTO.wassertankgroesse = boote.get(key).getWassertankgroesse();
		bootDTO.versicherung = boote.get(key).getVersicherung();
		bootDTO.yachtclub = boote.get(key).getYachtclub();

		return bootDTO;
	}

	public void saveBoot(BootDTO bootDTO) {
		boote.put(bootDTO.registernr, new Boot(bootDTO.registernr,
				bootDTO.bootsname, bootDTO.segelzeichen, bootDTO.heimathafen,
				bootDTO.yachtclub, bootDTO.eigner, bootDTO.versicherung,
				bootDTO.rufzeichen, bootDTO.typ, bootDTO.konstrukteur,
				bootDTO.laenge, bootDTO.breite, bootDTO.tiefgang,
				bootDTO.masthoehe, bootDTO.verdraengung, bootDTO.rigArt,
				bootDTO.baujahr, bootDTO.motor, bootDTO.tankgroesse,
				bootDTO.wassertankgroesse, bootDTO.abwassertankgroesse,
				bootDTO.grosssegelgroesse, bootDTO.genuagroesse,
				bootDTO.spi));

		

		try {
			preparedStatement = connect.prepareStatement("insert into seapal.boatinformation VALUES ('"
					+ bootDTO.registernr + "','" + bootDTO.bootsname + "','"
					+ bootDTO.segelzeichen + "','" + bootDTO.heimathafen + "','"
					+ bootDTO.yachtclub + "','" + bootDTO.eigner + "','"
					+ bootDTO.versicherung + "','" + bootDTO.rufzeichen + "','"
					+ bootDTO.typ + "','" + bootDTO.konstrukteur + "','"
					+ bootDTO.laenge + "','" + bootDTO.breite + "','"
					+ bootDTO.tiefgang + "','" + bootDTO.masthoehe + "','"
					+ bootDTO.verdraengung + "','" + bootDTO.rigArt + "','"
					+ bootDTO.baujahr + "','" + bootDTO.motor + "','"
					+ bootDTO.tankgroesse + "','" + bootDTO.wassertankgroesse + "','"
					+ bootDTO.abwassertankgroesse + "','" + bootDTO.grosssegelgroesse
					+ "','" + bootDTO.genuagroesse + "','" + bootDTO.spi
					+ "') ON DUPLICATE KEY UPDATE bootsname='" + bootDTO.bootsname +"', segelzeichen='"+ bootDTO.segelzeichen + "',heimathafen='" + bootDTO.heimathafen + "',yachtclub='"
							+ bootDTO.yachtclub + "',eigner='" + bootDTO.eigner + "',versicherung='"
							+ bootDTO.versicherung + "',rufzeichen='" + bootDTO.rufzeichen + "',typ='"
							+ bootDTO.typ + "',konstrukteur='" + bootDTO.konstrukteur + "',laenge='"
							+ bootDTO.laenge + "',breite='" + bootDTO.breite + "',tiefgang='"
							+ bootDTO.tiefgang + "',masthoehe='" + bootDTO.masthoehe + "',verdraengung='"
							+ bootDTO.verdraengung + "',rigart='" + bootDTO.rigArt + "',baujahr='"
							+ bootDTO.baujahr + "',motor='" + bootDTO.motor + "',tankgroesse='"
							+ bootDTO.tankgroesse + "',wassertankgroesse='" + bootDTO.wassertankgroesse + "',abwassertankgroesse='"
							+ bootDTO.abwassertankgroesse + "',grosssegelgroesse='" + bootDTO.grosssegelgroesse
							+ "',genuagroesse='" + bootDTO.genuagroesse + "',spi='" + bootDTO.spi
							+ "'");
			preparedStatement.executeUpdate();

			connect.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}
	
	public void deleteBoot(String registernr){
		boote.remove(registernr);
		try {
			preparedStatement = connect.prepareStatement("DELETE FROM seapal.boatinformation WHERE registernr='"+registernr+"'");
			preparedStatement.executeUpdate();
			connect.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
