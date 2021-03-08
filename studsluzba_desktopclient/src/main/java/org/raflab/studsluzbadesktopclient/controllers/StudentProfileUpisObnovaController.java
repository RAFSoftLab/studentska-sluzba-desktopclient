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
import javafx.scene.control.TableView;

@Component
public class StudentProfileUpisObnovaController {
	
	@Autowired
	StudentProfileController studentProfileController;
	
	@FXML TableView<TokStudija> tokStudijaTable;
	
	@Autowired
	MainView mainView;


	@FXML
    public void initialize() {		
		List<UpisGodine> upisi = studentProfileController.getStudentProfile().getUpisiGodine();
		List<ObnovaGodine> obnove = studentProfileController.getStudentProfile().getObnoveGodine();
		ObservableList<TokStudija> tokStudijaItems = FXCollections.observableArrayList();
		tokStudijaItems.addAll(upisi.stream().map(EntityMappers::toTokStudija).collect(Collectors.toList()));
		tokStudijaItems.addAll(obnove.stream().map(EntityMappers::toTokStudija).collect(Collectors.toList()));
		
		Collections.sort(tokStudijaItems, (ts1, ts2)->ts1.getDatum().isAfter(ts2.getDatum()) ? 1 : -1);
		tokStudijaTable.setItems(tokStudijaItems);	
    }
	
	public void handleOpenUpisModal(ActionEvent e) {
		mainView.openModal("studentProfileUpisModal", "Upis godine", 500, 500);
		
	}
	
	

}
