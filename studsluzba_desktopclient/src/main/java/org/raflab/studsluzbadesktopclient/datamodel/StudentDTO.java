package org.raflab.studsluzbadesktopclient.datamodel;

/**
 * 
 * Entiteti za tabelu sa rezultatima pretrage
 * @author bojanads
 *
 */


public class StudentDTO {
	
	private Long idIndeks;
	private Long idStudentPodaci;
	// dodati jos nesto?
	private String ime;
	private String prezime; 
	// indeks
	private int godinaUpisa;
	private String studProgram;
	private int broj;
	
	
	
	
	public Long getIdIndeks() {
		return idIndeks;
	}
	public void setIdIndeks(Long idIndeks) {
		this.idIndeks = idIndeks;
	}
	public Long getIdStudentPodaci() {
		return idStudentPodaci;
	}
	public void setIdStudentPodaci(Long idStudentPodaci) {
		this.idStudentPodaci = idStudentPodaci;
	}
	
	public String getIme() {
		return ime;
	}
	public void setIme(String ime) {
		this.ime = ime;
	}
	public String getPrezime() {
		return prezime;
	}
	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}
	public Integer getGodinaUpisa() {
		return godinaUpisa;
	}
	public void setGodinaUpisa(Integer godinaUpisa) {
		this.godinaUpisa = godinaUpisa;
	}
	public String getStudProgram() {
		return studProgram;
	}
	public void setStudProgram(String studProgram) {
		this.studProgram = studProgram;
	}
	public Integer getBroj() {
		return broj;
	}
	public void setBroj(Integer broj) {
		this.broj = broj;
	}
	
	
	
	

}
