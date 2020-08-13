package org.raflab.studsluzbadesktopclient.datamodel;

public class StudentModel {
	
	// dodelju je samo jedan od sledeca dva polja
	
	private StudentIndeks studentIndeks;	
	
	
	public StudentModel(StudentIndeks studentIndeks) {
		this.studentIndeks = studentIndeks;
		
	}

	public StudentIndeks getStudentIndeks() {
		return studentIndeks;
	}

	public void setStudentIndeks(StudentIndeks studentIndeks) {
		this.studentIndeks = studentIndeks;
	}
	
	public String getIme() {
		return studentIndeks.getStudent().getIme();
	}
	
	public String getPrezime() {
		return studentIndeks.getStudent().getPrezime();
	}
	
	

}
