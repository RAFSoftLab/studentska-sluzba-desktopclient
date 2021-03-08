package org.raflab.studsluzbadesktopclient.datamodel;



import java.time.LocalDate;
import java.util.Set;


public class Ispit {
	

	private Long id;
	private LocalDate datumOdrzavanja;    // i vreme
	private String mestoOdrzavanja;  // ne mora da se unosi
	
	private boolean zakljucen = false;

	private DrziPredmet drziPredmet;

	private IspitniRok ispitniRok;

	private Set<PrijavaIspita> prijave;
	
	public LocalDate getDatumOdrzavanja() {
		return datumOdrzavanja;
	}
	public void setDatumOdrzavanja(LocalDate datumOdrzavanja) {
		this.datumOdrzavanja = datumOdrzavanja;
	}
	public String getMestoOdrzavanja() {
		return mestoOdrzavanja;
	}
	public void setMestoOdrzavanja(String mestoOdrzavanja) {
		this.mestoOdrzavanja = mestoOdrzavanja;
	}
	public boolean isZakljucen() {
		return zakljucen;
	}
	public void setZakljucen(boolean zakljucen) {
		this.zakljucen = zakljucen;
	}
		
	public IspitniRok getIspitniRok() {
		return ispitniRok;
	}
	public void setIspitniRok(IspitniRok ispitniRok) {
		this.ispitniRok = ispitniRok;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Set<PrijavaIspita> getPrijave() {
		return prijave;
	}
	public void setPrijave(Set<PrijavaIspita> prijave) {
		this.prijave = prijave;
	}
	
	
	
	
}
