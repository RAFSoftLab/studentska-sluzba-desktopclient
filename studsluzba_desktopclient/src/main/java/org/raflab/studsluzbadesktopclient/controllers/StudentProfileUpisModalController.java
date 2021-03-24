package org.raflab.studsluzbadesktopclient.controllers;

import java.time.LocalDate;
import java.util.List;

import org.raflab.studsluzbadesktopclient.datamodel.PolozenPredmet;
import org.raflab.studsluzbadesktopclient.datamodel.Predmet;
import org.raflab.studsluzbadesktopclient.datamodel.SkolskaGodina;
import org.raflab.studsluzbadesktopclient.datamodel.UpisGodine;
import org.raflab.studsluzbadesktopclient.servercalls.AdminServiceConsumer;
import org.raflab.studsluzbadesktopclient.servercalls.TokStudijaServisConsumer;
import org.raflab.studsluzbadesktopclient.utils.SortUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.control.TextArea;

import static org.raflab.studsluzbadesktopclient.utils.TextInputUtils.getFloatIfNotEmpty;
import static org.raflab.studsluzbadesktopclient.utils.TextInputUtils.getIntIfNotEmpty;
import static org.raflab.studsluzbadesktopclient.utils.TextInputUtils.getTextIfNotEmpty;

@Component
public class StudentProfileUpisModalController {
	
	
	@FXML DatePicker datum;
	@FXML TextField godina;
	@FXML TextArea napomena;
	@FXML TextField uplataIznos;
	
	@FXML ListView<Predmet>  listaNepolozeni;
	
	@FXML ComboBox<SkolskaGodina> skolskeGodineCB;
	
	@Autowired
	TokStudijaServisConsumer tokStudijaServiceConsumer;
	
	@Autowired
	StudentProfileController studentProfileController;
	
	
	@Autowired
	StudentProfileUpisObnovaController upisObnovaController;
	
	@Autowired
	SkolskaGodina aktivnaSkolskaGodina;
	
	@Autowired
	AdminServiceConsumer adminServiceConsumer;
	
	@FXML
    public void initialize() {		
		datum.setValue(LocalDate.now());
		listaNepolozeni.setItems(FXCollections.observableArrayList(studentProfileController.getStudentProfile().getNepolozeniPredmeti()));
		List<SkolskaGodina> skolskeGodine = adminServiceConsumer.getSkolskeGodine();
		SortUtils.sortSkolskeGodineDSC(skolskeGodine);
		skolskeGodineCB.setItems(FXCollections.observableArrayList(skolskeGodine));
	}
	
	public void handleSacuvajUpis(ActionEvent event) {
		UpisGodine ug = new UpisGodine();
		ug.setDatumUpisa(datum.getValue());
		ug.setGodinaKojaSeUpisuje(getIntIfNotEmpty(godina));
		ug.setNapomena(getTextIfNotEmpty(napomena));
		ug.setStudentIndeks(studentProfileController.getStudentProfile().getAktivanIndeks());		
		ug.setPredmeti(listaNepolozeni.getItems());
		ug.setSkolskaGodina(skolskeGodineCB.getValue());
		Long id = tokStudijaServiceConsumer.saveUpis(ug);
		ug.setId(id);		
		upisObnovaController.addUpisGodine(ug);		
		closeStage(event);
	}
	
	private void closeStage(ActionEvent event) {
        Node  source = (Node)  event.getSource(); 
        Stage stage  = (Stage) source.getScene().getWindow();
        stage.close();
    }
	
	

}
