package org.raflab.studsluzbadesktopclient.controllers;

import java.time.LocalDate;

import org.springframework.stereotype.Component;

import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.control.TextArea;

@Component
public class StudentProfileUpisModalController {
	
	
	@FXML DatePicker datum;
	@FXML TextField godina;
	@FXML TextArea napomena;
	
	@FXML
    public void initialize() {		
		datum.setValue(LocalDate.now());
	}
	
	

}
