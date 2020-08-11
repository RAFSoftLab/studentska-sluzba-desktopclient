package org.raflab.studsluzbadesktopclient.controllers;

import org.raflab.studsluzbadesktopclient.MainView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.MenuBar;

@Component
public class MenuBarController { 
	
	 
	@Autowired
	private MainView mainView;
	
	
	@FXML
	private MenuBar menuBar;
	
	public void openSearchStudent(ActionEvent event) {
		mainView.changeRoot("searchStudent");
	}
	
	public void openSearchNastavnik(ActionEvent event) {
		mainView.changeRoot("searchNastavnik");
	}
	
	public void openNewStudent(ActionEvent event) {		
		mainView.changeRoot("newStudent");
	}
}
