package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import fassade.BootDTO;
import fassade.Fassade_Boatinfo;

/**
 * Servlet implementation class Servlet_boatinfo
 */
@WebServlet("/Servlet_boatinfo")
public class Servlet_boatinfo extends HttpServlet {
	private static final long serialVersionUID = 1L;



	protected void processRequest(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		Fassade_Boatinfo f = new Fassade_Boatinfo();
		
		//HASHMAP TO JSON BOAT
		response.setContentType("application/json;charset=utf-8");
		Map<String, BootDTO> boote = f.getBootsUebersicht();
		JSONObject json = new JSONObject();
		JSONArray array = new JSONArray();
		JSONObject member = new JSONObject();

		for (String key : boote.keySet()) {
			member = new JSONObject();

			member.put("registernr", boote.get(key).registernr);
			member.put("bootsname", boote.get(key).bootsname);
			member.put("abwassertankgroesse",boote.get(key).abwassertankgroesse);
			member.put("baujahr", boote.get(key).baujahr);
			member.put("breite", boote.get(key).breite);
			member.put("eigner", boote.get(key).eigner);
			member.put("genuagroesse", boote.get(key).genuagroesse);
			member.put("grosssegelgroesse", boote.get(key).grosssegelgroesse);
			member.put("heimathafen", boote.get(key).heimathafen);
			member.put("konstrukteur", boote.get(key).konstrukteur);
			member.put("laenge", boote.get(key).laenge);
			member.put("masthoehe", boote.get(key).masthoehe);
			member.put("motor", boote.get(key).motor);
			member.put("rigArt", boote.get(key).rigArt);
			member.put("rufzeichen", boote.get(key).rufzeichen);
			member.put("segelzeichen", boote.get(key).segelzeichen);
			member.put("spi", boote.get(key).spi);
			member.put("tankgroesse", boote.get(key).tankgroesse);
			member.put("tiefgang", boote.get(key).tiefgang);
			member.put("typ", boote.get(key).typ);
			member.put("verdraengung", boote.get(key).verdraengung);
			member.put("versicherung", boote.get(key).versicherung);
			member.put("wassertankgroesse", boote.get(key).wassertankgroesse);
			member.put("yachtclub", boote.get(key).yachtclub);
			array.add(member);

		}
		json.put("Boote", array);
		PrintWriter pw = response.getWriter();
		pw.print(json.toString());
		pw.close();
		
		
		//DELETE BOAT
		String del = request.getParameter("wert");
		f.deleteBoot(del);
		
	}

	protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);

	}

	protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {

		processRequest(request, response);

	}

}
