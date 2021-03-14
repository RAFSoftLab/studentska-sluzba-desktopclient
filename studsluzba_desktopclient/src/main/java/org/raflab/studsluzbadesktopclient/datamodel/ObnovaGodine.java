package org.raflab.studsluzbadesktopclient.datamodel;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;



public class ObnovaGodine {
	

	private Long id;
	
	private StudentIndeks studentIndeks;
	
	private int godinaKojuObnavlja;	

	private List<Predmet> upisujePredmete;
	
	private LocalDate datumObnove;	
	
	private String napomena;
	
	private SkolskaGodina skolskaGodina;
	
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
	public List<Predmet> getUpisujePredmete() {
		return upisujePredmete;
	}
	public void setUpisujePredmete(List<Predmet> upisujePredmete) {
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
	public SkolskaGodina getSkolskaGodina() {
		return skolskaGodina;
	}
	public void setSkolskaGodina(SkolskaGodina skolskaGodina) {
		this.skolskaGodina = skolskaGodina;
	}
	public StudentIndeks getStudentIndeks() {
		return studentIndeks;
	}
	public void setStudentIndeks(StudentIndeks studentIndeks) {
		this.studentIndeks = studentIndeks;
	}
	
	
	
}
