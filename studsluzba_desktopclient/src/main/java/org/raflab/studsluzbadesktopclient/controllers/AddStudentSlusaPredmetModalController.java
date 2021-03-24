package org.raflab.studsluzbadesktopclient.controllers;

import java.util.List;

import org.raflab.studsluzbadesktopclient.datamodel.DrziPredmet;
import org.raflab.studsluzbadesktopclient.datamodel.SlusaPredmet;
import org.raflab.studsluzbadesktopclient.datamodel.StudentIndeks;
import org.raflab.studsluzbadesktopclient.servercalls.RaspodelaNastaveServiceConsumer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.SelectionMode;

@Component
public class AddStudentSlusaPredmetModalController {

	@Autowired
	RaspodelaNastaveStudentiController raspodelaNastaveStudentController;
	
	@Autowired
	RaspodelaNastaveServiceConsumer raspodelaNastaveServiceConsumer;
	
	@FXML TableView<StudentIndeks> studentiTable;
	
	@FXML Label drziPredmetLabel;
	
	private DrziPredmet selectedDrziPredmet;
	
	@FXML
	public void initialize() {		
		studentiTable.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
		selectedDrziPredmet = raspodelaNastaveStudentController.getSelectedDrziPredmet();
		drziPredmetLabel.setText("Dodavanje studenata za "+selectedDrziPredmet);
		List<StudentIndeks> studenti = raspodelaNastaveServiceConsumer.getNeSlusaPredmetForDrziPredmet(selectedDrziPredmet.getId());
		studentiTable.setItems(FXCollections.observableArrayList(studenti));
	}

	public void handleDodajStudentSlusaPredmet(ActionEvent ae) {
		List<StudentIndeks> selektovani = studentiTable.getSelectionModel().getSelectedItems();
		for(StudentIndeks si : selektovani) {
			SlusaPredmet sp = new SlusaPredmet();
			sp.setDrziPredmet(selectedDrziPredmet);
			sp.setStudentIndeks(si);
			raspodelaNastaveServiceConsumer.saveSlusaPredmet(sp);
		}
		raspodelaNastaveStudentController.loadData();
		closeStage(ae);
		
		
	}
	
	private void closeStage(ActionEvent event) {
        Node  source = (Node)  event.getSource(); 
        Stage stage  = (Stage) source.getScene().getWindow();
        stage.close();
    }
	

}
