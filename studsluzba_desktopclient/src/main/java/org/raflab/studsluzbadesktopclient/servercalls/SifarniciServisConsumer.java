package org.raflab.studsluzbadesktopclient.servercalls;

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
	
	public StudijskiProgram[] getSviStudProgrami(){
		StudijskiProgram[] retVal = restTemplate.getForObject(createURL("studprogram", "all"), StudijskiProgram[].class);
		return retVal;
	}
	
	private String createURL(String coderType, String pathEnd) {
		return baseUrl+CODER_URL_PATH+"/"+coderType+"/"+pathEnd;
	}
	
}
