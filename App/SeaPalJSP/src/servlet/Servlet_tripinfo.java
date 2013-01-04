package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fassade.Fassade_Trip;
import fassade.TripDTO;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 * Servlet implementation class Servlet_tripinfo
 */
@WebServlet("/Servlet_tripinfo")
public class Servlet_tripinfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servlet_tripinfo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Fassade_Trip f = new Fassade_Trip();		
		TripDTO tripDTO = f.getTripBoot(request.getParameter("key"));
		JSONObject json = new JSONObject();
		JSONArray array = new JSONArray();
		JSONObject member = new JSONObject();
	
		member.put("title", tripDTO.title);
		member.put("von", tripDTO.von);
		member.put("nach", tripDTO.nach);
		member.put("skipper", tripDTO.skipper);
		member.put("crew", tripDTO.crew);
		member.put("start", tripDTO.start);
		member.put("ende", tripDTO.ende);
		member.put("dauer", tripDTO.dauer);
		member.put("motor", tripDTO.motor);
		member.put("tankgefuellt", tripDTO.tankgefuellt);
		member.put("notes", tripDTO.notes);
		member.put("registernr", tripDTO.registernr);
		array.add(member);
	
		json.put("Trip", array);
		PrintWriter pw = response.getWriter();
		pw.print(json.toString());
		pw.close();

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Fassade_Trip f = new Fassade_Trip();
		
		TripDTO tripDTO = new TripDTO();
		tripDTO.title = request.getParameter("title");
		tripDTO.von = request.getParameter("von");
		tripDTO.nach = request.getParameter("nach");
		tripDTO.skipper = request.getParameter("skipper");
		tripDTO.crew = request.getParameter("crew");
		tripDTO.start = request.getParameter("start");
		tripDTO.ende = request.getParameter("ende");
		if (!(request.getParameter("dauer").isEmpty())) {
			tripDTO.dauer = Integer.parseInt(request.getParameter("dauer"));
		}
		if (!(request.getParameter("motor").isEmpty())) {
			tripDTO.motor = Integer.parseInt(request.getParameter("motor"));
		}
		if (!(request.getParameter("tankgefuellt").isEmpty())) {
			tripDTO.tankgefuellt = Integer.parseInt(request
					.getParameter("tankgefuellt"));
		}
		tripDTO.notes = request.getParameter("notes");
		tripDTO.registernr = request.getParameter("registernr");

		f.addTrip(tripDTO); 
	}

}
