package org.raflab.studsluzbadesktopclient.controllers;

import org.raflab.studsluzbadesktopclient.MainView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javafx.event.ActionEvent;

@Component
public class StudentProfileSideBarController {
	
	
	
	@Autowired
	MainView mainView;
	
	public void handleOpenProfilePolozeniPredmeti(ActionEvent ae) {		
		mainView.changeRoot("studentProfilePolozeniPredmeti");
		
	}
	
	public void handleOpenProfilePodaci(ActionEvent ae) {		
		mainView.changeRoot("studentProfilePodaci");
		
	}
	
	public void handleOpenProfileUpisObnove(ActionEvent ae) {		
		mainView.changeRoot("studentProfileUpisObnova");
		
	}
	
	

}
