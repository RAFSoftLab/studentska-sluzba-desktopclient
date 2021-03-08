package org.raflab.studsluzbadesktopclient.datamodel;

import java.time.LocalDate;
import java.util.Set;



public class ObnovaGodine {
	

	private Long id;
	
	private int godinaKojuObnavlja;	

	private Set<Predmet> upisujePredmete;
	
	private LocalDate datumObnove;	
	
	private String napomena;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public int getGodinaKojuObnavlja() {
		return godinaKojuObnavlja;
	}
	public void setGodinaKojuObnavlja(int godinaKojuObnavlja) {
		this.godinaKojuObnavlja = godinaKojuObnavlja;
	}
	public Set<Predmet> getUpisujePredmete() {
		return upisujePredmete;
	}
	public void setUpisujePredmete(Set<Predmet> upisujePredmete) {
		this.upisujePredmete = upisujePredmete;
	}	
	
	public LocalDate getDatumObnove() {
		return datumObnove;
	}
	public void setDatumObnove(LocalDate datumObnove) {
		this.datumObnove = datumObnove;
	}
	public String getNapomena() {
		return napomena;
	}
	public void setNapomena(String napomena) {
		this.napomena = napomena;
	}
	
	
	
}
