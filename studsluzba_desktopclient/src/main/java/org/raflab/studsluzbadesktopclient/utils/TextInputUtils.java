package org.raflab.studsluzbadesktopclient.utils;

import javafx.scene.control.Label;
import javafx.scene.control.TextInputControl;
import javafx.scene.text.Text;

public class TextInputUtils {
	
	public static String getTextIfNotEmpty(TextInputControl tf) {
		if(tf.getText().equals("")) return null;
		else return tf.getText();
	}
	
	public static Float getFloatIfNotEmpty(TextInputControl tf) {
		if(tf.getText().equals("")) return (float)0.0;
		else {
			try {
				return Float.parseFloat(tf.getText());				
			}catch(NumberFormatException e) {			
				return (float)0.0;
			}
			
		}
		
	}
	
	public static Integer getIntIfNotEmpty(TextInputControl tf) {
		if(tf.getText().equals("")) return 0;
		else {
			try {
				return Integer.parseInt(tf.getText());				
			}catch(NumberFormatException e) {
				
				return 0;
			}
			
		}
		
	}
	
		
	
	

}
