package org.raflab.studsluzbadesktopclient.controllers;

import java.util.List;


import org.raflab.studsluzbadesktopclient.coders.CoderFactory;
import org.raflab.studsluzbadesktopclient.coders.CoderType;
import org.raflab.studsluzbadesktopclient.coders.SimpleCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

@Component
public class AddIndeksModalController {
	
	@Autowired
	private StudentProfileController studentProfileController;
	
	@Autowired
	private CoderFactory coderFactory;
	
	
	@FXML private TextField brojIndeksaTf;
	@FXML private ComboBox<SimpleCode> studijskiProgramCb;
	@FXML private TextField  godinaUpisaTf;
	
	
	public void setIndeks(ActionEvent event) {
		studentProfileController.postaviIndeks(
				Integer.parseInt(brojIndeksaTf.getText()), studijskiProgramCb.getValue().getCode(), Integer.parseInt(godinaUpisaTf.getText()));
		closeStage(event);
	}
	
	@FXML
	 public void initialize() {		
		List<SimpleCode> studProgramiCodes = coderFactory.getSimpleCoder(CoderType.STUDIJSKI_PROGRAM).getCodes();
		studijskiProgramCb.setItems(FXCollections.observableArrayList(studProgramiCodes));
    }
	
	private void closeStage(ActionEvent event) {
        Node  source = (Node)  event.getSource(); 
        Stage stage  = (Stage) source.getScene().getWindow();
        stage.close();
    }
}
