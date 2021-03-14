package org.raflab.studsluzbadesktopclient.coders;

import org.raflab.studsluzbadesktopclient.servercalls.SifarniciServiceConsumer;
import org.springframework.beans.factory.annotation.Autowired;

public class BackendSimpleCoder extends Coder<SimpleCode>  {
	
	private SifarniciServiceConsumer serviceConsumer;
	
	private String coderPath;
	
	public BackendSimpleCoder(String coderPath, SifarniciServiceConsumer serviceConsumer) {		
		this.coderPath = coderPath;
		this.serviceConsumer = serviceConsumer;
		loadCodes();
	}
		
	@Override
	public void loadCodes() {		
		if(codes==null)
			codes = serviceConsumer.getBackendCoder(coderPath);
		
	}
	
}
