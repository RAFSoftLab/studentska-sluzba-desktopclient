package org.raflab.studsluzbadesktopclient.controllers;

import org.raflab.studsluzbadesktopclient.MainView;
import org.raflab.studsluzbadesktopclient.coders.CoderType;
import org.raflab.studsluzbadesktopclient.coders.SimpleCode;
import org.raflab.studsluzbadesktopclient.datamodel.SkolskaGodina;
import org.raflab.studsluzbadesktopclient.datamodel.StudentIndeks;
import org.raflab.studsluzbadesktopclient.datamodel.StudentProfileDTO;
import org.raflab.studsluzbadesktopclient.servercalls.StudentServiceConsumer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jfoenix.controls.JFXTextField;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.MenuBar;

@Component
public class MenuBarController { 
	
	 
	@Autowired
	MainView mainView;
	
	@Autowired
	StudentServiceConsumer studentServiceConsumer; 
	
	@Autowired
	StudentProfileController studentProfileController;
	
		
	@FXML
	private MenuBar menuBar;
	
	@FXML 
	private JFXTextField fastSearchTf;
	@FXML
	private Label fastSearchError;
	
	@FXML
	private Label aktivnaSkolskaGodinaLabel;
	
	@Autowired
	SkolskaGodina aktivnaSkolskaGodina;
	
	@Autowired
	StudentPodaciController studentPodaciController;
	
	
	public void openSearchStudent() {
		mainView.changeRoot("searchStudent");
	}
	
	public void openSearchNastavnik() {
		mainView.changeRoot("searchNastavnik");
	}
	
	public void openNewStudent() {	
		studentPodaciController.setStudentPodaci(null);
		mainView.changeRoot("studentPodaci");
	}
	
	public void openNewNastavnik() {
		mainView.changeRoot("newNastavnik");
	}
	
	public void openSkolskeGodine() {
		mainView.changeRoot("skolskeGodine");
	}
	
	
	public void openRaspodelaNastave() {
		mainView.changeRoot("raspodelaNastave");
	}
	
	public void openIspitniRokovi() {
		mainView.changeRoot("ispitniRokovi");
	}
	
	public void openIspitiUnos() {
		mainView.changeRoot("ispitiUnos");
	}
	
	public void openIspitiPrijave() {
		mainView.changeRoot("ispitiPrijave");
	}
	
	public void openIspitiRezultati() {
		mainView.changeRoot("ispitiRezultati");
	}
	
	@FXML public void openRaspodelaNastaveStudenti() {
		mainView.changeRoot("raspodelaNastaveStudenti");
	}
	
	@FXML
	public void onEnter(ActionEvent ae){
		StudentIndeks studentIndeks = studentServiceConsumer.fastSearchByIndeks(fastSearchTf.getText());
		if(studentIndeks == null)
			fastSearchError.setText("Student nije pronađen");
		else {
			fastSearchError.setText("");	
			StudentProfileDTO studentProfile = studentServiceConsumer.getStudentProfileForIndeksId(studentIndeks.getId());
			studentProfileController.setStudentProfile(studentProfile);
			mainView.changeRoot("studentProfilePodaci");			
		}
	}
	
	public void handleFastSearch(ActionEvent ae) {
		onEnter(ae);
	}
	

	@FXML
    public void initialize() {		
		aktivnaSkolskaGodinaLabel.setText("Aktivna sk. god: "+aktivnaSkolskaGodina.getPocetna()+"/"+aktivnaSkolskaGodina.getKrajnja());
    }

	
		
}
