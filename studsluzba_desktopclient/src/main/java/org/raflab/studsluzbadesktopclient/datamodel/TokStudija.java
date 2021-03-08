package org.raflab.studsluzbadesktopclient.datamodel;

import java.time.LocalDate;

/*
 * Koristi se kao objedinjeni model za upise i 
 * obnove godina da se prikažu u jednoj tabeli
 * 
 */

public class TokStudija {
	
	private String vrsta; // upis/obnova
	private LocalDate datum;
	private int godina;  // koju upisuje ili obnavlja
	private String napomena;
	private UpisGodine upis;  // jedno od ova dva će biti null
	private ObnovaGodine obnova; //
	
	public TokStudija() {	
	}
	
	public TokStudija(String vrsta, LocalDate datum, int godina, String napomena) {
		super();
		this.vrsta = vrsta;
		this.datum = datum;
		this.godina = godina;
		this.napomena = napomena;		
	}
	
	public String getVrsta() {
		return vrsta;
	}
	public void setVrsta(String vrsta) {
		this.vrsta = vrsta;
	}
	public LocalDate getDatum() {
		return datum;
	}
	public void setDatum(LocalDate datum) {
		this.datum = datum;
	}
	public int getGodina() {
		return godina;
	}
	public void setGodina(int godina) {
		this.godina = godina;
	}
	public String getNapomena() {
		return napomena;
	}
	public void setNapomena(String napomena) {
		this.napomena = napomena;
	}
	public UpisGodine getUpis() {
		return upis;
	}
	public void setUpis(UpisGodine upis) {
		this.upis = upis;
	}
	public ObnovaGodine getObnova() {
		return obnova;
	}
	public void setObnova(ObnovaGodine obnova) {
		this.obnova = obnova;
	}
	
	
	
	
	
}
