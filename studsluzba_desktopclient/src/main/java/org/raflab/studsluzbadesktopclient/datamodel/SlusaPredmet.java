package org.raflab.studsluzbadesktopclient.datamodel;


public class SlusaPredmet {
	
	
	private Long id;	
	private DrziPredmet drziPredmet;
	private StudentIndeks studentIndeks;

	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	
	public DrziPredmet getDrziPredmet() {
		return drziPredmet;
	}
	public void setDrziPredmet(DrziPredmet drziPredmet) {
		this.drziPredmet = drziPredmet;
	}
	public StudentIndeks getStudentIndeks() {
		return studentIndeks;
	}
	public void setStudentIndeks(StudentIndeks studentIndeks) {
		this.studentIndeks = studentIndeks;
	}
	
	
	
	
	
	

}
