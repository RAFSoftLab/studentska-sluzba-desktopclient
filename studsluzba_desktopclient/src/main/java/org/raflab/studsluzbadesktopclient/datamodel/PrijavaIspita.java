package org.raflab.studsluzbadesktopclient.datamodel;

import java.time.LocalDate;

public class PrijavaIspita {
	

	private Long id;
	private LocalDate datumPrijave;
	private StudentIndeks studentIndeks;	
	private Ispit ispit;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public LocalDate getDatumPrijave() {
		return datumPrijave;
	}
	public void setDatumPrijave(LocalDate datumPrijave) {
		this.datumPrijave = datumPrijave;
	}
	
	public Ispit getIspit() {
		return ispit;
	}
	public void setIspit(Ispit ispit) {
		this.ispit = ispit;
	}
	public StudentIndeks getStudentIndeks() {
		return studentIndeks;
	}
	public void setStudentIndeks(StudentIndeks studentIndeks) {
		this.studentIndeks = studentIndeks;
	}
	
	
	
	
	
	

}
