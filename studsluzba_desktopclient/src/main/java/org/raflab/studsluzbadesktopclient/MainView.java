package org.raflab.studsluzbadesktopclient;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;

@Component
public class MainView {
	
	@Autowired
	ContextFXMLLoader appFXMLLoader;
	 
	
	private Scene scene;
	
	public Scene createScene() {	  
	  try {		  
		  FXMLLoader loader = appFXMLLoader.getLoader(MainView.class.getResource("/fxml/main.fxml"));
		  BorderPane borderPane = loader.load();
		  this.scene = new Scene(borderPane);
		  scene.getStylesheets().add(MainView.class.getResource("/css/stylesheet.css").toExternalForm());
	  } catch (IOException e) {
		  e.printStackTrace();
	  }
	  return this.scene;
	 }
	
		
	
	public void changeRoot(String fxml) {
		FXMLLoader loader = appFXMLLoader.getLoader(MainView.class.getResource("/fxml/"+fxml+".fxml"));
		try {
			scene.setRoot(loader.load());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
