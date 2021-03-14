package org.raflab.studsluzbadesktopclient.controllers;

import java.util.List;

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
	
	
	public void openSearchStudent(ActionEvent event) {
		mainView.changeRoot("searchStudent");
	}
	
	public void openSearchNastavnik(ActionEvent event) {
		mainView.changeRoot("searchNastavnik");
	}
	
	public void openNewStudent(ActionEvent event) {		
		mainView.changeRoot("newStudent");
	}
	
	public void openNewNastavnik(ActionEvent event) {
		mainView.changeRoot("newNastavnik");
	}
	
	public void openSkolskaGodina(ActionEvent event) {
		mainView.changeRoot("skolskaGodina");
	}
	
	
	public void openRaspodelaNastave(ActionEvent event) {
		mainView.changeRoot("raspodelaNastave");
	}
	
	@FXML
	public void onEnter(ActionEvent ae){
		StudentIndeks studentIndeks = studentServiceConsumer.fastSearchByIndeks(fastSearchTf.getText());
		if(studentIndeks == null)
			fastSearchError.setText("Student nije pronađen");
		else {
			fastSearchError.setText("");	
			StudentProfileDTO studentProfile = studentServiceConsumer.getStudentProfile(studentIndeks.getId());
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
