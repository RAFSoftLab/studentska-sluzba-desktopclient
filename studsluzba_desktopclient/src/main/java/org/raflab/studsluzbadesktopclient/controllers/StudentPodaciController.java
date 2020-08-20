package org.raflab.studsluzbadesktopclient.controllers;

import java.util.List;

import org.raflab.studsluzbadesktopclient.MainView;
import org.raflab.studsluzbadesktopclient.coders.CoderFactory;
import org.raflab.studsluzbadesktopclient.coders.CoderType;
import org.raflab.studsluzbadesktopclient.coders.SimpleCode;
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
	// TODO da li i mesta da idu preko sifarnika
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
		if(studentPodaci == null)
			studentPodaci = new StudentPodaci();
		studentPodaci.setIme(imeTf.getText());
		studentPodaci.setPrezime(prezimeTf.getText());
		studentPodaci.setSrednjeIme(getTextIfNotEmpty(srednjeImeTf));
		studentPodaci.setDatumRodjenja(datumRodjenjaDp.getValue());
		studentPodaci.setEmail(getTextIfNotEmpty(emailTf));
		studentPodaci.setBrojTelefona(brojTelefonaTf.getText());
		studentPodaci.setAdresa(getTextIfNotEmpty(adresaPrebivalistaTf));
		studentPodaci.setAdresaStanovanja(getTextIfNotEmpty(adresaStanovanjaTf));
		studentPodaci.setBrojLicneKarte(getTextIfNotEmpty(brojLicneKarteTf));
		studentPodaci.setBrojTelefona(getTextIfNotEmpty(brojTelefonaTf));
		studentPodaci.setDrzavaRodjenjaCode(drzavaRodjenjaCb.getValue().getCode());
		studentPodaci.setDrzavljanstvoCode(drzavljanstvoCb.getValue().getCode());
		studentPodaci.setJmbg(getTextIfNotEmpty(jmbgTf));
		studentPodaci.setLicnuKartuIzdao(getTextIfNotEmpty(licnuKartuIzdaoTf));
		
		
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
		// TODO kreirati modal window za dodavanje nove srednje skole, mozda i brisanje i promena postojećih ?? strani ključ
		mainView.openModal("addSrednjaSkola");
		
	}
	
	private String getTextIfNotEmpty(TextField tf) {
		if(tf.getText().equals("")) return null;
		else return tf.getText();
	}
	
	public void updateSrednjeSkole() {
		List<SrednjaSkola> srednjeSkole = coderFactory.getSrednjeSkole(false);
		srednjeSkolaCb.setItems(FXCollections.observableArrayList(srednjeSkole));
	}
}
