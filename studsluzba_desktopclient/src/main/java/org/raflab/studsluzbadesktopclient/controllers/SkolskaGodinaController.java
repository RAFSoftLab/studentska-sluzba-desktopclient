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
import javafx.scene.input.MouseEvent;

@Component
public class SkolskaGodinaController {
	
	
	@FXML TableView<SkolskaGodina> skolskeGodineTable;
	
	ObservableList<SkolskaGodina> skolskeGodineObservable;
	
	@FXML TextField pocetnaGodinaTf;

	@FXML TextField krajnjaGodinaTf;
	
	@FXML DatePicker datumPocetkaDp;
	
	@FXML CheckBox aktivnaChB;
	
	@Autowired
	AdminServiceConsumer adminSeviceConsumer;
	
	
	
	@FXML
	public void initialize() {		
		skolskeGodineObservable = FXCollections.observableArrayList(adminSeviceConsumer.getSkolskeGodine());
		skolskeGodineTable.setItems(skolskeGodineObservable);
		datumPocetkaDp.setValue(LocalDate.now());
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
		sk.setDatumPocetka(datumPocetkaDp.getValue());
		adminSeviceConsumer.saveSkolskaGodina(sk);
		resetForm();	
	}

	@FXML public void handleMouseClicked(MouseEvent event) {
		if(event.getClickCount()==2) {
			SkolskaGodina selektovanaSkGod = skolskeGodineTable.getSelectionModel().getSelectedItem();
			pocetnaGodinaTf.setText(String.valueOf(selektovanaSkGod.getPocetna()));
			krajnjaGodinaTf.setText(String.valueOf(selektovanaSkGod.getKrajnja()));
			datumPocetkaDp.setValue(selektovanaSkGod.getDatumPocetka());
			aktivnaChB.setSelected(selektovanaSkGod.isAktivna());
			
		}		
	}
	
	private void resetForm() {		
		pocetnaGodinaTf.setText("");
		krajnjaGodinaTf.setText("");
		datumPocetkaDp.setValue(LocalDate.now());
		aktivnaChB.setSelected(true);
		// ponovo ucitavamo tabelu sa servera, jer se prilikom cuvanja menja i prethodno aktivna skolska godina
		skolskeGodineObservable = FXCollections.observableArrayList(adminSeviceConsumer.getSkolskeGodine());		
		skolskeGodineTable.setItems(skolskeGodineObservable);	
		skolskeGodineTable.refresh();
		
	}
	
	/*
	 * menja skolsku godinu selektovanu u tabeli 
	 */
	@FXML public void handleIzmeniSkolskaGodina() {
		SkolskaGodina selektovanaSkGod = skolskeGodineTable.getSelectionModel().getSelectedItem();
		if(selektovanaSkGod!=null) {
			selektovanaSkGod.setAktivna(aktivnaChB.isSelected());
			selektovanaSkGod.setDatumPocetka(datumPocetkaDp.getValue());
			adminSeviceConsumer.saveSkolskaGodina(selektovanaSkGod);
			resetForm();	
		}
	}
	
}
