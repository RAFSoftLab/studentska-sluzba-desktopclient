package org.raflab.studsluzba_desktopclient.controllers;

import org.raflab.studsluzba_desktopclient.App;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.MenuBar;

public class MenuBarController {
	@FXML
	private MenuBar menuBar;
	
	public void openSearchStudent(ActionEvent event) {
		App.setRoot("searchStudent");
	}
	
	public void openSearchNastavnik(ActionEvent event) {
		App.setRoot("searchNastavnik");
	}
	
	public void openNewStudent(ActionEvent event) {
		App.setRoot("newStudent");
	}
}
