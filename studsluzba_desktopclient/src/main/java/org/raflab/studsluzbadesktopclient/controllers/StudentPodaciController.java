package org.raflab.studsluzbadesktopclient.controllers;

import java.util.List;

import org.raflab.studsluzbadesktopclient.coders.CoderFactory;
import org.raflab.studsluzbadesktopclient.coders.CoderType;
import org.raflab.studsluzbadesktopclient.coders.SimpleCode;
import org.raflab.studsluzbadesktopclient.datamodel.StudentPodaci;
import org.raflab.studsluzbadesktopclient.servercalls.StudentServiceConsumer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.text.Text;

@Component
public class StudentPodaciController {
	
	@Autowired
	StudentServiceConsumer serviceConsumer;
	
	@Autowired
	CoderFactory coderFactory;
	
	// forma ce se koristiti za unos novog i za azuriranje postojeceg studenta
	private StudentPodaci studentPodaci;

	
	@FXML private TextField imeTf;
	@FXML private TextField prezimeTf;
	@FXML private TextField srednjeImeTf;
	@FXML private TextField jmbgTf;
	@FXML private DatePicker datumRodjenjaDp;
	@FXML private Text actionTarget;
	
	@FXML private TextField emailTf;
	
	
	@FXML TextField brojTelefonaTf;
	@FXML TextField adresaPrebivalistaTf;
	@FXML TextField mestoPrebivalistaTf;
	@FXML TextField adresaStanovanjaTf;
	@FXML TextField mestoStanovanjaTf;
	@FXML TextField mestoRodjenjaTf;

	@FXML ComboBox<SimpleCode> drzavaRodjenjaCb;
	
	
	public void handleSaveStudent(ActionEvent event) {
		if(studentPodaci == null)
			studentPodaci = new StudentPodaci();
		studentPodaci.setIme(imeTf.getText());
		studentPodaci.setPrezime(prezimeTf.getText());
		studentPodaci.setSrednjeIme(srednjeImeTf.getText());
		studentPodaci.setDatumRodjenja(datumRodjenjaDp.getValue());
		try {
			Long id = serviceConsumer.saveStudent(studentPodaci);
			if(id!=null) {
				System.out.println(id);
				actionTarget.setText("Student sačuvan");	
				studentPodaci.setId(id);
			}else {
				actionTarget.setText("Došlo je do greške, podaci nisu sačuvani");
			}
		}catch(Exception e) {
			// TODO log
			e.printStackTrace();
			actionTarget.setText("Došlo je do greške, podaci nisu sačuvani");
		}	
	}
	
	@FXML
    public void initialize() {		
		List<SimpleCode> drzavaCodes = coderFactory.getSimpleCoder(CoderType.DRZAVA).getCodes();
		drzavaRodjenjaCb.setItems(FXCollections.observableArrayList(drzavaCodes));
		drzavaRodjenjaCb.setValue(new SimpleCode("Republika Srbija"));
    }
}
