package org.raflab.studsluzbadesktopclient.controllers;

import java.util.List;


import org.raflab.studsluzbadesktopclient.MainView;
import org.raflab.studsluzbadesktopclient.coders.CoderFactory;
import org.raflab.studsluzbadesktopclient.coders.CoderType;
import org.raflab.studsluzbadesktopclient.coders.SimpleCode;
import org.raflab.studsluzbadesktopclient.datamodel.PrviUpis;
import org.raflab.studsluzbadesktopclient.datamodel.SrednjaSkola;
import org.raflab.studsluzbadesktopclient.datamodel.StudentPodaci;
import org.raflab.studsluzbadesktopclient.servercalls.StudentServiceConsumer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.text.Text;

import static org.raflab.studsluzbadesktopclient.utils.TextInputUtils.*;

@Component
public class StudentPodaciController {
	
	@Autowired
	StudentServiceConsumer serviceConsumer;
	
	@Autowired
	CoderFactory coderFactory;
	
	// koristi se za otvaranje modalnih prozora
	
	@Autowired  
	MainView mainView;
	
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
	@FXML ComboBox<SimpleCode> mestoPrebivalistaCb;
	@FXML TextField adresaStanovanjaTf;
	
	@FXML ComboBox<SimpleCode> mestoStanovanjaCb;
	@FXML ComboBox<SimpleCode> mestoRodjenjaCb;

	@FXML ComboBox<SimpleCode> drzavaRodjenjaCb;

	@FXML ComboBox<SimpleCode> drzavljanstvoCb;

	@FXML TextField nacionalnostTf;

	@FXML TextField brojLicneKarteTf;

	@FXML TextField licnuKartuIzdaoTf;
	
	// prvi upis

	@FXML ComboBox<SrednjaSkola> srednjeSkolaCb;

	@FXML TextField strucnaSpremaTf;

	@FXML TextField uspehSrednjaSkolaTf;

	@FXML TextField uspehPrijemniTf;

	@FXML TextField godinaZavrsetkaSrednjeSkoleTf;

	@FXML TextField prelazSaVisokoskolskeUstanoveTf;

	@FXML TextField prethodnoZavrseneStudijeTf;

	@FXML TextField visokoskolskaUstanovaPrethodnihStudijaTf;

	@FXML TextField stecenoZvanjeTf;

	@FXML TextField prosecnaOcenaTf;

	@FXML DatePicker datumUpisaDp;

	@FXML TextArea napomenaTa;
	
	// TODO dodati sliku
	
