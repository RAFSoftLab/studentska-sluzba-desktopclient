package org.raflab.studsluzbadesktopclient.controllers;

import org.raflab.studsluzbadesktopclient.datamodel.StudentPodaci;
import org.raflab.studsluzbadesktopclient.servercalls.StudentServiceConsumer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.text.Text;

@Component
public class NewStudentController {
	
	@Autowired
	private StudentServiceConsumer serviceConsumer;
	
	@FXML private TextField imeTf;
	@FXML private TextField prezimeTf;
	@FXML private TextField srednjeImeTf;
	@FXML private TextField jmbgTf;
	@FXML private DatePicker datumRodjenjaDp;
	@FXML private Text actionTarget;
	
	
	public void handleSaveStudent(ActionEvent event) {
		StudentPodaci sp = new StudentPodaci();
		sp.setIme(imeTf.getText());
		sp.setPrezime(prezimeTf.getText());
		sp.setSrednjeIme(srednjeImeTf.getText());
		sp.setDatumRodjenja(datumRodjenjaDp.getValue());
		String response = serviceConsumer.saveStudent(sp);
		actionTarget.setText(response);
		
		
	}
}
