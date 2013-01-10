package backend;

public class Boot {

	private String registernr;
	private String bootsname;
	private String segelzeichen;
	private String heimathafen;
	private String yachtclub;
	private String eigner;
	private String versicherung;
	private String rufzeichen;
	private String typ;
	private String konstrukteur;
	private double laenge;
	private double breite;
	private double tiefgang;
	private double masthoehe;
	private double verdraengung;
	private String rigArt;
	private int baujahr;
	private String motor;
	private double tankgroesse;
	private double wassertankgroesse;
	private double abwassertankgroesse;
	private double grosssegelgroesse;
	private double genuagroesse;
	private double spi;
	
	
	
	
	
	public Boot(String registernr, String bootsname, String segelzeichen,
			String heimathafen, String yachtclub, String eigner,
			String versicherung, String rufzeichen, String typ,
			String konstrukteur, double laenge, double breite, double tiefgang,
			double masthoehe, double verdraengung, String rigArt, int baujahr,
			String motor, double tankgroesse, double wassertankgroesse,
			double abwassertankgroesse, double grosssegelgroesse,
			double genuagroesse, double spi) {
		super();
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
	public String getRegisternr() {
		return registernr;
	}
	public void setRegisternr(String registernr) {
		this.registernr = registernr;
	}
	public String getBootsname() {
		return bootsname;
	}
	public void setBootsname(String bootsname) {
		this.bootsname = bootsname;
	}
	public String getSegelzeichen() {
		return segelzeichen;
	}
	public void setSegelzeichen(String segelzeichen) {
		this.segelzeichen = segelzeichen;
	}
	public String getHeimathafen() {
		return heimathafen;
	}
	public void setHeimathafen(String heimathafen) {
		this.heimathafen = heimathafen;
	}
	public String getYachtclub() {
		return yachtclub;
	}
	public void setYachtclub(String yachtclub) {
		this.yachtclub = yachtclub;
	}
	public String getEigner() {
		return eigner;
	}
	public void setEigner(String eigner) {
		this.eigner = eigner;
	}
	public String getVersicherung() {
		return versicherung;
	}
	public void setVersicherung(String versicherung) {
		this.versicherung = versicherung;
	}
	public String getRufzeichen() {
		return rufzeichen;
	}
	public void setRufzeichen(String rufzeichen) {
		this.rufzeichen = rufzeichen;
	}
	public String getTyp() {
		return typ;
	}
	public void setTyp(String typ) {
		this.typ = typ;
	}
	public String getKonstrukteur() {
		return konstrukteur;
	}
	public void setKonstrukteur(String konstrukteur) {
		this.konstrukteur = konstrukteur;
	}
	public double getLaenge() {
		return laenge;
	}
	public void setLaenge(double laenge) {
		this.laenge = laenge;
	}
	public double getBreite() {
		return breite;
	}
	public void setBreite(double breite) {
		this.breite = breite;
	}
	public double getTiefgang() {
		return tiefgang;
	}
	public void setTiefgang(double tiefgang) {
		this.tiefgang = tiefgang;
	}
	public double getMasthoehe() {
		return masthoehe;
	}
	public void setMasthoehe(double masthoehe) {
		this.masthoehe = masthoehe;
	}
	public double getVerdraengung() {
		return verdraengung;
	}
	public void setVerdraengung(double verdraengung) {
		this.verdraengung = verdraengung;
	}
	public String getRigArt() {
		return rigArt;
	}
	public void setRigArt(String rigArt) {
		this.rigArt = rigArt;
	}
	public int getBaujahr() {
		return baujahr;
	}
	public void setBaujahr(int baujahr) {
		this.baujahr = baujahr;
	}
	public String getMotor() {
		return motor;
	}
	public void setMotor(String motor) {
		this.motor = motor;
	}
	public double getTankgroesse() {
		return tankgroesse;
	}
	public void setTankgroesse(double tankgroesse) {
		this.tankgroesse = tankgroesse;
	}
	public double getWassertankgroesse() {
		return wassertankgroesse;
	}
	public void setWassertankgroesse(double wassertankgroesse) {
		this.wassertankgroesse = wassertankgroesse;
	}
	public double getAbwassertankgroesse() {
		return abwassertankgroesse;
	}
	public void setAbwassertankgroesse(double abwassertankgroesse) {
		this.abwassertankgroesse = abwassertankgroesse;
	}
	public double getGrosssegelgroesse() {
		return grosssegelgroesse;
	}
	public void setGrosssegelgroesse(double grosssegelgroesse) {
		this.grosssegelgroesse = grosssegelgroesse;
	}
	public double getGenuagroesse() {
		return genuagroesse;
	}
	public void setGenuagroesse(double genuagroesse) {
		this.genuagroesse = genuagroesse;
	}
	public double getSpi() {
		return spi;
	}
	public void setSpi(double spi) {
		this.spi = spi;
	}
	
	
}
