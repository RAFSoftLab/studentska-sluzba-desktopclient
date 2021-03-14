package org.raflab.studsluzbadesktopclient.controllers;

import org.raflab.studsluzbadesktopclient.datamodel.SkolskaGodina;
import org.raflab.studsluzbadesktopclient.servercalls.AdminServiceConsumer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;


import javafx.fxml.FXML;
import javafx.scene.layout.BorderPane;

@Component
public class MainWindowController {
	
	@Autowired
    private ApplicationContext context;
	
	@FXML
	private BorderPane mainPane;
	
	
	
	
}
