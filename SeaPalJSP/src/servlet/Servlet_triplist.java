package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

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
 * Servlet implementation class Servlet_Triplist
 */
@WebServlet("/Servlet_triplist")
public class Servlet_triplist extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servlet_triplist() {
        super();
        // TODO Auto-generated constructor stub
    }
    protected void processRequest(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		Fassade_Trip f = new Fassade_Trip();
		
		//HASHMAP TO JSON
		response.setContentType("application/json;charset=utf-8");
		Map<String, TripDTO> trips = f.getTripsBoot(request.getParameter("registernr"));
		JSONObject json = new JSONObject();
		JSONArray array = new JSONArray();
		JSONObject member = new JSONObject();

		for (String key : trips.keySet()) {
			member = new JSONObject();

			member.put("title", trips.get(key).title);
			member.put("von", trips.get(key).von);
			member.put("nach",trips.get(key).nach);
			member.put("skipper", trips.get(key).skipper);
			member.put("crew", trips.get(key).crew);
			member.put("start", trips.get(key).start);
			member.put("ende", trips.get(key).ende);
			member.put("dauer", trips.get(key).motor);
			member.put("tankgefuellt", trips.get(key).tankgefuellt);
			member.put("notes", trips.get(key).notes);
			member.put("registernr", trips.get(key).registernr);
			array.add(member);

		}

		json.put("Trips", array);
		PrintWriter pw = response.getWriter();
		pw.print(json.toString());
		pw.close();
		
		//DELETE
		String del = request.getParameter("wert");
		f.deleteTrip(del);
		
	}
    
    
    

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

}
