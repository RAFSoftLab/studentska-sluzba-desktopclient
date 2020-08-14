package org.raflab.studsluzbadesktopclient.datamodel;

/**
 * 
 * Entiteti za tabelu - rezultat pretrage studenta
 * @author bojanads
 *
 */


public class StudentDTO {
	
	private Long id;
	private String ime;
	private String prezime;	
	private Integer godinaUpisa;
	private String studProgram;
	private Integer broj;
	
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
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	
	

}
