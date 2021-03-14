package org.raflab.studsluzbadesktopclient.controllers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;

import org.raflab.studsluzbadesktopclient.datamodel.DrziPredmet;
import org.raflab.studsluzbadesktopclient.datamodel.Nastavnik;
import org.raflab.studsluzbadesktopclient.datamodel.Predmet;
import org.raflab.studsluzbadesktopclient.datamodel.SkolskaGodina;
import org.raflab.studsluzbadesktopclient.datamodel.StudijskiProgram;
import org.raflab.studsluzbadesktopclient.servercalls.NastavnikServiceConsumer;
import org.raflab.studsluzbadesktopclient.servercalls.PredmetServiceConsumer;
import org.raflab.studsluzbadesktopclient.servercalls.RaspodelaNastaveServiceConsumer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.event.ActionEvent;

@Component
public class RaspodelaNastaveController {
	
	@Autowired
	RaspodelaNastaveServiceConsumer raspodelaNastaveServiceConsumer;
	
	@Autowired
	PredmetServiceConsumer predmetServieConsumer;
	
	@Autowired
	NastavnikServiceConsumer nastavnikServiceConsumer;
	
	@Autowired
	SkolskaGodina aktivnaSkolskaGodina;
	
	
	@FXML TableView<DrziPredmet> raspodelaNastaveTable;
	
	@FXML ComboBox<String> studProgramiCb;
	
	@FXML TextField filterTableTf;
	
	@FXML ListView<Nastavnik> nastavniciLV;
	
	@FXML ListView<Predmet> predmetiLV;
	
	@FXML TextField filterPredmetiTf;
	
	
	private List<DrziPredmet> drziPredmetList;
	
	private List<Predmet> sviPredmeti;
	
	private List<Nastavnik> sviNastavnici;
	
	@FXML
	public void initialize() {
		
		refreshFormData();		
		nastavniciLV.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
		predmetiLV.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);		
	}
	
	private void refreshFormData() {		
		drziPredmetList = raspodelaNastaveServiceConsumer.getDrziPredmetUAktivnojSkolskojGodini();
		raspodelaNastaveTable.setItems(FXCollections.observableArrayList(drziPredmetList));
		Set<String> studProgrami = new HashSet<>();
		drziPredmetList.stream().forEach(e -> studProgrami.add(e.getPredmet().getStudProgram().getOznaka()));
		studProgrami.add("Svi");
		studProgramiCb.setItems(FXCollections.observableArrayList(new ArrayList(studProgrami)));		
		filterTableTf.setText("");
		studProgramiCb.setValue("Svi");
		sviNastavnici = nastavnikServiceConsumer.getAllNastavnik();
		sviPredmeti = predmetServieConsumer.getAllPredmet();
		nastavniciLV.setItems(FXCollections.observableArrayList(sviNastavnici));
		predmetiLV.setItems(FXCollections.observableArrayList(sviPredmeti));
		
		
	}
	
	public void filterTable() {
		List<DrziPredmet> drziPredmetNewList = new ArrayList<>();
		String studProgramSelected = studProgramiCb.getValue();
		String filterText = filterTableTf.getText().toLowerCase();
		boolean filterStudProgram = studProgramSelected!=null && !studProgramSelected.equals("Svi") ;		
		drziPredmetList.stream().forEach(e -> { 
				if(!filterStudProgram || e.getPredmet().getStudProgram().getOznaka().equals(studProgramSelected)) {
					if(filterText.equals("") || e.getPredmet().toString().toLowerCase().contains(filterText) 
							|| e.getNastavnik().toString().toLowerCase().contains(filterText))
						drziPredmetNewList.add(e);
				}
		});	
		raspodelaNastaveTable.setItems(FXCollections.observableArrayList(drziPredmetNewList));
	}

	@FXML public void filterPredmetiList(KeyEvent event) {
		List<Predmet> predmetNewList = new ArrayList<>();
		sviPredmeti.stream().forEach(e -> {
			if(e.toString().toLowerCase().contains(filterPredmetiTf.getText().toLowerCase()))
				predmetNewList.add(e);
		});
		predmetiLV.setItems(FXCollections.observableArrayList(predmetNewList));
		
	}

	@FXML public void handleSacuvaj(ActionEvent event) {
		List<Predmet> selektovaniPredmeti = predmetiLV.getSelectionModel().getSelectedItems();
		List<Nastavnik> selektovaniNastavnici = nastavniciLV.getSelectionModel().getSelectedItems();
		for(Predmet p:selektovaniPredmeti) {
			for(Nastavnik n:selektovaniNastavnici) {
				DrziPredmet dp = new DrziPredmet(n,p, aktivnaSkolskaGodina);
				if(!drziPredmetList.contains(dp)) {
					raspodelaNastaveServiceConsumer.saveDrziPredmet(dp);
				}
			}
		}
		refreshFormData();
		
	}

	@FXML public void handleTableKeyPressed(KeyEvent event) {
		if(event.getCode() == KeyCode.DELETE) {
			Long id = raspodelaNastaveTable.getSelectionModel().getSelectedItem().getId();
			raspodelaNastaveServiceConsumer.deleteDrziPredmet(id);
			refreshFormData();
		}
	}
		
		
	
	
	

}
