package org.raflab.studsluzbadesktopclient.datamodel;

public class NastavnaNaucnaZvanja {
	
	private Long id;
	private String zvanje;
	private String vrsta; // nastavno, saradnicko, naucno
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getZvanje() {
		return zvanje;
	}
	public void setZvanje(String zvanje) {
		this.zvanje = zvanje;
	}
	public String getVrsta() {
		return vrsta;
	}
	public void setVrsta(String vrsta) {
		this.vrsta = vrsta;
	}
	
	
	
	
}
