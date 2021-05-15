package org.raflab.studsluzbadesktopclient.datamodel;

import java.time.LocalDate;
import java.util.List;

public class StudentIndeks{
	
	
	private Long id;
	private int broj;
	private int godina;
	private String studProgramOznaka;  
	private boolean aktivan; // aktivan
	private LocalDate vaziOd;
	private StudentPodaci student;
	private StudijskiProgram studijskiProgram;   // na koji studijski program je upisan
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getBroj() {
		return broj;
	}

	public void setBroj(int broj) {
		this.broj = broj;
	}

	public int getGodina() {
		return godina;
	}

	public void setGodina(int godina) {
		this.godina = godina;
	}

	

	public String getStudProgramOznaka() {
		return studProgramOznaka;
	}

	public void setStudProgramOznaka(String studProgramOznaka) {
		this.studProgramOznaka = studProgramOznaka;
	}

	public boolean isAktivan() {
		return aktivan;
	}

	public void setAktivan(boolean aktivan) {
		this.aktivan = aktivan;
	}

	public LocalDate getVaziOd() {
		return vaziOd;
	}

	public void setVaziOd(LocalDate vaziOd) {
		this.vaziOd = vaziOd;
	}

	public StudentPodaci getStudent() {
		return student;
	}

	public void setStudent(StudentPodaci student) {
		this.student = student;
	}

	public String getImeIPrezime() {
		return student.getIme() + " " + student.getPrezime();
	}
	
	@Override
	public String toString() {
		return "StudentIndeks [id=" + id + ", broj=" + broj + ", godina=" + godina + ", studProgram=" + studProgramOznaka
				+ ", aktivan=" + aktivan + ", vaziOd=" + vaziOd + ", student=" + student + "]";
	}
	
	public String getStatus() {
		if(!aktivan) return "neaktivan";
		return "";
	}

	public StudijskiProgram getStudijskiProgram() {
		return studijskiProgram;
	}

	public void setStudijskiProgram(StudijskiProgram studijskiProgram) {
		this.studijskiProgram = studijskiProgram;
		this.studProgramOznaka = studijskiProgram.getOznaka();
	}
	

}
