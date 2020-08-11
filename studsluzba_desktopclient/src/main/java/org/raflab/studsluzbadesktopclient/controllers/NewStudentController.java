package org.raflab.studsluzbadesktopclient.controllers;

import org.raflab.studsluzba_desktopclient.datamodel.StudentPodaci;
import org.raflab.studsluzbadesktopclient.servercalls.StudentServerCalls;
import org.raflab.studsluzbadesktopclient.servercalls.StudentServiceConsumer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

@Component
public class NewStudentController {
	
	@Autowired
	StudentServiceConsumer serviceConsumer;
	
	@FXML private TextField imeTf;
	@FXML private TextField prezimeTf;
	@FXML private TextField jmbgTf;
	@FXML private DatePicker datumRodjenjaDp;
	
	
	public void handleSaveStudent(ActionEvent event) {
		StudentPodaci sp = new StudentPodaci();
		sp.setIme(imeTf.getText());
		sp.setPrezime(prezimeTf.getText());
		String response = serviceConsumer.saveStudent(sp);
		
		System.out.println(response);
		
	}
}
