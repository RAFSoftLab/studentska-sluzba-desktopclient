package org.raflab.studsluzbadesktopclient.controllers;

import java.util.ArrayList;
import java.util.List;

import org.raflab.studsluzbadesktopclient.MainView;
import org.raflab.studsluzbadesktopclient.datamodel.DrziPredmet;
import org.raflab.studsluzbadesktopclient.datamodel.Predmet;
import org.raflab.studsluzbadesktopclient.datamodel.SkolskaGodina;
import org.raflab.studsluzbadesktopclient.datamodel.StudentIndeks;
import org.raflab.studsluzbadesktopclient.servercalls.RaspodelaNastaveServiceConsumer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;

@Component
public class RaspodelaNastaveStudentiController {
	
	@Autowired
	MainView mainView;
	
	@Autowired
	RaspodelaNastaveServiceConsumer raspodelaNastaveServiceConsumer;
	
	@Autowired
	SkolskaGodina aktivnaSkolskaGodina;
	
	
	@FXML TableView<DrziPredmet> drziPredmetTable;
	
	@FXML TextField filterTableTf;
	
	@FXML TableView<StudentIndeks> studentiTable;
	
	private List<DrziPredmet> drziPredmetList;
	
	@FXML
	public void initialize() {
		drziPredmetList = raspodelaNastaveServiceConsumer.getDrziPredmetUAktivnojSkolskojGodini();
		drziPredmetTable.setItems(FXCollections.observableArrayList(drziPredmetList));
		
		drziPredmetTable.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<DrziPredmet>() {

			@Override
			public void changed(ObservableValue<? extends DrziPredmet> observable, DrziPredmet oldValue, DrziPredmet newValue) {
				if(newValue!=null) {
					List<StudentIndeks> studentiSlusaju = raspodelaNastaveServiceConsumer.getSlusaPredmetForDrziPredmet(newValue.getId());
					studentiTable.setItems(FXCollections.observableArrayList(studentiSlusaju));
				}
			}		
		});
	}
	
	public void filterTable() {
		List<DrziPredmet> drziPredmetNewList = new ArrayList<>();		
		String filterText = filterTableTf.getText().toLowerCase();		
		drziPredmetList.stream().forEach(e -> {				
				if(filterText.equals("") || e.getPredmet().toString().toLowerCase().contains(filterText) 
						|| e.getNastavnik().toString().toLowerCase().contains(filterText))
					drziPredmetNewList.add(e);
				
		});	
		drziPredmetTable.setItems(FXCollections.observableArrayList(drziPredmetNewList));
	}

	public void handleOpenDodajStudentaModal() {
		mainView.openModal("addStudentSlusaPredmetModal","Dodavanje studenta",600,400);
	}

	public DrziPredmet getSelectedDrziPredmet() {
		return drziPredmetTable.getSelectionModel().getSelectedItem();
	}
	
	public void loadData() {		
		List<StudentIndeks> studentiSlusaju = raspodelaNastaveServiceConsumer.getSlusaPredmetForDrziPredmet(drziPredmetTable.getSelectionModel().getSelectedItem().getId());
		studentiTable.setItems(FXCollections.observableArrayList(studentiSlusaju));
		studentiTable.refresh();
	}
	
	
}
