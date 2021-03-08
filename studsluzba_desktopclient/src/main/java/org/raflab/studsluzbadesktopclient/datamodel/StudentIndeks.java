package org.raflab.studsluzbadesktopclient.datamodel;

import java.time.LocalDate;
import java.util.List;

public class StudentIndeks{
	
	
	private Long id;
	private int broj;
	private int godina;
	private String studProgram;
	private boolean aktivan; // aktivan
	private LocalDate vaziOd;
	private StudentPodaci student;
	
	
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

	public String getStudProgram() {
		return studProgram;
	}

	public void setStudProgram(String studProgram) {
		this.studProgram = studProgram;
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

	
	
	@Override
	public String toString() {
		return "StudentIndeks [id=" + id + ", broj=" + broj + ", godina=" + godina + ", studProgram=" + studProgram
				+ ", aktivan=" + aktivan + ", vaziOd=" + vaziOd + ", student=" + student + "]";
	}
	

}
