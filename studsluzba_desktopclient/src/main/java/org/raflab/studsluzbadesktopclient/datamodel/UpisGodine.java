package org.raflab.studsluzbadesktopclient.datamodel;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;


public class UpisGodine {
	
	private Long id;	
	
	private LocalDate datumUpisa;
	
	private int prenosEspb; // podrazumevano 0
	private int godinaKojaSeUpisuje;
	private List<Predmet> predmeti;
	
	private String napomena;
	
	private StudentIndeks studentIndeks;
	
	private SkolskaGodina skolskaGodina; 
	
	
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
	public List<Predmet> getPredmeti() {
		return predmeti;
	}
	public void setPredmeti(List<Predmet> predmeti) {
		this.predmeti = predmeti;
	}

	public String getNapomena() {
		return napomena;
	}
	public void setNapomena(String napomena) {
		this.napomena = napomena;
	}
	public StudentIndeks getStudentIndeks() {
		return studentIndeks;
	}
	public void setStudentIndeks(StudentIndeks studentIndeks) {
		this.studentIndeks = studentIndeks;
	}
	public SkolskaGodina getSkolskaGodina() {
		return skolskaGodina;
	}
	public void setSkolskaGodina(SkolskaGodina skolskaGodina) {
		this.skolskaGodina = skolskaGodina;
	}
	
	
	
	
	
	
	

}
