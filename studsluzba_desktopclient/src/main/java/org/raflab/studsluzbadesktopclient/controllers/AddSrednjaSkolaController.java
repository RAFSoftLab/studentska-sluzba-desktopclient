package org.raflab.studsluzbadesktopclient.controllers;

import java.util.List;

import org.raflab.studsluzbadesktopclient.coders.CoderFactory;
import org.raflab.studsluzbadesktopclient.coders.CoderType;
import org.raflab.studsluzbadesktopclient.coders.SimpleCode;
import org.raflab.studsluzbadesktopclient.datamodel.SrednjaSkola;
import org.raflab.studsluzbadesktopclient.servercalls.SifarniciServisConsumer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import javafx.fxml.FXML;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.scene.control.ComboBox;

@Component
public class AddSrednjaSkolaController {
	
	@Autowired
	CoderFactory coderFactory;
	
	@Autowired
	SifarniciServisConsumer serviceConsumer;
	
	@Autowired
	StudentPodaciController  studentpodaciController;

	@FXML TextField nazivNoveSrednjeSkoleTf;
	@FXML ComboBox<SimpleCode> mestoNoveSrednjeSkoleCb;
	@FXML ComboBox<SimpleCode> tipNoveSrednjeSkoleCb;
	
	
	
	@FXML public void addSrednjaSkola(ActionEvent event) {
		SrednjaSkola ss = new SrednjaSkola();
		if(mestoNoveSrednjeSkoleCb.getValue()!=null) ss.setMesto(mestoNoveSrednjeSkoleCb.getValue().getCode());
		ss.setNaziv(nazivNoveSrednjeSkoleTf.getText());
		if(tipNoveSrednjeSkoleCb.getValue()!=null) ss.setVrsta(tipNoveSrednjeSkoleCb.getValue().getCode());
		Long id = serviceConsumer.saveSrednjaSkola(ss);		
		studentpodaciController.updateSrednjeSkole();
		closeStage(event);
		
		
	}
	
	@FXML
    public void initialize() {		
		List<SimpleCode> tipSrednjeSkoleCodes = coderFactory.getSimpleCoder(CoderType.TIP_SREDNJE_SKOLE).getCodes();
		tipNoveSrednjeSkoleCb.setItems(FXCollections.observableArrayList(tipSrednjeSkoleCodes));
		List<SimpleCode> mestaCodes = coderFactory.getSimpleCoder(CoderType.MESTO).getCodes();
		mestoNoveSrednjeSkoleCb.setItems(FXCollections.observableArrayList(mestaCodes));
	}
	
	private void closeStage(ActionEvent event) {
        Node  source = (Node)  event.getSource(); 
        Stage stage  = (Stage) source.getScene().getWindow();
        stage.close();
    }
}
