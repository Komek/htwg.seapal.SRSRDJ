package client;

import java.sql.SQLException;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

import fassade.*;
public class start {

	/**
	 * @param args
	 * @throws SQLException 
	 */
	public static void main(String[] args) throws SQLException {
		Fassade_Entryinfo f = new Fassade_Entryinfo();
		EntryDTO e = new EntryDTO();
		e.name="test1";
		e.triptitle="testtrip";
		f.addEntry(e);
		
//		f.saveBoot(b);
//		f.deleteBoot("1tzdsfddf");
		Map<String, EntryDTO> entrys= f.getEntrysTrip("testtrip");
		for (String key : entrys.keySet()){
			System.out.println(entrys.get(key).name);
			System.out.println(entrys.get(key).time.getTime());

		}
//		f.deleteBoot("neuregisternr2");
	}

}
