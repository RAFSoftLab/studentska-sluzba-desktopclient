 package org.raflab.studsluzbadesktopclient.controllers;

import java.util.List;

import org.raflab.studsluzbadesktopclient.MainView;
import org.raflab.studsluzbadesktopclient.coders.CoderFactory;
import org.raflab.studsluzbadesktopclient.coders.CoderType;
import org.raflab.studsluzbadesktopclient.coders.SimpleCode;
import org.raflab.studsluzbadesktopclient.datamodel.Nastavnik;
import org.raflab.studsluzbadesktopclient.servercalls.NastavnikServiceConsumer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

@Component
public class SearchNastavnikController {
	
	@Autowired
	NastavnikServiceConsumer serviceConsumer;
	
//	@Autowired
//	NastavnikProfileController nastavnikProfileController;
	
	@Autowired
	CoderFactory coderFactory;
	
		
	@Autowired
	MainView mainView;
	
	@FXML TextField imeTf;
	@FXML TextField prezimeTf;
	
	
	@FXML TableView<Nastavnik> nastavniciTable;
	
	
	
		
	public void handleSearchNastavnik(ActionEvent ae) {
		
		// TODO dodati validaciju za brojeve
		
		List<Nastavnik> rez = serviceConsumer.searchNastavnik(imeTf.getText().equals("") ? null : imeTf.getText(), 
									  prezimeTf.getText().equals("") ? null : prezimeTf.getText() );
		nastavniciTable.setItems(FXCollections.observableArrayList(rez));
		
	}
	
	public void handleOpenProfile(ActionEvent ae) {
		// TODO TBD
		
	}
	
	@FXML
    public void initialize() {		
		// TODO TBD
    }
	
	
	
	
	

}
