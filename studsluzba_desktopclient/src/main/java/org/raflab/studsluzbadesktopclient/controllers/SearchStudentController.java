 package org.raflab.studsluzbadesktopclient.controllers;

import java.util.List;

import org.raflab.studsluzbadesktopclient.MainView;
import org.raflab.studsluzbadesktopclient.coders.CoderFactory;
import org.raflab.studsluzbadesktopclient.coders.CoderType;
import org.raflab.studsluzbadesktopclient.coders.SimpleCode;
import org.raflab.studsluzbadesktopclient.datamodel.StudentDTO;
import org.raflab.studsluzbadesktopclient.datamodel.StudentIndeks;
import org.raflab.studsluzbadesktopclient.datamodel.StudentPodaci;
import org.raflab.studsluzbadesktopclient.datamodel.StudentProfileDTO;
import org.raflab.studsluzbadesktopclient.servercalls.SifarniciServiceConsumer;
import org.raflab.studsluzbadesktopclient.servercalls.StudentServiceConsumer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

@Component
public class SearchStudentController {
	
	@Autowired
	StudentServiceConsumer serviceConsumer;
	
	
	@Autowired	
	SifarniciServiceConsumer codersServiceConsumer;
	
	@Autowired
	StudentProfileController studentProfileController;
	
	@Autowired
	StudentPodaciController studentPodaciController;
	
	@Autowired
	CoderFactory coderFactory;
	
		
	@Autowired
	MainView mainView;
	
	@FXML TextField imeTf;
	@FXML TextField prezimeTf;
	@FXML TextField godinaUpisaTf;
	@FXML ComboBox<SimpleCode> studProgramCb;
	@FXML TextField brojIndeksaTf;
	
	
	@FXML TableView<StudentDTO> studentiTable;
	
	
	
		
	public void handleSearchStudent(ActionEvent ae) {
		
		// TODO dodati validaciju za brojeve
		
		List<StudentDTO> rez = serviceConsumer.searchStudent(imeTf.getText().equals("") ? null : imeTf.getText(), 
									  prezimeTf.getText().equals("") ? null : prezimeTf.getText(), 
									  godinaUpisaTf.getText().equals("") ? null : Integer.parseInt(godinaUpisaTf.getText()),
									  studProgramCb.getValue()==null ? null : studProgramCb.getValue().getCode(),
									  brojIndeksaTf.getText().equals("") ? null :Integer.parseInt(brojIndeksaTf.getText()));
		studentiTable.setItems(FXCollections.observableArrayList(rez));
		
	}
	
	public void handleOpenProfile(ActionEvent ae) {
		StudentDTO selected = studentiTable.getSelectionModel().getSelectedItem();
		StudentProfileDTO studentProfile;
		if(selected.getGodinaUpisa() == null || selected.getGodinaUpisa()==0) { // nema indeksa
			StudentPodaci sp = serviceConsumer.getStudentById(selected.getIdStudentPodaci());
			StudentIndeks si = new StudentIndeks();  // pravi se prazan indeks da bi se otvorio dosije, prilikom prvog upisa
			si.setStudent(sp);
			studentProfile = new StudentProfileDTO(si);
		}else {			
			studentProfile = serviceConsumer.getStudentProfileForIndeksId(selected.getIdIndeks());
			
		}
		
		studentProfileController.setStudentProfile(studentProfile);
		mainView.changeRoot("studentProfilePodaci");		
		
		
	}
	
	@FXML
    public void initialize() {		
		List<SimpleCode> studProgramiCodes = coderFactory.getSimpleCoder(CoderType.STUDIJSKI_PROGRAM).getCodes();
		studProgramCb.setItems(FXCollections.observableArrayList(studProgramiCodes));
    }

	@FXML public void handleOpenPodaci() {
		StudentDTO selected = studentiTable.getSelectionModel().getSelectedItem();		
		StudentPodaci sp = serviceConsumer.getStudentById(selected.getIdStudentPodaci());		
		studentPodaciController.setStudentPodaci(sp);
		mainView.changeRoot("studentPodaci");
		
	}
	
	
	
	
	
	
	

}
