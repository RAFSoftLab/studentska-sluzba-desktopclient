package org.raflab.studsluzbadesktopclient.controllers;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.raflab.studsluzbadesktopclient.datamodel.DrziPredmet;
import org.raflab.studsluzbadesktopclient.datamodel.Ispit;
import org.raflab.studsluzbadesktopclient.datamodel.IspitniRok;
import org.raflab.studsluzbadesktopclient.servercalls.IspitiServiceConsumer;
import org.raflab.studsluzbadesktopclient.servercalls.RaspodelaNastaveServiceConsumer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.ListView;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;

import static org.raflab.studsluzbadesktopclient.utils.TextInputUtils.*;

@Component
public class IspitiUnosController {
	
		@FXML ComboBox<IspitniRok> ispitniRokoviCmb;	

		@FXML TableView<Ispit> ispitiTable;
		
		
		@Autowired
		IspitiServiceConsumer ispitiServiceConsumer;
		
		@Autowired
		RaspodelaNastaveServiceConsumer raspodelaNastaveServiceConsumer;

		@FXML ListView<DrziPredmet> drziPredmetLW;

		@FXML DatePicker datumDp;

		@FXML TextField vremeTf;

		@FXML TextField mestoTf;
		
		@FXML TextField filterDrziPredmetTf;
		
		private List<DrziPredmet> drziPredmetList;
		
		
		@FXML
		public void initialize() {
			// TODO da li staviti na jedno mesto ucitane rokove, i druge stvari koje se koriste u više formi?  
			List<IspitniRok> rokoviAktivnaGodina = ispitiServiceConsumer.getIspitniRokoviForAktivna();
			ispitniRokoviCmb.setItems(FXCollections.observableArrayList(rokoviAktivnaGodina));		
			drziPredmetList = raspodelaNastaveServiceConsumer.getDrziPredmetUAktivnojSkolskojGodini();
			drziPredmetLW.setItems(FXCollections.observableArrayList(drziPredmetList));		
			
			
		}


		@FXML public void handleMouseClicked(MouseEvent event) {
			if(event.getClickCount()==2) {
				Ispit selectedIspit = ispitiTable.getSelectionModel().getSelectedItem();
				datumDp.setValue(selectedIspit.getDatumOdrzavanja());
				mestoTf.setText(selectedIspit.getMestoOdrzavanja());
				if(selectedIspit.getVremeOdrzavanja()!=null) 
					vremeTf.setText(selectedIspit.getVremeOdrzavanja().getHour()+":"+selectedIspit.getVremeOdrzavanja().getMinute());
				else
					vremeTf.setText("");
				drziPredmetLW.setItems(FXCollections.observableArrayList(drziPredmetList));			
				drziPredmetLW.getSelectionModel().select(selectedIspit.getDrziPredmet());
			}
			
		}


		@FXML public void uveziIspiteIzFajla() {
			// TODO Automatizovani unos ispita iz fajla
		}


		@FXML public void prikaziIspiteUTabeli() {
			List<Ispit> ispitiURoku = ispitiServiceConsumer.getIspitiForRok(ispitniRokoviCmb.getValue().getId());
			ispitiTable.setItems(FXCollections.observableArrayList(ispitiURoku));
			
		}


		@FXML public void handleFilterDrziPredmet() {
			List<DrziPredmet> drziPredmetNewList = new ArrayList<>();			
			String filterText = filterDrziPredmetTf.getText();			
			drziPredmetList.stream().forEach(e -> {					
					if(filterText.equals("") || e.toString().toLowerCase().contains(filterText))
							drziPredmetNewList.add(e);					
			});	
			drziPredmetLW.setItems(FXCollections.observableArrayList(drziPredmetNewList));
			
		}


		@FXML public void handleIzmeniIspit() {
			// TODO dodati ogranicenje da ispit ne moze da se menja od nekog trenutka - kada pocnu prijave ili kada prodje datum
			Ispit i = ispitiTable.getSelectionModel().getSelectedItem();
			if(ispitniRokoviCmb.getValue()!=null && drziPredmetLW.getSelectionModel().getSelectedItem()!=null) {
				i.setIspitniRok(ispitniRokoviCmb.getValue());
				i.setDatumOdrzavanja(datumDp.getValue());
				i.setMestoOdrzavanja(mestoTf.getText());
				i.setVremeOdrzavanja(getLocalTime(vremeTf));
				i.setDrziPredmet(drziPredmetLW.getSelectionModel().getSelectedItem());
				ispitiServiceConsumer.saveIspit(i);
				resetForm();
			}	
			
		}


		@FXML public void handleSacuvajIspit(ActionEvent event) {
			Ispit i = new Ispit();
			if(ispitniRokoviCmb.getValue()!=null && drziPredmetLW.getSelectionModel().getSelectedItem()!=null) {
				i.setIspitniRok(ispitniRokoviCmb.getValue());
				i.setDatumOdrzavanja(datumDp.getValue());
				i.setMestoOdrzavanja(mestoTf.getText());
				i.setVremeOdrzavanja(getLocalTime(vremeTf));
				i.setDrziPredmet(drziPredmetLW.getSelectionModel().getSelectedItem());
				ispitiServiceConsumer.saveIspit(i);
				resetForm();
			}
			
		}
		
		private void resetForm() {
			if(ispitniRokoviCmb.getSelectionModel().getSelectedItem()!=null) {
				List<Ispit> ispitiURoku = ispitiServiceConsumer.getIspitiForRok(ispitniRokoviCmb.getValue().getId());
				ispitiTable.setItems(FXCollections.observableArrayList(ispitiURoku));
				datumDp.setValue(null);
				mestoTf.setText("");
				vremeTf.setText("");
				drziPredmetLW.getSelectionModel().clearSelection();
					
			}		
			
		}
		
		
		
}
