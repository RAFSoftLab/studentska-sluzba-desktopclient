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
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.text.Text;

@Component
public class NastavnikController {
	
	@Autowired
	NastavnikServiceConsumer serviceConsumer;
	
	@Autowired
	CoderFactory coderFactory;
	
	// koristi se za otvaranje modalnih prozora
	
	@Autowired  
	MainView mainView;
	
	// forma ce se koristiti za unos novog i za azuriranje postojeceg studenta
	private Nastavnik nastavnikPodaci;

	
	@FXML private TextField imeTf;
	@FXML private TextField prezimeTf;
	@FXML private TextField srednjeImeTf;
	
	@FXML private Text actionTarget;
	
	@FXML private TextField emailTf;
	
	
	@FXML private TextField brojTelefonaTf;
	@FXML private TextField adresaPrebivalistaTf;
	
	
	// TODO dodati sliku
	
	public void handleSaveNastavnik(ActionEvent event) {
		// TODO dodati validacije za email, brojeve, obavezna polja
		if(nastavnikPodaci == null)
			nastavnikPodaci = new Nastavnik();
		nastavnikPodaci.setIme(imeTf.getText());
		nastavnikPodaci.setPrezime(prezimeTf.getText());
		nastavnikPodaci.setSrednjeIme(getTextIfNotEmpty(srednjeImeTf));
		nastavnikPodaci.setEmail(getTextIfNotEmpty(emailTf));
		nastavnikPodaci.setBrojTelefona(brojTelefonaTf.getText());
		nastavnikPodaci.setAdresa(getTextIfNotEmpty(adresaPrebivalistaTf));
		nastavnikPodaci.setBrojTelefona(getTextIfNotEmpty(brojTelefonaTf));
		
		
		try {
			Long id = serviceConsumer.saveNastavnik(nastavnikPodaci);
			if(id!=null) {
				System.out.println(id);
				actionTarget.setText("Nastavnik sačuvan");	
				nastavnikPodaci.setId(id);
			}else {
				actionTarget.setText("Došlo je do greške, podaci nisu sačuvaniii");
			}
		}catch(Exception e) {
			// TODO log
			e.printStackTrace();
			actionTarget.setText("Došlo je do greške, podaci nisu sačuvani");
		}	
	}
	
	@FXML
    public void initialize() {		
		// TODO TBD
		
    }
	
	private String getTextIfNotEmpty(TextField tf) {
		if(tf.getText().equals("")) return null;
		else return tf.getText();
	}
	
}
