package org.raflab.studsluzbadesktopclient.servercalls;

import java.util.List;

import org.raflab.studsluzbadesktopclient.datamodel.Nastavnik;
import org.raflab.studsluzbadesktopclient.datamodel.Predmet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class PredmetServiceConsumer {
	
	@Autowired RestTemplate restTemplate;
	
	@Autowired String baseUrl;
	
	private final String PREDMET_URL_PATH = "/predmet"; 
	
	private String createURL(String pathEnd) {
		return baseUrl+PREDMET_URL_PATH+"/"+pathEnd;
	}
	
	public List<Predmet> getAllPredmet(){
		Predmet[] predmeti = restTemplate.getForObject(createURL("all"), Predmet[].class);
		return List.of(predmeti);
	}
		
}
