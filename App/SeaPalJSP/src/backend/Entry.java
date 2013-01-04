package backend;

import java.util.GregorianCalendar;

public class Entry {

	private String name;
	private int ngrad;
	private int nmin;
	private int nsec;
	private int egrad;
	private int emin;
	private int esec;
	private double cog;
	private double sog;
	private int btm;
	private double dtm;
	private String fahrtNach;
	private String manoever;
	private String vorsegel;
	private String grosssegel;
	private String notes;
	private GregorianCalendar time;
	private String triptitle;
	
	
	
	
	public Entry(String name, int ngrad, int nmin, int nsec, int egrad,
			int emin, int esec, double cog, double sog, int btm, double dtm,
			String fahrtNach, String manoever, String vorsegel,
			String grosssegel, String notes, GregorianCalendar time,
			String triptitle) {
		super();
		this.name = name;
		this.ngrad = ngrad;
		this.nmin = nmin;
		this.nsec = nsec;
		this.egrad = egrad;
		this.emin = emin;
		this.esec = esec;
		this.cog = cog;
		this.sog = sog;
		this.btm = btm;
		this.dtm = dtm;
		this.fahrtNach = fahrtNach;
		this.manoever = manoever;
		this.vorsegel = vorsegel;
		this.grosssegel = grosssegel;
		this.notes = notes;
		this.time = time;
		this.triptitle = triptitle;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getNgrad() {
		return ngrad;
	}
	public void setNgrad(int ngrad) {
		this.ngrad = ngrad;
	}
	public int getNmin() {
		return nmin;
	}
	public void setNmin(int nmin) {
		this.nmin = nmin;
	}
	public int getNsec() {
		return nsec;
	}
	public void setNsec(int nsec) {
		this.nsec = nsec;
	}
	public int getEgrad() {
		return egrad;
	}
	public void setEgrad(int egrad) {
		this.egrad = egrad;
	}
	public int getEmin() {
		return emin;
	}
	public void setEmin(int emin) {
		this.emin = emin;
	}
	public int getEsec() {
		return esec;
	}
	public void setEsec(int esec) {
		this.esec = esec;
	}
	public double getCog() {
		return cog;
	}
	public void setCog(double cog) {
		this.cog = cog;
	}
	public double getSog() {
		return sog;
	}
	public void setSog(double sog) {
		this.sog = sog;
	}
	public int getBtm() {
		return btm;
	}
	public void setBtm(int btm) {
		this.btm = btm;
	}
	public double getDtm() {
		return dtm;
	}
	public void setDtm(double dtm) {
		this.dtm = dtm;
	}
	public String getFahrtNach() {
		return fahrtNach;
	}
	public void setFahrtNach(String fahrtNach) {
		this.fahrtNach = fahrtNach;
	}
	public String getManoever() {
		return manoever;
	}
	public void setManoever(String manoever) {
		this.manoever = manoever;
	}
	public String getVorsegel() {
		return vorsegel;
	}
	public void setVorsegel(String vorsegel) {
		this.vorsegel = vorsegel;
	}
	public String getGrosssegel() {
		return grosssegel;
	}
	public void setGrosssegel(String grosssegel) {
		this.grosssegel = grosssegel;
	}
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
	public GregorianCalendar getTime() {
		return time;
	}
	public void setTime(GregorianCalendar time) {
		this.time = time;
	}
	public String getTriptitle() {
		return triptitle;
	}
	public void setTriptitle(String triptitle) {
		this.triptitle = triptitle;
	}
	
}
