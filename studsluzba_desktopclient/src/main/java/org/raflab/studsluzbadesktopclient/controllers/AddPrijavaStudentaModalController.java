package org.raflab.studsluzbadesktopclient.controllers;

import java.time.LocalDate;
import java.util.List;

import org.raflab.studsluzbadesktopclient.datamodel.Ispit;
import org.raflab.studsluzbadesktopclient.datamodel.PrijavaIspita;
import org.raflab.studsluzbadesktopclient.datamodel.StudentIndeks;
import org.raflab.studsluzbadesktopclient.servercalls.IspitiServiceConsumer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

@Component
public class AddPrijavaStudentaModalController {

	@FXML Label ispitLabel;
	@FXML TableView<StudentIndeks> studentiTable;
	
	@Autowired
	IspitiPrijaveController ispitiPrijaveController;
	
	@Autowired
	IspitiServiceConsumer ispitServiceConsumer;
	
	private Ispit selectedIspit;
	
	@FXML
	public void initialize() {
		selectedIspit = ispitiPrijaveController.getSelectedIspit();
		ispitLabel.setText(selectedIspit.toString());
		List<StudentIndeks> neprijavljeni = ispitServiceConsumer.getNeprijavljeniZaIspit(selectedIspit.getId());
		studentiTable.setItems(FXCollections.observableArrayList(neprijavljeni));
		studentiTable.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
	}

	@FXML public void handleDodajPrijavuStudenta(ActionEvent event) {
		List<StudentIndeks> zaDodavanje = studentiTable.getSelectionModel().getSelectedItems();
		for(StudentIndeks si:zaDodavanje) {
			PrijavaIspita pi = new PrijavaIspita();
			pi.setStudentIndeks(si);
			pi.setIspit(selectedIspit);
			pi.setDatumPrijave(LocalDate.now());
			ispitServiceConsumer.savePrijava(pi);
		}
		ispitiPrijaveController.loadData();
		closeStage(event);
	}
	
	private void closeStage(ActionEvent event) {
        Node  source = (Node)  event.getSource(); 
        Stage stage  = (Stage) source.getScene().getWindow();
        stage.close();
    }
	
}
