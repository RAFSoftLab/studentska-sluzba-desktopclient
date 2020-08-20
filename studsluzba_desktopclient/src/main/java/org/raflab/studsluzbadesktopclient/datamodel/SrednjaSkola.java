package org.raflab.studsluzbadesktopclient.datamodel;




public class SrednjaSkola {
	
	
	private Long id;
	private String naziv;
	private String mesto;
	private String vrsta;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNaziv() {
		return naziv;
	}
	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}
	public String getMesto() {
		return mesto;
	}
	public void setMesto(String mesto) {
		this.mesto = mesto;
	}
	public String getVrsta() {
		return vrsta;
	}
	public void setVrsta(String vrsta) {
		this.vrsta = vrsta;
	}
	@Override
	public String toString() {	
		return naziv+", "+mesto;
	}
	
	
}
