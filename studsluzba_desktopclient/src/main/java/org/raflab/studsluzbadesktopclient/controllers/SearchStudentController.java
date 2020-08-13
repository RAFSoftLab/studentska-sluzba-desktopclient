package org.raflab.studsluzbadesktopclient.controllers;

import java.util.List;

import org.raflab.studsluzbadesktopclient.MainView;
import org.raflab.studsluzbadesktopclient.datamodel.StudentDTO;
import org.raflab.studsluzbadesktopclient.datamodel.StudentIndeks;
import org.raflab.studsluzbadesktopclient.datamodel.StudentModel;
import org.raflab.studsluzbadesktopclient.datamodel.StudentPodaci;
import org.raflab.studsluzbadesktopclient.servercalls.StudentServiceConsumer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

@Component
public class SearchStudentController {
	
	@Autowired
	private StudentServiceConsumer serviceConsumer;
	
	@Autowired
	StudentProfileController studentProfileController;
	
	@Autowired
	MainView mainView;
	
	@FXML TextField imeTf;
	@FXML TextField prezimeTf;
	@FXML TextField godinaUpisaTf;
	@FXML ComboBox<String> studProgramCb;
	@FXML TextField brojIndeksaTf;
	
	
	@FXML TableView<StudentDTO> studentiTable;
	
		
	public void handleSearchStudent(ActionEvent ae) {
		
		// TODO dodati validaciju za brojeve
		
		List<StudentDTO> rez = serviceConsumer.searchStudent(imeTf.getText().equals("") ? null : imeTf.getText(), 
									  prezimeTf.getText().equals("") ? null : prezimeTf.getText(), 
									  godinaUpisaTf.getText().equals("") ? null : Integer.parseInt(godinaUpisaTf.getText()),
									  studProgramCb.getValue(),
									  brojIndeksaTf.getText().equals("") ? null :Integer.parseInt(brojIndeksaTf.getText()));
		studentiTable.setItems(FXCollections.observableArrayList(rez));
		
	}
	
	public void handleOpenProfile(ActionEvent ae) {
		StudentDTO selected = studentiTable.getSelectionModel().getSelectedItem();
		StudentIndeks si;
		if(selected.getGodinaUpisa() == null || selected.getGodinaUpisa()==0) { // nema indeksa
			StudentPodaci sp = serviceConsumer.getStudentById(selected.getId());
			si = new StudentIndeks();  // pravi se prazan indeks da bi se otvorio dosije
			si.setStudent(sp);
		}else {
			si = serviceConsumer.getIndeksById(selected.getId());			
		}
		
		studentProfileController.setStudentModel(new StudentModel(si));
		mainView.changeRoot("studentProfile");
		studentProfileController.resetProfile();
		
		
	}
	
	
	/*
	@FXML TableColumn<StudentDTO, String> imeColumn;
	@FXML TableColumn<StudentDTO, String> prezimeColumn;
	@FXML TableColumn<StudentDTO, Integer> godinaUpisaColumn;
	@FXML TableColumn<StudentDTO, String> studProgramColumn;
	@FXML TableColumn<StudentDTO, Integer> brojColumn;
	*/
	

}
