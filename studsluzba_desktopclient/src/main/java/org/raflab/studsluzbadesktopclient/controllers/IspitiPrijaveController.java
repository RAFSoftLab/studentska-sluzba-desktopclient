package org.raflab.studsluzbadesktopclient.controllers;

import java.util.ArrayList;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.raflab.studsluzbadesktopclient.MainView;
import org.raflab.studsluzbadesktopclient.datamodel.DrziPredmet;
import org.raflab.studsluzbadesktopclient.datamodel.Ispit;
import org.raflab.studsluzbadesktopclient.datamodel.IspitniRok;
import org.raflab.studsluzbadesktopclient.datamodel.StudentIndeks;
import org.raflab.studsluzbadesktopclient.servercalls.IspitiServiceConsumer;
import org.raflab.studsluzbadesktopclient.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

@Component
public class IspitiPrijaveController {
	
	@Autowired
	IspitiServiceConsumer ispitiServiceConsumer;
	
	@Autowired
	MainView mainView;

	@FXML ComboBox<IspitniRok> ispitniRokoviCmb;
	@FXML TableView<Ispit> ispitiTable;

	@FXML TextField filterTf;
	
	private List<Ispit> ispitiURoku;

	@FXML TableView<StudentIndeks> studentiTable;
	
	@FXML
	public void initialize() {
		List<IspitniRok> rokoviAktivnaGodina = ispitiServiceConsumer.getIspitniRokoviForAktivna();
		ispitniRokoviCmb.setItems(FXCollections.observableArrayList(rokoviAktivnaGodina));	
		ispitiTable.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Ispit>() {

			@Override
			public void changed(ObservableValue<? extends Ispit> observable, Ispit oldValue, Ispit newValue) {
				if(newValue!=null) {
					List<StudentIndeks> prijavljeniStudenti = ispitiServiceConsumer.getPrijavljeniZaIspit(newValue.getId());
					studentiTable.setItems(FXCollections.observableArrayList(prijavljeniStudenti));
				}
			}		
		});
	}
	
	@FXML public void prikaziIspiteUTabeli() {
		ispitiURoku = ispitiServiceConsumer.getIspitiForRok(ispitniRokoviCmb.getValue().getId());
		ispitiTable.setItems(FXCollections.observableArrayList(ispitiURoku));		
	}

	@FXML public void filterTable() {		
		String ft = filterTf.getText();
		if(!ft.isEmpty() && ispitiURoku!=null) {
			List<Ispit> filteredIspit = ispitiURoku.stream().filter(ispit-> 
				StringUtils.atLeastOneContains(ft, ispit.getDatumOdrzavanja(), ispit.getDrziPredmet(), ispit.getMestoOdrzavanja(), ispit.getVremeOdrzavanja()))
				.collect(Collectors.toList());
			ispitiTable.setItems(FXCollections.observableArrayList(filteredIspit));
			ispitiTable.refresh();
		}		
	}

	

	public void handleOpenDodajPrijavljeneModal() {
		mainView.openModal("addPrijavaStudentaModal","Prijava studenata za ispit",700,400);
	}
	
	public Ispit getSelectedIspit() {
		return ispitiTable.getSelectionModel().getSelectedItem();
	}
	
	public void loadData() {
		List<StudentIndeks> prijavljeniStudenti = ispitiServiceConsumer.getPrijavljeniZaIspit(getSelectedIspit().getId());
		studentiTable.setItems(FXCollections.observableArrayList(prijavljeniStudenti));
		studentiTable.refresh();
		
	}

}
