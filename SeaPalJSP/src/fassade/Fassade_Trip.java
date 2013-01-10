package fassade;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import backend.Boot;
import backend.Trip;

public class Fassade_Trip {

	
	private Connection connect = null;
	private PreparedStatement preparedStatement = null;
	private Access access;
	private ResultSet result;
	private Map<String, Trip> trips = new HashMap<String, Trip>();
	private Map<String, Trip> tripsBoot = new HashMap<String, Trip>();

	public Fassade_Trip() {
		access = new Access();
		connect = access.getDBConnection();
		try {
			preparedStatement = connect.prepareStatement("Select * From tripinformation");
			result = preparedStatement.executeQuery();
			while(result.next()){
				trips.put(result.getString("title"), new Trip(result.getString("title"),
						result.getString("von"), result.getString("nach"), result.getString("skipper"),
						result.getString("crew"), result.getString("start"), result.getString("ende"),
						result.getDouble("dauer"), result.getInt("motor"), result.getInt("tankgefuellt"),
						result.getString("notes"), result.getString("registernr")));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
	}
	
	public void addTrip(TripDTO tripDTO){

		trips.put(tripDTO.title, new Trip(tripDTO.title, tripDTO.von, tripDTO.nach, tripDTO.skipper,
				tripDTO.crew, tripDTO.start, tripDTO.ende, tripDTO.dauer, tripDTO.motor,
				tripDTO.tankgefuellt, tripDTO.notes, tripDTO.registernr));
		
		try {
			preparedStatement = connect.prepareStatement("insert into seapal.tripinformation VALUES ('"
					+ tripDTO.title + "','" + tripDTO.von + "','"
					+ tripDTO.nach + "','" + tripDTO.skipper + "','"
					+ tripDTO.crew + "','" + tripDTO.start + "','"
					+ tripDTO.ende + "','" + tripDTO.dauer + "','"
					+ tripDTO.motor + "','" + tripDTO.tankgefuellt + "','"
					+ tripDTO.notes + "','" + tripDTO.registernr + "')ON DUPLICATE KEY UPDATE title='" + tripDTO.title +"', von='"+ tripDTO.von + "',nach='" + tripDTO.nach + "',skipper='"
						+ tripDTO.skipper + "',crew='" + tripDTO.crew + "',start='"
						+ tripDTO.start + "',ende='" + tripDTO.ende + "',dauer='"
						+ tripDTO.dauer + "',motor='" + tripDTO.motor + "',tankgefuellt='"
						+ tripDTO.tankgefuellt + "',notes='" + tripDTO.notes + "',registernr='"
						+ tripDTO.registernr+ "'");
			preparedStatement.executeUpdate();
			connect.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public Map<String, TripDTO> getTripsBoot(String regnr){
		try {
			preparedStatement = connect.prepareStatement("Select * From tripinformation where registernr='"+regnr+"'");
			result = preparedStatement.executeQuery();
			while(result.next()){
				tripsBoot.put(result.getString("title"), new Trip(result.getString("title"),
						result.getString("von"), result.getString("nach"), result.getString("skipper"),
						result.getString("crew"), result.getString("start"), result.getString("ende"),
						result.getDouble("dauer"), result.getInt("motor"), result.getInt("tankgefuellt"),
						result.getString("notes"), result.getString("registernr")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Map<String, TripDTO> tripsBootDTO = new HashMap<String, TripDTO>();
		for (String key : tripsBoot.keySet()) {
			TripDTO trip = new TripDTO();
			trip.title = tripsBoot.get(key).getTitle();
			trip.von = tripsBoot.get(key).getVon();
			trip.nach = tripsBoot.get(key).getNach();
			trip.skipper = tripsBoot.get(key).getSkipper();
			trip.crew = tripsBoot.get(key).getCrew();
			trip.start = tripsBoot.get(key).getStart();
			trip.ende = tripsBoot.get(key).getEnde();
			trip.dauer = tripsBoot.get(key).getDauer();
			trip.motor = tripsBoot.get(key).getMotor();
			trip.tankgefuellt = tripsBoot.get(key).getTankgefuellt();
			trip.notes = tripsBoot.get(key).getNotes();
			trip.registernr = tripsBoot.get(key).getRegisternr();
			tripsBootDTO.put(key, trip);
		}	
		return tripsBootDTO;
	}
	
	public TripDTO getTripBoot(String key){
		
			TripDTO tripDTO = new TripDTO();
			tripDTO.title = trips.get(key).getTitle();
			tripDTO.von = trips.get(key).getVon();
			tripDTO.nach = trips.get(key).getNach();
			tripDTO.skipper = trips.get(key).getSkipper();
			tripDTO.crew = trips.get(key).getCrew();
			tripDTO.start = trips.get(key).getStart();
			tripDTO.ende = trips.get(key).getEnde();
			tripDTO.dauer = trips.get(key).getDauer();
			tripDTO.motor = trips.get(key).getMotor();
			tripDTO.tankgefuellt = trips.get(key).getTankgefuellt();
			tripDTO.notes = trips.get(key).getNotes();
			tripDTO.registernr = trips.get(key).getRegisternr();
			
			return tripDTO;
		
	}
	
	public void deleteTrip(String title){
		trips.remove(title);
		try {
			preparedStatement = connect.prepareStatement("DELETE FROM seapal.tripinformation WHERE title='"+title+"'");
			preparedStatement.executeUpdate();
			connect.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}
