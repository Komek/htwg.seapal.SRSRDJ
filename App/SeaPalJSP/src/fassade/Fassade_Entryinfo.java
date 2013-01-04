package fassade;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

import backend.Entry;
import backend.Trip;

public class Fassade_Entryinfo {

	private Connection connect = null;
	private PreparedStatement preparedStatement = null;
	private Access access;
	private ResultSet result;
	//private Map<String, Entry> entrys = new HashMap<String, Entry>();
	private Map<String, Entry> entrysTrip = new HashMap<String, Entry>();
	
	public Fassade_Entryinfo() {
		access = new Access();
		connect = access.getDBConnection();
		/*try {
			preparedStatement = connect.prepareStatement("Select * From entryinformation");
			result = preparedStatement.executeQuery();
			GregorianCalendar time;
			while(result.next()){
				time = new GregorianCalendar();
				time.setTime(result.getTimestamp("time"));
				entrys.put(result.getString("name"), new Entry(result.getString("name"),
						result.getInt("ngrad"), result.getInt("nmin"), result.getInt("nsec"),
						result.getInt("egrad"), result.getInt("emin"), result.getInt("esec"),
						result.getDouble("cog"), result.getDouble("sog"), result.getInt("btm"),
						result.getDouble("dtm"), result.getString("fahrtnach"), result.getString("manoever"),
						result.getString("vorsegel"), result.getString("grosssegel"), result.getString("notes"),
						time,result.getString("triptitle")));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
	}
	
	public void addEntry(EntryDTO entryDTO){
		
		/*entrys.put(entryDTO.name, new Entry(entryDTO.name, entryDTO.ngrad, entryDTO.nmin, entryDTO.nsec, entryDTO.egrad,
			entryDTO.emin, entryDTO.esec, entryDTO.cog, entryDTO.sog, entryDTO.btm, entryDTO.dtm,
			entryDTO.fahrtNach, entryDTO.manoever, entryDTO.vorsegel,
			entryDTO.grosssegel, entryDTO.notes, entryDTO.time,
			entryDTO.triptitle));
		*/
		try {
			preparedStatement = connect.prepareStatement("insert into entryinformation (name,ngrad,nmin,nsec,egrad,emin,esec,cog,sog,btm,dtm,fahrtnach,manoever,vorsegel,grosssegel,notes,triptitle) VALUES ('"
					+ entryDTO.name + "','" + entryDTO.ngrad + "','"
					+ entryDTO.nmin + "','" + entryDTO.nsec + "','"
					+ entryDTO.egrad + "','" + entryDTO.emin + "','"
					+ entryDTO.esec + "','" + entryDTO.cog + "','"
					+ entryDTO.sog + "','" + entryDTO.btm + "','"
					+ entryDTO.dtm + "','" + entryDTO.fahrtNach + "','"
					+ entryDTO.manoever + "','" + entryDTO.vorsegel + "','"
					+ entryDTO.grosssegel + "','" + entryDTO.notes + "','" 
					+ entryDTO.triptitle +"')ON DUPLICATE KEY UPDATE name='" + entryDTO.name +"', ngrad='"+ entryDTO.ngrad + "',nmin='" + entryDTO.nmin + "',nsec='"
						+ entryDTO.nsec + "',egrad='" + entryDTO.egrad + "',emin='"
						+ entryDTO.emin + "',esec='" + entryDTO.esec + "',cog='"
						+ entryDTO.cog + "',sog='" + entryDTO.sog + "',btm='"
						+ entryDTO.btm + "',dtm='" + entryDTO.dtm + "',fahrtnach='"
						+ entryDTO.fahrtNach+  "',manoever='" + entryDTO.manoever + "',vorsegel='"
						+ entryDTO.vorsegel + "',grosssegel='" + entryDTO.grosssegel + "',notes='"
						+ entryDTO.notes + "',triptitle='"
						+ entryDTO.triptitle+ "'");
			preparedStatement.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public Map<String, EntryDTO> getEntrysTrip(String triptitle){
		try {
			preparedStatement = connect.prepareStatement("Select * From entryinformation where triptitle='"+triptitle+"'");
			result = preparedStatement.executeQuery();
			GregorianCalendar time;
			while(result.next()){
				time = new GregorianCalendar();
				time.setTime(result.getTimestamp("time"));
				entrysTrip.put(result.getString("name"), new Entry(result.getString("name"),
						result.getInt("ngrad"), result.getInt("nmin"), result.getInt("nsec"),
						result.getInt("egrad"), result.getInt("emin"), result.getInt("esec"),
						result.getDouble("cog"), result.getDouble("sog"), result.getInt("btm"),
						result.getDouble("dtm"), result.getString("fahrtnach"), result.getString("manoever"),
						result.getString("vorsegel"), result.getString("grosssegel"), result.getString("notes"),
						time,result.getString("triptitle")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Map<String, EntryDTO> entrysTripDTO = new HashMap<String, EntryDTO>();
		for (String key : entrysTrip.keySet()) {
			EntryDTO entry = new EntryDTO();
			entry.name = entrysTrip.get(key).getName();
			entry.ngrad = entrysTrip.get(key).getNgrad();
			entry.nmin = entrysTrip.get(key).getNmin();
			entry.nsec = entrysTrip.get(key).getNsec();
			entry.egrad = entrysTrip.get(key).getEgrad();
			entry.emin = entrysTrip.get(key).getEmin();
			entry.esec = entrysTrip.get(key).getEsec();
			entry.cog = entrysTrip.get(key).getCog();
			entry.sog = entrysTrip.get(key).getSog();
			entry.btm = entrysTrip.get(key).getBtm();
			entry.dtm = entrysTrip.get(key).getDtm();
			entry.fahrtNach = entrysTrip.get(key).getFahrtNach();
			entry.manoever = entrysTrip.get(key).getManoever();
			entry.vorsegel = entrysTrip.get(key).getVorsegel();
			entry.grosssegel = entrysTrip.get(key).getGrosssegel();
			entry.notes = entrysTrip.get(key).getNotes();
			entry.time = entrysTrip.get(key).getTime();
			entry.triptitle = entrysTrip.get(key).getTriptitle();
			entrysTripDTO.put(key, entry);
		}	
		
		return entrysTripDTO;
	}
	
	public EntryDTO getEntryTrip(String key){
		try {
			preparedStatement = connect.prepareStatement("Select * From entryinformation where name='"+key+"'");
			result = preparedStatement.executeQuery();
			GregorianCalendar time;
			while(result.next()){
				time = new GregorianCalendar();
				time.setTime(result.getTimestamp("time"));
				entrysTrip.put(result.getString("name"), new Entry(result.getString("name"),
						result.getInt("ngrad"), result.getInt("nmin"), result.getInt("nsec"),
						result.getInt("egrad"), result.getInt("emin"), result.getInt("esec"),
						result.getDouble("cog"), result.getDouble("sog"), result.getInt("btm"),
						result.getDouble("dtm"), result.getString("fahrtnach"), result.getString("manoever"),
						result.getString("vorsegel"), result.getString("grosssegel"), result.getString("notes"),
						time,result.getString("triptitle")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		EntryDTO entryDTO = new EntryDTO();
		entryDTO.name = entrysTrip.get(key).getName();
		entryDTO.ngrad = entrysTrip.get(key).getNgrad();
		entryDTO.nmin = entrysTrip.get(key).getNmin();
		entryDTO.nsec = entrysTrip.get(key).getNsec();
		entryDTO.egrad = entrysTrip.get(key).getEgrad();
		entryDTO.emin = entrysTrip.get(key).getEmin();
		entryDTO.esec = entrysTrip.get(key).getEsec();
		entryDTO.cog = entrysTrip.get(key).getCog();
		entryDTO.sog = entrysTrip.get(key).getSog();
		entryDTO.btm = entrysTrip.get(key).getBtm();
		entryDTO.dtm = entrysTrip.get(key).getDtm();
		entryDTO.fahrtNach = entrysTrip.get(key).getFahrtNach();
		entryDTO.manoever = entrysTrip.get(key).getManoever();
		entryDTO.vorsegel = entrysTrip.get(key).getVorsegel();
		entryDTO.grosssegel = entrysTrip.get(key).getGrosssegel();
		entryDTO.notes = entrysTrip.get(key).getNotes();
		entryDTO.time = entrysTrip.get(key).getTime();
		entryDTO.triptitle = entrysTrip.get(key).getTriptitle();
		
		return entryDTO;
	}
	
	
	
	public void deleteEntry(String name){
		//entrys.remove(name);
		try {
			preparedStatement = connect.prepareStatement("DELETE FROM seapal.entryinformation WHERE name='"+name+"'");
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
}
