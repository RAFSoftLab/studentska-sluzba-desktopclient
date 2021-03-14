package org.raflab.studsluzbadesktopclient.controllers;


import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.raflab.studsluzbadesktopclient.MainView;
import org.raflab.studsluzbadesktopclient.datamodel.ObnovaGodine;
import org.raflab.studsluzbadesktopclient.datamodel.TokStudija;
import org.raflab.studsluzbadesktopclient.datamodel.UpisGodine;
import org.raflab.studsluzbadesktopclient.utils.EntityMappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

@Component
public class StudentProfileUpisObnovaController {
	
	@Autowired
	StudentProfileController studentProfileController;
	
	@FXML TableView<TokStudija> tokStudijaTable;
	
	
	
	@Autowired
	MainView mainView;
	
	ObservableList<TokStudija> tokStudijaItems;
	
	


	@FXML
    public void initialize() {		
		List<UpisGodine> upisi = studentProfileController.getStudentProfile().getUpisiGodine();
		List<ObnovaGodine> obnove = studentProfileController.getStudentProfile().getObnoveGodine();
		tokStudijaItems = FXCollections.observableArrayList();
		tokStudijaItems.addAll(upisi.stream().map(EntityMappers::toTokStudija).collect(Collectors.toList()));
		tokStudijaItems.addAll(obnove.stream().map(EntityMappers::toTokStudija).collect(Collectors.toList()));
		
		Collections.sort(tokStudijaItems, (ts1, ts2)->ts1.getDatum().isAfter(ts2.getDatum()) ? 1 : -1);
		tokStudijaTable.setItems(tokStudijaItems);	
		
    }
	
	public void handleOpenUpisModal(ActionEvent event) {
		mainView.openModal("studentProfileUpisModal", "Upis godine", 500, 500);
		
	}
	
	public void handleOpenObnovaModal(ActionEvent event) {
		mainView.openModal("studentProfileObnovaModal", "Obnova godine", 500, 500);
		
	}
	
	public void addUpisGodine(UpisGodine ug) {
		tokStudijaItems.add(EntityMappers.toTokStudija(ug));
		
	}
	
	public void addObnovaGodine(ObnovaGodine og) {
		tokStudijaItems.add(EntityMappers.toTokStudija(og));
		
	}
	
	
	

}
