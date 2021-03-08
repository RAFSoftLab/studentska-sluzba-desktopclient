package org.raflab.studsluzbadesktopclient.controllers;

import org.raflab.studsluzbadesktopclient.datamodel.StudentProfileDTO;
import org.raflab.studsluzbadesktopclient.utils.IndeksFormater;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

@Controller
public class StudentProfileRightBarController {
	
	@FXML private ImageView studentImage;
	
	@Autowired
	StudentProfileController studentProfileController;
	
	@FXML Text studentPodaciText;
	

	@FXML
    public void initialize() {		
		StudentProfileDTO studentProfile = studentProfileController.getStudentProfile();
		studentImage.setImage(new Image(this.getClass().getResourceAsStream("/fxml/img/student-slikaprimer.jpeg")));
		String text = "Profil studenta: \n"+studentProfile.getIme()+"\n"+studentProfile.getPrezime() + "\nIndeks:\n"+IndeksFormater.formatIndeks(studentProfile.getAktivanIndeks());
		studentPodaciText.setText(text);	
		
    }
	
	
	

}
