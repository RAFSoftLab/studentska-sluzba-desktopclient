package org.raflab.studsluzbadesktopclient.datamodel;

import java.time.LocalDate;
import java.util.Set;


public class UpisGodine {
	
	private Long id;	
	
	private LocalDate datumUpisa;
	
	private int prenosEspb; // podrazumevano 0
	private int godinaKojaSeUpisuje;
	private Set<Predmet> predmeti;
	
	private String napomena;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public LocalDate getDatumUpisa() {
		return datumUpisa;
	}
	public void setDatumUpisa(LocalDate datumUpisa) {
		this.datumUpisa = datumUpisa;
	}
	public int getPrenosEspb() {
		return prenosEspb;
	}
	public void setPrenosEspb(int prenosEspb) {
		this.prenosEspb = prenosEspb;
	}
	public int getGodinaKojaSeUpisuje() {
		return godinaKojaSeUpisuje;
	}
	public void setGodinaKojaSeUpisuje(int godinaKojaSeUpisuje) {
		this.godinaKojaSeUpisuje = godinaKojaSeUpisuje;
	}
	public Set<Predmet> getPredmeti() {
		return predmeti;
	}
	public void setPredmeti(Set<Predmet> predmeti) {
		this.predmeti = predmeti;
	}

	public String getNapomena() {
		return napomena;
	}
	public void setNapomena(String napomena) {
		this.napomena = napomena;
	}
	
	
	
	
	

}
