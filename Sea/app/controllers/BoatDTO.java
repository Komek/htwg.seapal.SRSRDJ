package controllers;

public class BoatDTO {

	public String registernr;
	public String bootsname;
	public String segelzeichen;
	public String heimathafen;
	public String yachtclub;
	public String eigner;
	public String versicherung;
	public String rufzeichen;
	public String typ;
	public String konstrukteur;
	public double laenge;
	public double breite;
	public double tiefgang;
	public double masthoehe;
	public double verdraengung;
	public String rigArt;
	public int baujahr;
	public String motor;
	public double tankgroesse;
	public double wassertankgroesse;
	public double abwassertankgroesse;
	public double grosssegelgroesse;
	public double genuagroesse;
	public double spi;

	public BoatDTO() {
		super();
	}

	public BoatDTO(String registernr, String bootsname, String segelzeichen,
			String heimathafen, String yachtclub, String eigner,
			String versicherung, String rufzeichen, String typ,
			String konstrukteur, double laenge, double breite, double tiefgang,
			double masthoehe, double verdraengung, String rigArt, int baujahr,
			String motor, double tankgroesse, double wassertankgroesse,
			double abwassertankgroesse, double grosssegelgroesse,
			double genuagroesse, double spi) {

		this.registernr = registernr;
		this.bootsname = bootsname;
		this.segelzeichen = segelzeichen;
		this.heimathafen = heimathafen;
		this.yachtclub = yachtclub;
		this.eigner = eigner;
		this.versicherung = versicherung;
		this.rufzeichen = rufzeichen;
		this.typ = typ;
		this.konstrukteur = konstrukteur;
		this.laenge = laenge;
		this.breite = breite;
		this.tiefgang = tiefgang;
		this.masthoehe = masthoehe;
		this.verdraengung = verdraengung;
		this.rigArt = rigArt;
		this.baujahr = baujahr;
		this.motor = motor;
		this.tankgroesse = tankgroesse;
		this.wassertankgroesse = wassertankgroesse;
		this.abwassertankgroesse = abwassertankgroesse;
		this.grosssegelgroesse = grosssegelgroesse;
		this.genuagroesse = genuagroesse;
		this.spi = spi;
	}

}