	public void handleSaveStudent(ActionEvent event) {
		// TODO dodati validacije za email, brojeve, obavezna polja
		try {
		if(studentPodaci == null)
			studentPodaci = new StudentPodaci();
		
		// osnovni podaci
		studentPodaci.setIme(imeTf.getText());
		studentPodaci.setPrezime(prezimeTf.getText());
		studentPodaci.setSrednjeIme(getTextIfNotEmpty(srednjeImeTf));
		studentPodaci.setJmbg(getTextIfNotEmpty(jmbgTf));
		studentPodaci.setDatumRodjenja(datumRodjenjaDp.getValue());
		if(mestoRodjenjaCb.getValue()!=null) studentPodaci.setMestoPrebivalista(mestoRodjenjaCb.getValue().getCode());
		if(drzavaRodjenjaCb.getValue()!=null) studentPodaci.setDrzavaRodjenja(drzavaRodjenjaCb.getValue().getCode());
		if(drzavaRodjenjaCb.getValue()!=null) studentPodaci.setDrzavljanstvo(drzavljanstvoCb.getValue().getCode());
		studentPodaci.setNacionalnost(getTextIfNotEmpty(nacionalnostTf));
		studentPodaci.setBrojLicneKarte(getTextIfNotEmpty(brojLicneKarteTf));
		studentPodaci.setLicnuKartuIzdao(getTextIfNotEmpty(licnuKartuIzdaoTf));
		
		// kontakt podaci
		
		studentPodaci.setEmail(getTextIfNotEmpty(emailTf));
		studentPodaci.setBrojTelefona(getTextIfNotEmpty(brojTelefonaTf));
		studentPodaci.setAdresa(getTextIfNotEmpty(adresaPrebivalistaTf));
		studentPodaci.setAdresaStanovanja(getTextIfNotEmpty(adresaStanovanjaTf));
		if(mestoPrebivalistaCb.getValue()!=null) studentPodaci.setMestoPrebivalista(mestoPrebivalistaCb.getValue().getCode());
		if(mestoStanovanjaCb.getValue()!=null) studentPodaci.setMestoStanovanja(mestoStanovanjaCb.getValue().getCode());
		
		
		// prvi upis
		PrviUpis pu = null;
		if(studentPodaci.getPrviUpis()==null) {
			pu = new PrviUpis();
			studentPodaci.setPrviUpis(pu);
		}
		pu = studentPodaci.getPrviUpis();
		if(srednjeSkolaCb.getValue()!=null) pu.setZavrsenaSrednjaSkola(srednjeSkolaCb.getValue());
		pu.setStrucnaSprema(getTextIfNotEmpty(strucnaSpremaTf));
		pu.setUspehSrednjaSkola(getFloatIfNotEmpty(uspehSrednjaSkolaTf));
		pu.setUspehPrijemni(getFloatIfNotEmpty(uspehPrijemniTf));
		pu.setGodinaZavrsetkaSrednjeSkole(getIntIfNotEmpty(godinaZavrsetkaSrednjeSkoleTf));
		pu.setPrelazSaViskoskolskeUstanove(getTextIfNotEmpty(prelazSaVisokoskolskeUstanoveTf));
		pu.setPrethodnoZavrseneStudije(getTextIfNotEmpty(prethodnoZavrseneStudijeTf));
		pu.setVisokoskolsaUstanovaZavrsenihStudija(getTextIfNotEmpty(visokoskolskaUstanovaPrethodnihStudijaTf));
		pu.setStecenoZvanje(getTextIfNotEmpty(stecenoZvanjeTf));
		pu.setProsecnaOcenaNaPrethodnimStudijama(getFloatIfNotEmpty(prosecnaOcenaTf));
		
		pu.setDatumUpisa(datumUpisaDp.getValue());
		pu.setNapomena(getTextIfNotEmpty(napomenaTa));
			
		}catch(NumberFormatException e) {
			actionTarget.setText("Greška u formatu unetih podataka");
		}
		
		
		try {
			Long id = serviceConsumer.saveStudent(studentPodaci);
			if(id!=null) {				
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
		studentPodaci = null;  // TODO ispraviti da moze i da se azurira postojeci
		List<SimpleCode> drzavaCodes = coderFactory.getSimpleCoder(CoderType.DRZAVA).getCodes();
		drzavaRodjenjaCb.setItems(FXCollections.observableArrayList(drzavaCodes));
		drzavaRodjenjaCb.setValue(new SimpleCode("Republika Srbija"));
		drzavljanstvoCb.setItems(FXCollections.observableArrayList(drzavaCodes));
		drzavljanstvoCb.setValue(new SimpleCode("Republika Srbija"));
		List<SimpleCode> mestaCodes = coderFactory.getSimpleCoder(CoderType.MESTO).getCodes();
		ObservableList<SimpleCode> mestaCodesObservableList = FXCollections.observableArrayList(mestaCodes);
		mestoPrebivalistaCb.setItems(mestaCodesObservableList);
		mestoRodjenjaCb.setItems(mestaCodesObservableList);
		mestoStanovanjaCb.setItems(mestaCodesObservableList);
		List<SrednjaSkola> srednjeSkole = coderFactory.getSrednjeSkole(true);
		srednjeSkolaCb.setItems(FXCollections.observableArrayList(srednjeSkole));
		
    }
	
	public void handleOpenModalSrednjeSkole(ActionEvent ae) {
		// TODO brisanje i promena postojećih srednjih skola ?? strani ključ
		mainView.openModal("addSrednjaSkola");
		
	}
	
	
	
	public void updateSrednjeSkole() {
		List<SrednjaSkola> srednjeSkole = coderFactory.getSrednjeSkole(false);
		srednjeSkolaCb.setItems(FXCollections.observableArrayList(srednjeSkole));
	}
}
