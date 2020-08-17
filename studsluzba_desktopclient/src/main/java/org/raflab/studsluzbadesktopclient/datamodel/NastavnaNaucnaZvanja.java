package org.raflab.studsluzbadesktopclient.datamodel;

import org.raflab.studsluzbadesktopclient.coders.SimpleCode;

public class NastavnaNaucnaZvanja extends SimpleCode {
	
	public NastavnaNaucnaZvanja(String zvanje) {
		super(zvanje);
		this.zvanje = zvanje;
		// TODO Auto-generated constructor stub
	}
	
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
