package org.raflab.studsluzbadesktopclient.coders;

import org.raflab.studsluzbadesktopclient.servercalls.SifarniciServisConsumer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CoderFactory {
	
	@Autowired
	SifarniciServisConsumer serviceConsumer;
	
	private Coder<SimpleCode> studProgramiCoder;
	private Coder<SimpleCode> drzaveCoder;
	
	public Coder<SimpleCode> getSimpleCoder(CoderType coderType){
		
		switch(coderType) {
			case STUDIJSKI_PROGRAM: 
				if(studProgramiCoder==null)
					studProgramiCoder = new BackendSimpleCoder(coderType.getPath(),serviceConsumer);
				return studProgramiCoder;	
				
			case DRZAVA: 
				if(drzaveCoder==null)
					drzaveCoder = new TextFileSimpleCoder(coderType.getPath());
				return drzaveCoder;
			default: return null;
		}
			
		
		
		/*
		 * 
		 * TODO resiti pomocu refleksije 
		Class<?> c;
		try {
			c = Class.forName(coderType.getClass().getName());
			Constructor<?> cons = c.getConstructor(String.class);
			Coder<? extends AbstractCode> object = (Coder<? extends AbstractCode>)cons.newInstance(coderType.getPath());		
			return object;
		} catch (Exception e) {		
			e.printStackTrace();
			return null;
		}
		*/
		
		
	}

}
