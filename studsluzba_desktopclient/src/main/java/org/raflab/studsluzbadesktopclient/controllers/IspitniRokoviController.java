package org.raflab.studsluzbadesktopclient.controllers;

import java.util.List;

import org.raflab.studsluzbadesktopclient.datamodel.IspitniRok;
import org.raflab.studsluzbadesktopclient.datamodel.SkolskaGodina;
import org.raflab.studsluzbadesktopclient.servercalls.IspitiServiceConsumer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

@Controller
public class IspitniRokoviController {

	@FXML TableView<IspitniRok> ispitniRokoviTable;
	
	@FXML TextField nazivTf;
	
	@FXML DatePicker datumPocetkaDp;
	
	@FXML DatePicker datumZavrsetkaDp;
	
	@FXML DatePicker datumPocetkaPrijaveDp;
	
	@Autowired
	IspitiServiceConsumer ispitiServiceConsumer;
	
	@Autowired
	SkolskaGodina aktivnaSkolskaGodina;
	
	@FXML
	public void initialize() {
		List<IspitniRok> ispitniRokoviAktivna = ispitiServiceConsumer.getIspitniRokoviForAktivna();
		ispitniRokoviTable.setItems(FXCollections.observableArrayList(ispitniRokoviAktivna));
		
	}

	@FXML public void handleMouseClicked(MouseEvent event) {
		if(event.getClickCount()==2) {
			IspitniRok ir = ispitniRokoviTable.getSelectionModel().getSelectedItem();
			nazivTf.setText(ir.getNaziv());
			datumPocetkaDp.setValue(ir.getDatumPocetka());
			datumZavrsetkaDp.setValue(ir.getDatumZavrsetka());
			datumPocetkaPrijaveDp.setValue(ir.getDatumPocetkaPrijave());
		}
		
	}

	@FXML public void handleSacuvajIspitniRok() {
		IspitniRok ir = new IspitniRok();
		ir.setNaziv(nazivTf.getText());   // TODO validacija, naziv je obavezan
		ir.setDatumPocetka(datumPocetkaDp.getValue());
		ir.setDatumZavrsetka(datumZavrsetkaDp.getValue());
		ir.setDatumPocetkaPrijave(datumPocetkaPrijaveDp.getValue());
		ir.setSkolskaGodina(aktivnaSkolskaGodina);		
		ispitiServiceConsumer.saveIspitniRok(ir);
		resetForm();
	}

	@FXML public void handleIzmeniIspitniRok() {
		IspitniRok ir = ispitniRokoviTable.getSelectionModel().getSelectedItem();
		if(ir!=null) {
			ir.setNaziv(nazivTf.getText());   // TODO validacija, naziv je obavezan
			ir.setDatumPocetka(datumPocetkaDp.getValue());
			ir.setDatumZavrsetka(datumZavrsetkaDp.getValue());
			ir.setDatumPocetkaPrijave(datumPocetkaPrijaveDp.getValue());
			ispitiServiceConsumer.saveIspitniRok(ir);
			resetForm();
		}
		
	}
	
	private void resetForm() {
		nazivTf.setText("");
		datumPocetkaDp.setValue(null);
		datumZavrsetkaDp.setValue(null);
		datumPocetkaPrijaveDp.setValue(null);
		List<IspitniRok> ispitniRokoviAktivna = ispitiServiceConsumer.getIspitniRokoviForAktivna();
		ispitniRokoviTable.setItems(FXCollections.observableArrayList(ispitniRokoviAktivna));
		ispitniRokoviTable.refresh();
		
	}

	@FXML public void handleKeyPressed(KeyEvent event) {
		if(event.getCode()==KeyCode.DELETE) {
			// TODO pitanje da li ste sigurni
			ispitiServiceConsumer.deleteIspitniRok(ispitniRokoviTable.getSelectionModel().getSelectedItem().getId());
			resetForm();
		}
		
	}
	
	
	
}
