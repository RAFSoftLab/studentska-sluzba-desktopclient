package org.raflab.studsluzbadesktopclient.coders;

import java.util.List;

import org.raflab.studsluzbadesktopclient.datamodel.SrednjaSkola;
import org.raflab.studsluzbadesktopclient.servercalls.SifarniciServisConsumer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CoderFactory {
	
	@Autowired
	SifarniciServisConsumer serviceConsumer;
	
	private Coder<SimpleCode> studProgramiCoder;
	private Coder<SimpleCode> drzaveCoder;
	private Coder<SimpleCode> mestaCoder;
	private Coder<SimpleCode> tipSrednjeSkole;
	
	private List<SrednjaSkola> srednjeSkole;
	
	
	// ucita samo ako nije ucitano
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
			case MESTO:				
				if(mestaCoder==null)
					mestaCoder = new TextFileSimpleCoder(coderType.getPath());
				return mestaCoder;
			case TIP_SREDNJE_SKOLE:
				if(tipSrednjeSkole==null)
					tipSrednjeSkole = new TextFileSimpleCoder(coderType.getPath());
				return tipSrednjeSkole;
			default: return null;
		}
			
		
		
		/*
		 * 
		 * 
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
	
	public List<SrednjaSkola> getSrednjeSkole(boolean useCache){
		if(!useCache || srednjeSkole==null) {			
			srednjeSkole = List.of(serviceConsumer.getSrednjeSkole());
		}
		return srednjeSkole;
	}
	
	

}
