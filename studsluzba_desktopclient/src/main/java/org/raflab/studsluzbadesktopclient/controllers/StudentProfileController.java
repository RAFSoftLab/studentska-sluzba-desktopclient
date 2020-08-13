package org.raflab.studsluzbadesktopclient.controllers;

import org.raflab.studsluzbadesktopclient.datamodel.StudentIndeks;
import org.raflab.studsluzbadesktopclient.datamodel.StudentModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

@Component
public class StudentProfileController {
	
	@FXML private Label studentInfoLabel;
	
	private StudentModel studentModel;	
	
	
	public void setStudentModel(StudentModel studentModel) {
		this.studentModel = studentModel;
	}
	
	public void resetProfile() {		
		String text = "Profil studenta: "+studentModel.getIme()+" "+studentModel.getPrezime();
		studentInfoLabel.setText(text);
	}
	
	
	
	
}
