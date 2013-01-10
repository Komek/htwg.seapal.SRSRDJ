package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import fassade.EntryDTO;
import fassade.Fassade_Entryinfo;
import fassade.TripDTO;

/**
 * Servlet implementation class Servlet_Entryinfo
 */
@WebServlet("/Servlet_entryinfo")
public class Servlet_entryinfo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Servlet_entryinfo() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		
		Fassade_Entryinfo f = new Fassade_Entryinfo();

		// HASHMAP TO JSON
		response.setContentType("application/json;charset=utf-8");
		if (request.getParameter("key") != null) {
			JSONObject json1 = new JSONObject();
			JSONArray array1 = new JSONArray();
			JSONObject member1 = new JSONObject();
			EntryDTO entryDTO = f.getEntryTrip(request.getParameter("key"));

			java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(
					"yyyy-MMMM-dd HH:mm:ss");
			String time = sdf.format(entryDTO.time.getTime());
			member1.put("name", entryDTO.name);
			member1.put("ngrad", entryDTO.ngrad);
			member1.put("nmin", entryDTO.nmin);
			member1.put("nsec", entryDTO.nsec);
			member1.put("egrad", entryDTO.egrad);
			member1.put("emin", entryDTO.emin);
			member1.put("esec", entryDTO.esec);
			member1.put("cog", entryDTO.cog);
			member1.put("sog", entryDTO.sog);
			member1.put("btm", entryDTO.btm);
			member1.put("dtm", entryDTO.dtm);
			member1.put("fahrtNach", entryDTO.fahrtNach);
			member1.put("manoever", entryDTO.manoever);
			member1.put("vorsegel", entryDTO.vorsegel);
			member1.put("grosssegel", entryDTO.grosssegel);
			member1.put("notes", entryDTO.notes);
			member1.put("time", time);
			member1.put("triptitle", entryDTO.triptitle);
			array1.add(member1);

			json1.put("Entry", array1);
			PrintWriter pw1 = response.getWriter();
			pw1.print(json1.toString());
			pw1.close();
		}else{
			
			JSONObject json = new JSONObject();
			JSONArray array = new JSONArray();
			JSONObject member = new JSONObject();
			
			Map<String, EntryDTO> entrys = f.getEntrysTrip(request
					.getParameter("triptitle"));
			for (String key : entrys.keySet()) {
				member = new JSONObject();
				java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(
						"HH:mm:ss");
				String time = sdf.format(entrys.get(key).time.getTime());
				member.put("name", entrys.get(key).name);
				member.put("ngrad", entrys.get(key).ngrad);
				member.put("nmin", entrys.get(key).nmin);
				member.put("nsec", entrys.get(key).nsec);
				member.put("egrad", entrys.get(key).egrad);
				member.put("emin", entrys.get(key).emin);
				member.put("esec", entrys.get(key).esec);
				member.put("cog", entrys.get(key).cog);
				member.put("sog", entrys.get(key).sog);
				member.put("btm", entrys.get(key).btm);
				member.put("dtm", entrys.get(key).dtm);
				member.put("fahrtNach", entrys.get(key).fahrtNach);
				member.put("manoever", entrys.get(key).manoever);
				member.put("vorsegel", entrys.get(key).vorsegel);
				member.put("grosssegel", entrys.get(key).grosssegel);
				member.put("notes", entrys.get(key).notes);
				member.put("time", time);
				member.put("triptitle", entrys.get(key).triptitle);
				array.add(member);

			}

			json.put("Entrys", array);
			PrintWriter pw = response.getWriter();
			pw.print(json.toString());
			pw.close();
		}
			

		// DELETE
		String del = request.getParameter("wert");
		f.deleteEntry(del);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		Fassade_Entryinfo f = new Fassade_Entryinfo();

		if (!(request.getParameter("name").isEmpty())) {
			EntryDTO entryDTO = new EntryDTO();
			entryDTO.name = request.getParameter("name");
			if (!(request.getParameter("ngrad").isEmpty())) {
				entryDTO.ngrad = Integer
						.parseInt(request.getParameter("ngrad"));
			}
			if (!(request.getParameter("nmin").isEmpty())) {
				entryDTO.nmin = Integer.parseInt(request.getParameter("nmin"));
			}
			if (!(request.getParameter("nsec").isEmpty())) {
				entryDTO.nsec = Integer.parseInt(request.getParameter("nsec"));
			}
			if (!(request.getParameter("egrad").isEmpty())) {
				entryDTO.egrad = Integer
						.parseInt(request.getParameter("egrad"));
			}
			if (!(request.getParameter("emin").isEmpty())) {
				entryDTO.emin = Integer.parseInt(request.getParameter("emin"));
			}
			if (!(request.getParameter("esec").isEmpty())) {
				entryDTO.esec = Integer.parseInt(request.getParameter("esec"));
			}
			if (!(request.getParameter("cog").isEmpty())) {
				entryDTO.cog = Double.parseDouble(request.getParameter("cog"));
			}
			if (!(request.getParameter("sog").isEmpty())) {
				entryDTO.sog = Double.parseDouble(request.getParameter("sog"));
			}
			if (!(request.getParameter("btm").isEmpty())) {
				entryDTO.btm = Integer.parseInt(request.getParameter("btm"));
			}
			if (!(request.getParameter("dtm").isEmpty())) {
				entryDTO.dtm = Double.parseDouble(request.getParameter("dtm"));
			}
			entryDTO.fahrtNach = request.getParameter("fahrtnach");
			entryDTO.manoever = request.getParameter("manoever");
			entryDTO.vorsegel = request.getParameter("vorsegel");
			entryDTO.grosssegel = request.getParameter("grosssegel");
			entryDTO.notes = request.getParameter("notes");
			entryDTO.triptitle = request.getParameter("triptitle");
			f.addEntry(entryDTO);
		}
	}

}
