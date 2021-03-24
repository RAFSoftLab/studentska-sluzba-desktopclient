package org.raflab.studsluzbadesktopclient.controllers;

import java.util.ArrayList;
import java.util.List;

import org.raflab.studsluzbadesktopclient.datamodel.PolozenPredmet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;

@Component
public class StudentProfilePolozeniPredmetiController {

	@Autowired
	StudentProfileController studentProfileController;
	
	@FXML TableView<PolozenPredmet> polozeniPredmetiTable;	
	
	@FXML Label ukupnoEspbLabel;
	
	@FXML ComboBox<String> vrstaCb;
	

	
	@FXML
    public void initialize() {		
		List<PolozenPredmet> polozeniPredmeti = studentProfileController.getStudentProfile().getPolozeniPredmeti();
		if(polozeniPredmeti==null) polozeniPredmeti = new ArrayList<>();
		polozeniPredmetiTable.setItems(FXCollections.observableArrayList(polozeniPredmeti));
		Integer sumaEspb = polozeniPredmeti.stream().mapToInt(PolozenPredmet::getEspb).sum();
		ukupnoEspbLabel.setText(String.valueOf(sumaEspb));
	
    }
	
	
	
	
	
}
