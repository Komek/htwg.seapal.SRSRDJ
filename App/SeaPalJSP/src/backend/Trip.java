package backend;

public class Trip {

	private String title;
	private String von;
	private String nach;
	private String skipper;
	private String crew;
	private String start;
	private String ende;
	private int dauer;
	private int motor;
	private int tankgefuellt=0;
	private String notes;
	private String registernr;
	

	public Trip(String title, String von, String nach, String skipper,
			String crew, String start, String ende, int dauer, int motor,
			int tankgefuellt, String notes, String registernr) {
		super();
		this.title = title;
		this.von = von;
		this.nach = nach;
		this.skipper = skipper;
		this.crew = crew;
		this.start = start;
		this.ende = ende;
		this.dauer = dauer;
		this.motor = motor;
		this.tankgefuellt = tankgefuellt;
		this.notes = notes;
		this.registernr = registernr;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getVon() {
		return von;
	}
	public void setVon(String von) {
		this.von = von;
	}
	public String getNach() {
		return nach;
	}
	public void setNach(String nach) {
		this.nach = nach;
	}
	public String getSkipper() {
		return skipper;
	}
	public void setSkipper(String skipper) {
		this.skipper = skipper;
	}
	public String getCrew() {
		return crew;
	}
	public void setCrew(String crew) {
		this.crew = crew;
	}
	public String getStart() {
		return start;
	}
	public void setStart(String start) {
		this.start = start;
	}
	public String getEnde() {
		return ende;
	}
	public void setEnde(String ende) {
		this.ende = ende;
	}
	public int getDauer() {
		return dauer;
	}
	public void setDauer(int dauer) {
		this.dauer = dauer;
	}
	public int getMotor() {
		return motor;
	}
	public void setMotor(int motor) {
		this.motor = motor;
	}
	public int getTankgefuellt() {
		return tankgefuellt;
	}
	public void setTankgefuellt(int tankgefuellt) {
		this.tankgefuellt = tankgefuellt;
	}
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
	public String getRegisternr() {
		return registernr;
	}
	public void setRegisternr(String registernr) {
		this.registernr = registernr;
	}
	
	
}
