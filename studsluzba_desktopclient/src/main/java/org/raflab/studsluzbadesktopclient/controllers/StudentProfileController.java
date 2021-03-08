package org.raflab.studsluzbadesktopclient.controllers;

import org.raflab.studsluzbadesktopclient.MainView;
import org.raflab.studsluzbadesktopclient.datamodel.PolozenPredmet;
import org.raflab.studsluzbadesktopclient.datamodel.Predmet;
import org.raflab.studsluzbadesktopclient.datamodel.StudentIndeks;
import org.raflab.studsluzbadesktopclient.datamodel.StudentProfileDTO;
import org.raflab.studsluzbadesktopclient.servercalls.StudentServiceConsumer;
import org.raflab.studsluzbadesktopclient.utils.IndeksFormater;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;

@Component
public class StudentProfileController {
	

	@Autowired
	MainView mainView;
	
	@Autowired
	StudentServiceConsumer studentService;
	
	@FXML private BorderPane studentProfilePane;
	
	@FXML private Text studentPodaciText;
	
	
	

	
	private StudentProfileDTO studentProfile;
	
	@FXML Label imeIPrezimeLabel;

	@FXML Label jmbgLabel;

	@FXML Label mestoPrebivalistaLabel;

	@FXML Label datumRodjenjaLabel;

	@FXML Label adresaLabel;
	
	@FXML Label emailLabel;	

	@FXML Label brojTelefonaLabel;
	
	
	
	
	
	public void setStudentProfile(StudentProfileDTO studentProfile) {
		this.studentProfile = studentProfile;
	}
	
		
	public void postaviIndeks(int broj, String studProgram, int godina) {
		StudentIndeks studIndeks = studentProfile.getAktivanIndeks();
		studIndeks.setAktivan(true);
		studIndeks.setBroj(broj);
		studIndeks.setStudProgram(studProgram);
		studIndeks.setGodina(godina);
		Long id = studentService.saveStudentIndeks(studIndeks);
		studIndeks.setId(id);
		
	}
	
	
	
	
	
	
	public StudentProfileDTO getStudentProfile() {
		return studentProfile;
	}
		
	

	@FXML
    public void initialize() {	
		if(studentProfile.noIndeks()) {			
			mainView.openModal("addIndeksModal","Student nema indeks - unesite indeks");
		}
			
		imeIPrezimeLabel.setText(studentProfile.getImeSrednjeSlovoPrezime());
		jmbgLabel.setText(studentProfile.getJmbg());
		datumRodjenjaLabel.setText(studentProfile.getDatumRodjenja());
		adresaLabel.setText(studentProfile.getAdresa());
		emailLabel.setText(studentProfile.getEmail());
		brojTelefonaLabel.setText(studentProfile.getBrojTelefona());
		
	}
	
	
	
	
}
