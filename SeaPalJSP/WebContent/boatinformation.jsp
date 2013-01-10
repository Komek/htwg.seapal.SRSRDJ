<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="fassade.BootDTO"%>
<%@ page import="fassade.Fassade_Boatinfo"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<%
		Fassade_Boatinfo f = new Fassade_Boatinfo();
		BootDTO bootDTO = new BootDTO();

		bootDTO.registernr = request.getParameter("registernr");
		bootDTO.bootsname = request.getParameter("bootsname");
		bootDTO.segelzeichen = request.getParameter("segelzeichen");
		bootDTO.heimathafen = request.getParameter("heimathafen");
		bootDTO.yachtclub = request.getParameter("yachtclub");
		bootDTO.eigner = request.getParameter("eigner");
		bootDTO.versicherung = request.getParameter("versicherung");
		bootDTO.rufzeichen = request.getParameter("rufzeichen");
		bootDTO.typ = request.getParameter("typ");
		bootDTO.konstrukteur = request.getParameter("konstrukteur");
		bootDTO.rigArt = request.getParameter("rigArt");
		bootDTO.motor = request.getParameter("motor");

		if (!(request.getParameter("abwassertankgroesse").isEmpty())) {
			bootDTO.abwassertankgroesse = Double.parseDouble(request
					.getParameter("abwassertankgroesse"));
		}
		if (!(request.getParameter("baujahr").isEmpty())) {
			bootDTO.baujahr = Integer.parseInt(request
					.getParameter("baujahr"));
		}
		if (!(request.getParameter("breite").isEmpty())) {
			bootDTO.breite = Double.parseDouble(request
					.getParameter("breite"));
		}
		if (!(request.getParameter("laenge").isEmpty())) {
			bootDTO.laenge = Double.parseDouble(request
					.getParameter("laenge"));
		}
		if (!(request.getParameter("tiefgang").isEmpty())) {
			bootDTO.tiefgang = Double.parseDouble(request
					.getParameter("tiefgang"));
		}
		if (!(request.getParameter("masthoehe").isEmpty())) {
			bootDTO.masthoehe = Double.parseDouble(request
					.getParameter("masthoehe"));
		}
		if (!(request.getParameter("verdraengung").isEmpty())) {
			bootDTO.verdraengung = Double.parseDouble(request
					.getParameter("verdraengung"));
		}
		if (!(request.getParameter("tankgroesse").isEmpty())) {
			bootDTO.tankgroesse = Double.parseDouble(request
					.getParameter("tankgroesse"));
		}
		if (!(request.getParameter("wassertankgroesse").isEmpty())) {
			bootDTO.wassertankgroesse = Double.parseDouble(request
					.getParameter("wassertankgroesse"));
		}
		if (!(request.getParameter("grosssegelgroesse").isEmpty())) {
			bootDTO.grosssegelgroesse = Double.parseDouble(request
					.getParameter("grosssegelgroesse"));
		}
		if (!(request.getParameter("genuagroesse").isEmpty())) {
			bootDTO.genuagroesse = Double.parseDouble(request
					.getParameter("genuagroesse"));
		}
		if (!(request.getParameter("spi").isEmpty())) {
			bootDTO.spi = Double.parseDouble(request.getParameter("spi"));
		}
		f.saveBoot(bootDTO);
	%>

</body>
</html>