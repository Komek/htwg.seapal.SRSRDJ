package fu.client;

import java.io.Serializable;

public class BoatDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	public String registernr = "";
	public String bootsname = "";
	public String segelzeichen = "";
	public String heimathafen = "";
	public String yachtclub = "";
	public String eigner = "";
	public String versicherung = "";
	public String rufzeichen = "";
	public String typ = "";
	public String konstrukteur = "";
	public double laenge = 0.0;
	public double breite = 0.0;
	public double tiefgang = 0.0;
	public double masthoehe = 0.0;
	public double verdraengung = 0.0;
	public String rigart = "";
	public int baujahr = 0;
	public String motor = "";
	public int tankgroesse = 0;
	public int wassertankgroesse = 0;
	public int abwassertankgroesse = 0;
	public double grosssegelgroesse = 0.0;
	public double genaugroesse = 0.0;
	public double spi = 0.0;

	public void setValues(Form form) {
		String[] doublevaluesString = { form.laengeBox.getValue(),
				form.breiteBox.getValue(), form.tiefgangBox.getValue(),
				form.masthoehBox.getValue(), form.verdraengungBox.getValue(),
				form.grosssegelgroesseBox.getValue(), form.genuaBox.getValue(),
				form.spiBox.getValue() };
		double[] doublevalues = new double[8];
		String[] intValuesString = { form.baujahrBox.getValue(),
				form.tankgroesseBox.getValue(),
				form.wassertankgroesseBox.getValue(),
				form.abwassertankgroesseBox.getValue() };
		int[] intvalues = new int[4];
		for (int i = 0; i < doublevaluesString.length; i++) {
			if (doublevaluesString[i] == "") {
				doublevalues[i] = 0.0;
			} else {
				doublevalues[i] = Double.parseDouble(doublevaluesString[i]);
			}
		}
		for (int i = 0; i < intValuesString.length; i++) {
			if (intValuesString[i] == "") {
				intvalues[i] = 0;
			} else {
				intvalues[i] = Integer.parseInt(intValuesString[i]);
			}
		}
		this.laenge = doublevalues[0];
		this.breite = doublevalues[1];
		this.tiefgang = doublevalues[2];
		this.masthoehe = doublevalues[3];
		this.verdraengung = doublevalues[4];
		this.grosssegelgroesse = doublevalues[5];
		this.genaugroesse = doublevalues[6];
		this.spi = doublevalues[7];
		this.baujahr = intvalues[0];
		this.tankgroesse = intvalues[1];
		this.wassertankgroesse = intvalues[2];
		this.abwassertankgroesse = intvalues[3];
		this.registernr = form.registernrBox.getValue();
		this.bootsname = form.bootsnameBox.getValue();
		this.segelzeichen = form.segelzeichenBox.getValue();
		this.heimathafen = form.heimathafenBox.getValue();
		this.yachtclub = form.yachtclubBox.getValue();
		this.eigner = form.eignerBox.getValue();
		this.versicherung = form.versicherungBox.getValue();
		this.rufzeichen = form.rufzeichenBox.getValue();
		this.typ = form.typBox.getValue();
		this.konstrukteur = form.konstrukteurBox.getValue();
		this.rigart = form.rigartBox.getValue();
		this.motor = form.motorBox.getValue();
	}
}
