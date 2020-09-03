package org.raflab.studsluzbadesktopclient.controllers;

import org.raflab.studsluzbadesktopclient.MainView;
import org.raflab.studsluzbadesktopclient.datamodel.StudentIndeks;
import org.raflab.studsluzbadesktopclient.datamodel.StudentModel;
import org.raflab.studsluzbadesktopclient.servercalls.StudentServiceConsumer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jfoenix.controls.JFXTextField;

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
	
	@FXML
	public void onEnter(ActionEvent ae){
		StudentIndeks studentIndeks = studentServiceConsumer.fastSearchByIndeks(fastSearchTf.getText());
		if(studentIndeks == null)
			fastSearchError.setText("Student nije pronađen");
		else {
			fastSearchError.setText("");	
			studentProfileController.setStudentModel(new StudentModel(studentIndeks));
			mainView.changeRoot("studentProfile");
			studentProfileController.resetProfile();
		}
	}
	
	public void handleFastSearch(ActionEvent ae) {
		onEnter(ae);
	}
	
		
}
