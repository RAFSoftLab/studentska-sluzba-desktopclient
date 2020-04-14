package org.raflab.studsluzba_desktopclient;

import javafx.application.Application;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("searchStudent"), 640, 480);
        
        stage.setScene(scene);
        stage.show();
    }

    public static void setRoot(String fxml) {
        try {
			scene.setRoot(loadFXML(fxml));
		} catch (IOException e) {			
			e.printStackTrace();
		}
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }

}