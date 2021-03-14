package org.raflab.studsluzbadesktopclient.servercalls;


import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.raflab.studsluzbadesktopclient.datamodel.DrziPredmet;
import org.raflab.studsluzbadesktopclient.datamodel.Nastavnik;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
public class NastavnikServiceConsumer {
	
	@Autowired RestTemplate restTemplate;
	
	@Autowired String baseUrl;
	
	private final String NASTAVNIK_URL_PATH = "/nastavnik"; 
	
	public Long saveNastavnik(@RequestBody Nastavnik np) {
	      HttpHeaders headers = new HttpHeaders();
	      headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	      HttpEntity <Nastavnik> entity = new HttpEntity<Nastavnik>(np, headers);
	      
	      return restTemplate.exchange
	    		  (createURL("add"), HttpMethod.POST, entity, Long.class).getBody();
	}
	
	private String createURL(String pathEnd) {
		return baseUrl+NASTAVNIK_URL_PATH+"/"+pathEnd;
	}
	
	
	public List<Nastavnik> searchNastavnik(String ime, String prezime) {  	      	
	      UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(createURL("search"));
	      if(ime!=null) builder.queryParam("ime", ime);
	      if(prezime!=null) builder.queryParam("prezime", prezime);    	    		  
	      ResponseEntity<Nastavnik[]> response = restTemplate.getForEntity(builder.toUriString(), Nastavnik[].class, HttpMethod.GET);
	      if(response.getStatusCode()==HttpStatus.OK)
	    	  return List.of(response.getBody());
	      else return null;  	    		  
	}
	
	public List<Nastavnik> getAllNastavnik(){
		Nastavnik[] nastavnici = restTemplate.getForObject(createURL("all"), Nastavnik[].class);
		return List.of(nastavnici);
	}
	
}
