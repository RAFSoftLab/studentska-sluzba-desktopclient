package org.raflab.studsluzbadesktopclient.servercalls;

import java.util.ArrayList;
import java.util.List;

import org.raflab.studsluzbadesktopclient.coders.SimpleCode;
import org.raflab.studsluzbadesktopclient.datamodel.NastavnaNaucnaZvanja;
import org.raflab.studsluzbadesktopclient.datamodel.StudijskiProgram;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class SifarniciServisConsumer {
	
	@Autowired RestTemplate restTemplate;
	
	@Autowired String baseUrl;
	
	private final String CODER_URL_PATH = "/coder";
	
	public NastavnaNaucnaZvanja[] getSvaZvanja(){
		NastavnaNaucnaZvanja[] retVal = restTemplate.getForObject(createURL("zvanja", "all"), NastavnaNaucnaZvanja[].class);
		return retVal;
	}
	
	public List<SimpleCode> getBackendCoder(String coder){
		String[] retVal = restTemplate.getForObject(createURL(coder, "all"), String[].class);
		List<SimpleCode> rez = new ArrayList<SimpleCode>();
		for(String s:retVal) {
			rez.add(new SimpleCode(s));
		}		
		return rez;
	}
	
	private String createURL(String coderType, String pathEnd) {
		return baseUrl+CODER_URL_PATH+"/"+coderType+"/"+pathEnd;
	}
	
}
