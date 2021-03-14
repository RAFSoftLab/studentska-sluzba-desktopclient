package org.raflab.studsluzbadesktopclient.controllers;

import static org.raflab.studsluzbadesktopclient.utils.TextInputUtils.getIntIfNotEmpty;
import static org.raflab.studsluzbadesktopclient.utils.TextInputUtils.getTextIfNotEmpty;

import java.time.LocalDate;
import java.util.List;

import org.raflab.studsluzbadesktopclient.datamodel.ObnovaGodine;
import org.raflab.studsluzbadesktopclient.datamodel.PolozenPredmet;
import org.raflab.studsluzbadesktopclient.datamodel.Predmet;
import org.raflab.studsluzbadesktopclient.datamodel.SkolskaGodina;
import org.raflab.studsluzbadesktopclient.datamodel.UpisGodine;
import org.raflab.studsluzbadesktopclient.servercalls.TokStudijaServisConsumer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

@Component
public class StudentProfileObnovaModalController {
	
	@FXML DatePicker datum;
	@FXML TextField godina;
	@FXML TextArea napomena;
	@FXML TextField uplataIznos;
	
	@FXML ListView<Predmet>  listaNepolozeni;
	
	@Autowired
	TokStudijaServisConsumer tokStudijaServiceConsumer;
	
	@Autowired
	StudentProfileController studentProfileController;
	
	
	@Autowired
	StudentProfileUpisObnovaController upisObnovaController;
	
	@Autowired
	SkolskaGodina aktivnaSkolskaGodina;
	
	@FXML TextField ukupnoEspbTf;
	
	@FXML
    public void initialize() {		
		datum.setValue(LocalDate.now());
		listaNepolozeni.setItems(FXCollections.observableArrayList(studentProfileController.getStudentProfile().getNepolozeniPredmeti()));
		listaNepolozeni.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE); // selektujemo predmete koje upisuje
		ukupnoEspbTf.setEditable(false);
		listaNepolozeni.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Predmet>() {

			@Override
			public void changed(ObservableValue<? extends Predmet> observable, Predmet oldValue, Predmet newValue) {
				List<Predmet> selektovani = listaNepolozeni.getSelectionModel().getSelectedItems();
				Integer sumaEspb = selektovani.stream().mapToInt(Predmet::getEspb).sum();
				ukupnoEspbTf.setText(String.valueOf(sumaEspb));				
			}		
		});
	}
	
	public void handleSacuvajObnovu(ActionEvent event) {
		ObnovaGodine og = new ObnovaGodine();
		og.setDatumObnove(datum.getValue());
		og.setGodinaKojuObnavlja(getIntIfNotEmpty(godina));
		og.setNapomena(getTextIfNotEmpty(napomena));
		og.setStudentIndeks(studentProfileController.getStudentProfile().getAktivanIndeks());		
		og.setUpisujePredmete(listaNepolozeni.getSelectionModel().getSelectedItems());
		og.setSkolskaGodina(aktivnaSkolskaGodina);
		Long id = tokStudijaServiceConsumer.saveObnova(og);
		og.setId(id);		
		upisObnovaController.addObnovaGodine(og);		
		closeStage(event);
	}
	
	private void closeStage(ActionEvent event) {
        Node  source = (Node)  event.getSource(); 
        Stage stage  = (Stage) source.getScene().getWindow();
        stage.close();
    }
	

}
