package org.raflab.studsluzbadesktopclient.coders;

import org.raflab.studsluzbadesktopclient.servercalls.SifarniciServisConsumer;
import org.springframework.beans.factory.annotation.Autowired;

public class BackendSimpleCoder extends Coder<SimpleCode>  {
	
	private SifarniciServisConsumer serviceConsumer;
	
	private String coderPath;
	
	public BackendSimpleCoder(String coderPath, SifarniciServisConsumer serviceConsumer) {		
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
