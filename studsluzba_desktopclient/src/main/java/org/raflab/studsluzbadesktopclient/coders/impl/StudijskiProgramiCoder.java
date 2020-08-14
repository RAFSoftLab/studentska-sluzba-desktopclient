package org.raflab.studsluzbadesktopclient.coders.impl;

import java.util.ArrayList;

import org.raflab.studsluzbadesktopclient.coders.Coder;
import org.raflab.studsluzbadesktopclient.coders.SimpleCode;
import org.raflab.studsluzbadesktopclient.datamodel.StudijskiProgram;
import org.raflab.studsluzbadesktopclient.servercalls.SifarniciServisConsumer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class StudijskiProgramiCoder extends Coder<SimpleCode> {
	
	@Autowired
	SifarniciServisConsumer serviceConsumer;
	
	// svaki put kada se otvori forma ucitava se
		
	@Override
	public void loadCodes() {		
		codes = new ArrayList<SimpleCode>();
		StudijskiProgram[] programi = serviceConsumer.getSviStudProgrami();
		for(StudijskiProgram sp:programi) {
			codes.add(new SimpleCode(sp.getOznaka()));			
			
		}
	}

}
