package controllers;

import java.util.HashMap;
import play.*;
import play.data.*;
import play.mvc.*;
import views.html.*;

import views.html.*;

public class Application extends Controller {

	public static Result boatinformation() {
		return ok(boatinformation.render());
	}

	public static Result table() {
		String html;
		Access acc = new Access();
		HashMap<String, BoatDTO> map = acc.getBoats();
		html = "<table class='table1'><thead><tr><th>Registernr.</th><th>Bootsname</th><th>Eigner</th><th>Typ</th><th>Baujahr</th><th>Trip</th></tr></thead><tfoot>"
				+ "<tr><td><input type='button' onclick='delete_entry();' value='Ausgewaehlten Eintrag Loeschen'/></td></tr></tfoot><tbody>";
		for (String key : map.keySet()) {
			BoatDTO tmp = map.get(key);
			html = html
					+ "<tr class='row'  class='row' onclick='set_values(this);'>"
					+ "<td>"
					+ tmp.registernr
					+ "</td>"
					+ "<td>"
					+ tmp.bootsname
					+ "</td>"
					+ "<td>"
					+ tmp.eigner
					+ "</td>"
					+ "<td>"
					+ tmp.typ
					+ "</td>"
					+ "<td>"
					+ tmp.baujahr
					+ "</td>"
					+ "<td style='display:none'>"
					+ tmp.segelzeichen
					+ "</td>"
					+ "<td style='display:none'>"
					+ tmp.heimathafen
					+ "</td>"
					+ "<td style='display:none'>"
					+ tmp.yachtclub
					+ "</td>"
					+ "<td style='display:none'>"
					+ tmp.versicherung
					+ "</td>"
					+ "<td style='display:none'>"
					+ tmp.rufzeichen
					+ "</td>"
					+ "<td style='display:none'>"
					+ tmp.konstrukteur
					+ "</td>"
					+ "<td style='display:none'>"
					+ tmp.laenge
					+ "</td>"
					+ "<td style='display:none'>"
					+ tmp.breite
					+ "</td>"
					+ "<td style='display:none'>"
					+ tmp.tiefgang
					+ "</td>"
					+ "<td style='display:none'>"
					+ tmp.masthoehe
					+ "</td>"
					+ "<td style='display:none'>"
					+ tmp.verdraengung
					+ "</td>"
					+ "<td style='display:none'>"
					+ tmp.rigArt
					+ "</td>"
					+ "<td style='display:none'>"
					+ tmp.motor
					+ "</td>"
					+ "<td style='display:none'>"
					+ tmp.tankgroesse
					+ "</td>"
					+ "<td style='display:none'>"
					+ tmp.wassertankgroesse
					+ "</td>"
					+ "<td style='display:none'>"
					+ tmp.abwassertankgroesse
					+ "</td>"
					+ "<td style='display:none'>"
					+ tmp.grosssegelgroesse
					+ "</td>"
					+ "<td style='display:none'>"
					+ tmp.genuagroesse
					+ "</td>"
					+ "<td style='display:none'>"
					+ tmp.spi
					+ "</td>"
					+ "<td><a style='text-decoration:none' href='http://localhost:8080/SeapalJSP/TripList.jsp?registernr="
					+ tmp.registernr
					+ "'><input type='button' value='Zu den Trips'/></a></td></tr>";
		}
		html = html + "</tbody></table>";
		return ok(html);
	}

	public static Result sendBoat() {
		DynamicForm form = new DynamicForm();
		form = form.bindFromRequest();
		BoatDTO tmp = new BoatDTO();
		tmp.bootsname = form.get("bootsname");
		tmp.registernr = form.get("registernr");
		tmp.segelzeichen = form.get("segelzeichen");
		tmp.heimathafen = form.get("heimathafen");
		tmp.yachtclub = form.get("yachtclub");
		tmp.eigner = form.get("eigner");
		tmp.versicherung = form.get("versicherung");
		tmp.rufzeichen = form.get("rufzeichen");
		tmp.typ = form.get("typ");
		tmp.konstrukteur = form.get("konstrukteur");
		if (!form.get("laenge").isEmpty()) {
			tmp.laenge = Double.parseDouble(form.get("laenge"));
		} else {
			tmp.laenge = 0.0;
		}
		if (!form.get("breite").isEmpty()) {
			tmp.breite = Double.parseDouble(form.get("breite"));
		} else {
			tmp.breite = 0.0;
		}
		if (!form.get("tiefgang").isEmpty()) {
			tmp.tiefgang = Double.parseDouble(form.get("tiefgang"));
		} else {
			tmp.tiefgang = 0.0;
		}
		if (!form.get("masthoehe").isEmpty()) {
			tmp.masthoehe = Double.parseDouble(form.get("masthoehe"));
		} else {
			tmp.masthoehe = 0.0;
		}
		if (!form.get("verdraengung").isEmpty()) {
			tmp.verdraengung = Double.parseDouble(form.get("verdraengung"));
		} else {
			tmp.verdraengung = 0.0;
		}
		tmp.rigArt = form.get("rigArt");
		if (!form.get("baujahr").isEmpty()) {
			tmp.baujahr = Integer.parseInt(form.get("baujahr"));
		} else {
			tmp.baujahr = 0;
		}
		tmp.motor = form.get("motor");
		if (!form.get("tankgroesse").isEmpty()) {
			tmp.tankgroesse = Double.parseDouble(form.get("tankgroesse"));
		} else {
			tmp.tankgroesse = 0.0;
		}
		if (!form.get("wassertankgroesse").isEmpty()) {
			tmp.wassertankgroesse = Double.parseDouble(form
					.get("wassertankgroesse"));
		} else {
			tmp.wassertankgroesse = 0.0;
		}
		if (!form.get("abwassertankgroesse").isEmpty()) {
			tmp.abwassertankgroesse = Double.parseDouble(form
					.get("abwassertankgroesse"));
		} else {
			tmp.abwassertankgroesse = 0.0;
		}
		if (!form.get("grosssegelgroesse").isEmpty()) {
			tmp.grosssegelgroesse = Double.parseDouble(form
					.get("grosssegelgroesse"));
		} else {
			tmp.grosssegelgroesse = 0.0;
		}
		if (!form.get("genuagroesse").isEmpty()) {
			tmp.genuagroesse = Double.parseDouble(form.get("genuagroesse"));
		} else {
			tmp.genuagroesse = 0.0;
		}
		if (!form.get("spi").isEmpty()) {
			tmp.spi = Double.parseDouble(form.get("spi"));
		} else {
			tmp.spi = 0.0;
		}
		Access acc = new Access();
		acc.sendBoat(tmp);
		return ok();
	}

	public static Result deleteBoat(String key) {
		
		System.out.println(key);
		Access acc = new Access();
		acc.deleteBoat(key);
		return ok();

	}

}