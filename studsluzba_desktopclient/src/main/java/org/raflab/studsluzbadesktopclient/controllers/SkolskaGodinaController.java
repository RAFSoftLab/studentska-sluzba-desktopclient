package org.raflab.studsluzbadesktopclient.controllers;

import java.time.LocalDate;
import java.util.List;

import org.raflab.studsluzbadesktopclient.datamodel.SkolskaGodina;
import org.raflab.studsluzbadesktopclient.servercalls.AdminServiceConsumer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;

import static org.raflab.studsluzbadesktopclient.utils.TextInputUtils.*;

@Component
public class SkolskaGodinaController {
	
	
	@FXML TableView<SkolskaGodina> skolskaGodineTable;
	
	ObservableList<SkolskaGodina> skolskeGodineObservable;
	
	@FXML TextField pocetnaGodinaTf;

	@FXML TextField krajnjaGodinaTf;
	
	@FXML DatePicker datumPocetnaDp;
	
	@FXML CheckBox aktivnaChB;
	
	@Autowired
	AdminServiceConsumer adminSeviceConsumer;
	
	@FXML
	public void initialize() {		
		skolskeGodineObservable = FXCollections.observableArrayList(adminSeviceConsumer.getSkolskeGodine());
		skolskaGodineTable.setItems(skolskeGodineObservable);
		datumPocetnaDp.setValue(LocalDate.now());
		aktivnaChB.setSelected(true);
		krajnjaGodinaTf.setEditable(false);
		// kad se izgubi fokus za text field pocetne godine generise se tekst za krajnju
		pocetnaGodinaTf.focusedProperty().addListener((obs, oldVal, newVal) -> 
		{	if(!newVal) {
				int pocetna = getIntIfNotEmpty(pocetnaGodinaTf);
				krajnjaGodinaTf.setText(String.valueOf(pocetna+1));
			}
		});
		
	}

	@FXML public void handleSacuvajSkolskaGodina(ActionEvent event) {
		SkolskaGodina sk = new SkolskaGodina();
		sk.setPocetna(getIntIfNotEmpty(pocetnaGodinaTf));		
		sk.setAktivna(aktivnaChB.isSelected());
		sk.setDatumPocetka(datumPocetnaDp.getValue());
		adminSeviceConsumer.saveSkolskaGodina(sk);
		// ponovo ucitavamo tabelu sa servera, jer se tamo menja i prethodno aktivna skolska godina
		skolskeGodineObservable = FXCollections.observableArrayList(adminSeviceConsumer.getSkolskeGodine());
		skolskaGodineTable.setItems(skolskeGodineObservable);			
	}
	
	
	// TODO izmena skolske godine, selektuje se u tabeli i ucita se u formu za unos moze da se izmeni
}
