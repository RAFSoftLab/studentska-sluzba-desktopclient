package org.raflab.studsluzbadesktopclient.coders;


/**
 * Šifarnik koji nema vrednost, samo šifru, na primer zvanje, ispitni rok
 * @author bojanads
 *
 */
public class SimpleCode extends AbstractCode {
	
	
	public SimpleCode(String code) {
		super(code);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getValue() {		
		return null;
	}

	@Override
	public String toString() {
		return getCode();
	}
	
	

}
